package com.waka.time.wakatoken.application.service;

import org.springframework.stereotype.Service;

/**
 * <h1>WakaTime 인증 서비스</h1>
 * 인증 코드를 통해 WakaTime에서 토큰을 발급받고 저장하는 유스케이스 로직입니다.
 *
 * @author 박석원
 * @updated 2025-04-05
 */
@Service
public interface WakaAuthService {
    void authenticate(String code, Long userId);
}