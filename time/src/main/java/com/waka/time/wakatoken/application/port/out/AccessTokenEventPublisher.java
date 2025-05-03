package com.waka.time.wakatoken.application.port.out;

import java.util.List;

/**
 * <h1>AccessTokenEventPublisher</h1>
 * {@link WakaAccessTokenResponse}리스트를 외부로 퍼블리싱하는 출력 포트
 *
 * @author 박석원
 * @updated 2025-05-03
 */
public interface AccessTokenEventPublisher {
    void publish(List<WakaAccessTokenResponse> tokens);
}
