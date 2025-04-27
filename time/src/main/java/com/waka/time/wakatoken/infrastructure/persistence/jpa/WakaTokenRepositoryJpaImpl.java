package com.waka.time.wakatoken.infrastructure.persistence.jpa;

import com.waka.time.wakatoken.domain.model.WakaToken;
import com.waka.time.wakatoken.domain.repository.WakaTokenRepository;
import com.waka.time.wakatoken.infrastructure.persistence.jpa.entity.WakaTokenEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * <h1>WakaToken JPA 저장소 구현체</h1>
 *
 * author 박석원
 * updated 2025-04-06
 */
@Repository
@RequiredArgsConstructor
public class WakaTokenRepositoryJpaImpl implements WakaTokenRepository {

    private final WakaTokenJpaRepository wakaTokenJpaRepository;

    @Override
    public WakaToken save(WakaToken token) {
        Optional<WakaTokenEntity> existing = wakaTokenJpaRepository.findByWakaId(token.getWakaId());

        WakaTokenEntity entity;
        if (existing.isPresent()) {
            entity = existing.get();
            entity.updateFromDomain(token);
        } else {
            entity = WakaTokenEntity.fromDomain(token);
        }

        return wakaTokenJpaRepository.save(entity).toDomain();
    }

    @Override
    public Optional<WakaToken> findByUserId(String userId) {
        return wakaTokenJpaRepository.findByUserId(userId).map(WakaTokenEntity::toDomain);
    }

    @Override
    public Page<WakaToken> findAll(Pageable pageable) {
        Page<WakaTokenEntity> wakaTokens = wakaTokenJpaRepository.findAll(pageable);
        return wakaTokens.map(WakaTokenEntity::toDomain);
    }
}