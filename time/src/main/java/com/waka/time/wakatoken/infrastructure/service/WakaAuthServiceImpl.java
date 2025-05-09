package com.waka.time.wakatoken.infrastructure.service;

import com.waka.time.wakatoken.application.port.out.WakaAccessTokenResponse;
import com.waka.time.wakatoken.application.service.WakaAuthService;
import com.waka.time.wakatoken.domain.model.WakaToken;
import com.waka.time.wakatoken.domain.repository.WakaTokenRepository;
import com.waka.time.wakatoken.infrastructure.external.WakaOAuthClient;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WakaAuthServiceImpl implements WakaAuthService {
    private final WakaOAuthClient wakaOAuthClient;
    private final WakaTokenRepository wakaTokenRepository;

    @Override
    public void authenticate(String code, String userId) {
        WakaToken token = wakaOAuthClient.requestToken(code, userId);
        wakaTokenRepository.save(token);
    }

    /**
     * <h1>사용자 Id를 통해서 WakaToken을 받아옴</h1>
     * @param userId 사용자 ID
     * @return {@code WakaToken}
     *
     * @author 박석원
     * @updated 2025-04-14
     */
    @Override
    public WakaToken findByUserId(String userId) {
        return wakaTokenRepository.findByUserId(userId)
                .orElseThrow(()->
                        new IllegalArgumentException("사용자 아이디로 찾을 수 있는 토큰이 없습니다. 사용자 Id :" + userId)
                );
    }

    /**
     * <h1>page 정보를 받아서 {@link WakaAccessTokenResponse}를 반환함</h1>
     * <ul>
     *  <li>Pageable 정보를 기반으로 WakaAccessTokenResponse를 페이징 조회한다.</li>
     * </ul>
     *
     * @param pageable 페이지 요청 정보
     * @return {@link List}<{@link WakaAccessTokenResponse}>
     * @author 박석원
     * @updated 2025-04-27
     */
    @Override
    public List<WakaAccessTokenResponse> findWakaAccessTokenResponsesByPage(Pageable pageable) {
        return wakaTokenRepository.findAll(pageable)
                .stream()
                .map(WakaAccessTokenResponse::fromDomain)
                .toList();
    }
}