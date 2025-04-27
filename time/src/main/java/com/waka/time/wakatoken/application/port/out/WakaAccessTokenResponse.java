package com.waka.time.wakatoken.application.port.out;

import com.waka.time.wakatoken.domain.model.WakaToken;
import lombok.Builder;
import lombok.Getter;

/**
 * <h1>WakaTime으로 요청을 보낼때 사용할 accessToken을 담을 DTO</h1>
 * <ul>
 *  <li> <b>userId</b> : 사용자 ID
 *  <li> <b>wakaId</b> : WakaTime에서 사용하는 Id
 *  <li> <b>accessToken</b> : 사용자 accessToken
 * </ul
 *
 * @author 박석원
 * @updated 2025-04-14
 */
@Getter
@Builder
public class WakaAccessTokenResponse{
    private String userId;
    private String wakaId;
    private String accessToken;

    public static WakaAccessTokenResponse fromDomain(WakaToken wakaToken){
        return WakaAccessTokenResponse.builder()
                .userId(wakaToken.getUserId())
                .wakaId(wakaToken.getWakaId())
                .accessToken(wakaToken.getAccessToken())
                .build();
    }
}
