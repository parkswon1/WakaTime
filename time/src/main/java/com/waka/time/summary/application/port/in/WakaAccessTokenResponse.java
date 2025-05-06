package com.waka.time.summary.application.port.in;

import lombok.Builder;
import lombok.Getter;

/**
 * <h1>WakaAccessTokenResponse</h1>
 * AccessToken 처리 결과를 나타내는 응답 객체
 *
 * <ul>
 *   <li>userId: 사용자 ID</li>
 *   <li>wakaId: WakaTime 사용자 식별자</li>
 *   <li>accessToken: 발급된 액세스 토큰</li>
 * </ul>
 * @author 박석원
 * @updated 2025-05-06
 */
@Getter
@Builder
public class WakaAccessTokenResponse {
    private String userId;
    private String wakaId;
    private String accessToken;
}
