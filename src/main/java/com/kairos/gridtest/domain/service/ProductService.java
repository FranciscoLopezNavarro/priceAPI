package com.kairos.gridtest.domain.service;

import com.kairos.gridtest.domain.model.dto.ProductPrice;

import java.time.LocalDateTime;

public interface ProductService {
    ProductPrice getProductPrice(long brandId, long productId, LocalDateTime date);
}
