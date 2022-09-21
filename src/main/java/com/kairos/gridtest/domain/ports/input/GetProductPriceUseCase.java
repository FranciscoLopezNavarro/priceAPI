package com.kairos.gridtest.domain.ports.input;

import com.kairos.gridtest.domain.ports.input.dto.ProductPrice;

import java.time.LocalDateTime;

public interface GetProductPriceUseCase {
    ProductPrice getProductPrice(long brandId, long productId, LocalDateTime date);
}
