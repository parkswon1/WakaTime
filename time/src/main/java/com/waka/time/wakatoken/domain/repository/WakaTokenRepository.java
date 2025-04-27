package com.waka.time.wakatoken.domain.repository;

import com.waka.time.wakatoken.domain.model.WakaToken;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * <h1>WakaToken 저장소 인터페이스</h1>
 * WakaTime 인증 토큰의 저장 및 조회를 위한 도메인 계층 인터페이스입니다.
 * 구현체는 인프라스트럭처 계층에 위치합니다.
 *
 * @author 박석원
 * @updated 2025-04-05
 */
public interface WakaTokenRepository {
    WakaToken save(WakaToken token);
    Optional<WakaToken> findByUserId(String userId);
    Page<WakaToken> findAll(Pageable pageable);
}