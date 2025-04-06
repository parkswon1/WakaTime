package com.waka.time.wakatoken.infrastructure.dto;

import com.waka.time.common.base.BaseDto;
import com.waka.time.wakatoken.domain.model.WakaToken;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * <h1>WakaToken 응답 DTO</h1>
 * 인증된 토큰 정보를 외부로 전달할 때 사용하는 DTO입니다.
 *
 * @author 박석원
 * @updated 2025-04-06
 */
@Getter
@Builder
public class WakaTokenDto implements BaseDto<WakaToken> {

    private final Long userId;
    private final String wakaId;
    private final String accessToken;
    private final String refreshToken;
    private final String tokenType;
    private final String scope;
    private final LocalDateTime expiresAt;
    private final LocalDateTime createdAt;
    private final LocalDateTime updateAt;

    public static WakaTokenDto fromDomain(WakaToken domain) {
        return WakaTokenDto.builder()
                .userId(domain.getUserId())
                .wakaId(domain.getWakaId())
                .accessToken(domain.getAccessToken())
                .refreshToken(domain.getRefreshToken())
                .tokenType(domain.getTokenType())
                .scope(domain.getScope())
                .expiresAt(domain.getExpiresAt())
                .createdAt(domain.getCreatedAt())
                .updateAt(domain.getUpdateAt())
                .build();
    }

    @Override
    public WakaToken toDomain() {
        return WakaToken.builder()
                .userId(userId)
                .wakaId(wakaId)
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .tokenType(tokenType)
                .scope(scope)
                .expiresAt(expiresAt)
                .createdAt(createdAt)
                .updateAt(updateAt)
                .build();
    }
}