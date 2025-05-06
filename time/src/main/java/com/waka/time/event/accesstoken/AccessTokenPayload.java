package com.waka.time.event.accesstoken;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * <h1>AccessTokenPayload</h1>
 * AccessToken 이벤트에서 사용되는 공통 데이터 전송 객체
 *
 * <ul>
 *   <li>이벤트 송수신 시 공통 구조로 사용</li>
 *   <li>도메인 응답 ↔ 이벤트 페이로드 간 변환 메서드 포함</li>
 * </ul>
 * @author 박석원
 * @updated 2025-05-06
 */
@Getter
@Builder
public class AccessTokenPayload {
    private String userId;
    private String wakaId;
    private String accessToken;

    public static List<AccessTokenPayload> fromResponse(List<com.waka.time.wakatoken.application.port.out.WakaAccessTokenResponse> responses){
        return responses.stream()
                .map(r -> AccessTokenPayload.builder()
                        .userId(r.getUserId())
                        .wakaId(r.getWakaId())
                        .accessToken(r.getAccessToken())
                        .build())
                .toList();
    }

    public static List<com.waka.time.summary.application.port.in.WakaAccessTokenResponse> toPayload(List<AccessTokenPayload> payloads){
        return payloads.stream()
                .map(p -> com.waka.time.summary.application.port.in.WakaAccessTokenResponse.builder()
                        .userId(p.getUserId())
                        .wakaId(p.getWakaId())
                        .accessToken(p.getAccessToken())
                        .build()
                ).toList();
    }
}
