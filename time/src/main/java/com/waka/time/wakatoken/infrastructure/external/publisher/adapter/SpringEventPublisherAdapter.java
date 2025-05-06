package com.waka.time.wakatoken.infrastructure.external.publisher.adapter;

import com.waka.time.event.accesstoken.AccessTokenPayload;
import com.waka.time.wakatoken.application.port.out.AccessTokenEventPublisher;
import com.waka.time.wakatoken.application.port.out.WakaAccessTokenResponse;
import com.waka.time.event.accesstoken.AccessTokenEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <h1>SpringEventPublisherAdapter</h1>
 * Spring의 ApplicationEventPublisher를 이용해 AccessTokenEvent를 발행하는 어댑터
 *
 * <ul>
 *   <li>AccessTokenEventPublisher 인터페이스 구현체</li>
 *   <li>Spring의 이벤트 시스템을 통해 도메인 이벤트 전달</li>
 * </ul>
 *
 * @author 박석원
 * @updated 2025-05-06
 */
@Component
@Qualifier("springPublisher")
@RequiredArgsConstructor
public class SpringEventPublisherAdapter implements AccessTokenEventPublisher {
    private final ApplicationEventPublisher springEventPublisher;

    @Override
    public void publish(List<WakaAccessTokenResponse> tokenResponses) {
        springEventPublisher.publishEvent(
                AccessTokenEvent.builder()
                        .accessTokenPayload(AccessTokenPayload.fromResponse(tokenResponses))
                        .build()
        );
    }
}
