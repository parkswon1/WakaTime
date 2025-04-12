package com.waka.time.wakatoken.infrastructure.persistence.jpa.entity;

import com.waka.time.common.base.BaseEntity;
import com.waka.time.wakatoken.domain.model.WakaToken;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * <h1>WakaToken JPA Entity</h1>
 * user_waka_token 테이블과 매핑되는 영속성 객체입니다.
 *
 * @author 박석원
 * @updated 2025-04-06
 */
@Entity
@Table(name = "user_waka_token")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class WakaTokenEntity implements BaseEntity<WakaToken> {

    @Id
    @Column(name="user_id")
    private String userId;

    @Column(name="waka_id")
    private String wakaId;

    @Column(name="access_Token")
    private String accessToken;

    @Column(name="refresh_Token")
    private String refreshToken;

    @Column(name="token_Type")
    private String tokenType;

    @Column(name="scope")
    private String scope;

    @Column(name="expires_at")
    private LocalDateTime expiresAt;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    public static WakaTokenEntity fromDomain(WakaToken domain) {
        return WakaTokenEntity.builder()
                .userId(domain.getUserId())
                .wakaId(domain.getWakaId())
                .accessToken(domain.getAccessToken())
                .refreshToken(domain.getRefreshToken())
                .tokenType(domain.getTokenType())
                .scope(domain.getScope())
                .expiresAt(domain.getExpiresAt())
                .createdAt(domain.getCreatedAt())
                .updatedAt(domain.getUpdateAt())
                .build();
    }

    @Override
    public void updateFromDomain(WakaToken domain) {
        this.wakaId = domain.getWakaId();
        this.accessToken = domain.getAccessToken();
        this.refreshToken = domain.getRefreshToken();
        this.tokenType = domain.getTokenType();
        this.scope = domain.getScope();
        this.expiresAt = domain.getExpiresAt();
        this.createdAt = domain.getCreatedAt();
        this.updatedAt = domain.getUpdateAt();
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
                .updateAt(updatedAt)
                .build();
    }
}