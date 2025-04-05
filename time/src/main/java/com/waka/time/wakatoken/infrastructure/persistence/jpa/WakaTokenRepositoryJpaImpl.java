package com.waka.time.wakatoken.infrastructure.persistence.jpa;

import com.waka.time.wakatoken.domain.model.WakaToken;
import com.waka.time.wakatoken.domain.repository.WakaTokenRepository;
import com.waka.time.wakatoken.infrastructure.persistence.jpa.WakaTokenJpaRepository;
import com.waka.time.wakatoken.infrastructure.persistence.jpa.entity.WakaTokenEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * <h1>WakaToken JPA 저장소 구현체</h1>
 *
 * author 박석원
 * updated 2025-04-05
 */
@Repository
@RequiredArgsConstructor
public class WakaTokenRepositoryJpaImpl implements WakaTokenRepository {

    private final WakaTokenJpaRepository wakaTokenJpaRepository;

    @Override
    public WakaToken save(WakaToken token) {
        Optional<WakaTokenEntity> existing = wakaTokenJpaRepository.findByWakaId(token.getWakaId());

        WakaTokenEntity entity = existing
                .map(e -> e.updateFrom(token))
                .orElse(WakaTokenEntity.from(token));

        return wakaTokenJpaRepository.save(entity).toDomain();
    }

    @Override
    public Optional<WakaToken> findByUserId(Long userId) {
        return wakaTokenJpaRepository.findByUserId(userId).map(WakaTokenEntity::toDomain);
    }
}