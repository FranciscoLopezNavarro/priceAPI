package com.kairos.gridtest.domain.service;

import com.kairos.gridtest.domain.model.dto.GetProductPriceResponse;

import java.time.LocalDateTime;

public interface ProductService {
    GetProductPriceResponse getProductPrice(long brandId, long productId, LocalDateTime date);
}
