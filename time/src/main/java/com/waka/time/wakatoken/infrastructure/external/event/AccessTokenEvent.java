package com.waka.time.wakatoken.infrastructure.external.event;

import com.waka.time.wakatoken.application.port.out.WakaAccessTokenResponse;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * <h1>AccessTokenEvent</h1>
 * AccessTokenPublisher가 발행하는 이벤트
 *
 * <ul>
 *   <li>accessTokenResponses: 발행할 AccessToken 응답 리스트</li>
 * </ul>
 *
 * @author 박석원
 * @updated 2025-04-27
 */
@Getter
@Builder
public class AccessTokenEvent {
    private final List<WakaAccessTokenResponse> accessTokenResponses;
}
