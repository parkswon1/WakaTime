package com.waka.time.wakatoken.infrastructure.dto;

import com.waka.time.wakatoken.domain.model.WakaToken;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * <h1>WakaToken 응답 DTO</h1>
 * 인증된 토큰 정보를 외부로 전달할 때 사용하는 DTO입니다.
 *
 * author 박석원
 * updated 2025-04-05
 */
@Getter
@AllArgsConstructor
public class WakaTokenDto {
    private final Long userId;
    private final String wakaId;
    private final String accessToken;
    private final String refreshToken;
    private final String tokenType;
    private final String scope;
    private final LocalDateTime expiresAt;

    public static WakaTokenDto from(WakaToken token) {
        return new WakaTokenDto(
                token.getUserId(),
                token.getWakaId(),
                token.getAccessToken(),
                token.getRefreshToken(),
                token.getTokenType(),
                token.getScope(),
                token.getExpiresAt()
        );
    }
}