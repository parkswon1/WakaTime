package com.waka.time.wakatoken.infrastructure.persistence.jpa;

import com.waka.time.wakatoken.infrastructure.persistence.entity.WakaTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WakaTokenJpaRepository extends JpaRepository<WakaTokenEntity, Long> {
    Optional<WakaTokenEntity> findByUserId(Long userId);
    Optional<WakaTokenEntity> findByWakaId(String wakaId);
}
