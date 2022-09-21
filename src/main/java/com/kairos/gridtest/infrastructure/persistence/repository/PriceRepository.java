package com.kairos.gridtest.infrastructure.persistence.repository;

import com.kairos.gridtest.infrastructure.persistence.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface PriceRepository extends JpaRepository<PriceEntity, Long> {
    Stream<PriceEntity> findByBrandIdAndProductId(long brandId, long productId);
}
