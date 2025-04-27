package com.waka.time.wakatoken.infrastructure.external;

import com.waka.time.wakatoken.application.port.out.WakaAccessTokenResponse;
import com.waka.time.wakatoken.application.service.WakaAuthService;
import com.waka.time.wakatoken.infrastructure.external.event.AccessTokenEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AccessTokenPublisher {
    private final WakaAuthService wakaAuthService;
    private final ApplicationEventPublisher eventPublisher;

    @Value("${access-token.publishing.size}")
    private int pageSize;

    /**
     * <h1>모든 AccessToken을 50개 단위로 조회하여 AccessTokenEvent를 비동기로 발행한다.</h1>
     * <ul>
     *   <li>pageSize 크기만큼 페이징 조회</li>
     *   <li>조회된 데이터가 있을 때마다 AccessTokenEvent를 발행</li>
     *   <li>더 이상 데이터가 없거나, 마지막 페이지인 경우 종료</li>
     * </ul>
     *
     * @author 박석원
     * @updated 2025-04-27
     */
    @Async
    public void publishAllAccessTokens() {
        int page = 0;
        boolean hasNext = true;

        while(hasNext) {
            Pageable pageable = PageRequest.of(page, pageSize);
            List<WakaAccessTokenResponse> tokenResponses = wakaAuthService.findWakaAccessTokenResponsesByPage(pageable);

            if (tokenResponses.isEmpty()){
                hasNext = false;
            } else {
                eventPublisher.publishEvent(AccessTokenEvent.builder().accessTokenResponses(tokenResponses).build());
                if (tokenResponses.size() < pageSize){
                    hasNext = false;
                } else {
                    page++;
                }
            }
        }
    }
}
