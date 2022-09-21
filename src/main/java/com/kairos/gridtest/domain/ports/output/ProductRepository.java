package com.kairos.gridtest.domain.ports.output;

import com.kairos.gridtest.domain.model.Product;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ProductRepository {

    Optional<Product> findProductByBrandAndProductIdAndDate(long brandId, long productId, LocalDateTime date);
}
