package com.waka.time.wakatoken.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;


/**
 * <h1>Waka 인증 토큰</h1>
 * WakaTime에서 발급한 OAuth 토큰 정보를 보관하는 객체
 * <ul>
 *   <li><b>userId</b>: 사용자 ID (app 사용자 Id)</li>
 *   <li><b>wakaId</b>: wakaTime 사용자 ID (WakaTime 계정 고유값)</li>
 *   <li><b>accessToken</b>: OAuth 액세스 토큰</li>
 *   <li><b>refreshToken</b>: 리프레시 토큰</li>
 *   <li><b>tokenType</b>: 토큰 타입 (예: Bearer)</li>
 *   <li><b>scope</b>: 권한 범위</li>
 *   <li><b>expiresAt</b>: 토큰 만료 일시</li>
 *   <li><b>createdAt</b>: DB값 생성 일시</li>
 *   <li><b>updatedAt</b>: DB값 업데이트 일시</li>
 * </ul>
 * @author 박석원
 * @updated 2025-04-06
 */
@Getter
@Builder
public class WakaToken {
    private final String userId;
    private final String wakaId;
    private final String accessToken;
    private final String refreshToken;
    private final String tokenType;
    private final String scope;
    private final LocalDateTime expiresAt;
    private final LocalDateTime createdAt;
    private final LocalDateTime updateAt;
}
