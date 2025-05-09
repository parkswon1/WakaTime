package com.waka.time.wakatoken.infrastructure.persistence.jpa;

import com.waka.time.wakatoken.infrastructure.persistence.jpa.entity.WakaTokenEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WakaTokenJpaRepository extends JpaRepository<WakaTokenEntity, Long> {
    Optional<WakaTokenEntity> findByUserId(String userId);
    Optional<WakaTokenEntity> findByWakaId(String wakaId);
    Page<WakaTokenEntity> findAll(Pageable pageable);
}
