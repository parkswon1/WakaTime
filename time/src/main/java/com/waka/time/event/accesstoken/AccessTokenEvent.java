package com.waka.time.event.accesstoken;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * <h1>AccessTokenEvent</h1>
 * AccessTokenPublisher가 발행하는 이벤트
 *
 * <ul>
 *   <li> accessTokenPayload: 이벤트에서 사용할 공통 코드</li>
 * </ul>
 *
 * @author 박석원
 * @updated 2025-05-06
 */
@Getter
@Builder
public class AccessTokenEvent {
    private final List<AccessTokenPayload> accessTokenPayload;
}
