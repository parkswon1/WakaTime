package com.waka.time.wakatoken.infrastructure.persistence.entity;

import com.waka.time.wakatoken.domain.model.WakaToken;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * <h1>WakaToken JPA Entity</h1>
 * user_waka_token 테이블과 매핑되는 영속성 객체입니다.
 * 도메인 객체로부터 변환/역변환됩니다.
 *
 * author 박석원
 * updated 2025-04-05
 */
@Entity
@Table(name = "user_waka_token")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class WakaTokenEntity {

    @Id
    private Long userId;

    private String wakaId;

    private String accessToken;

    private String refreshToken;

    private LocalDateTime expiresAt;

    private String scope;

    private String tokenType;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public static WakaTokenEntity from(WakaToken token) {
        return new WakaTokenEntity(
                token.getUserId(),
                token.getWakaId(),
                token.getAccessToken(),
                token.getRefreshToken(),
                token.getExpiresAt(),
                token.getScope(),
                token.getTokenType(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }

    public WakaToken toDomain() {
        return new WakaToken(
                userId,
                wakaId,
                accessToken,
                refreshToken,
                tokenType,
                scope,
                expiresAt
        );
    }

    public WakaTokenEntity updateFrom(WakaToken token) {
        this.accessToken = token.getAccessToken();
        this.refreshToken = token.getRefreshToken();
        this.expiresAt = token.getExpiresAt();
        this.scope = token.getScope();
        this.tokenType = token.getTokenType();
        this.updatedAt = LocalDateTime.now();
        return this;
    }
}