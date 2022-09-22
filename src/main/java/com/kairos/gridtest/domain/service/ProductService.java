package com.kairos.gridtest.domain.service;

import com.kairos.gridtest.domain.ports.input.dto.ProductPrice;

import java.time.LocalDateTime;

public interface ProductService  {
    ProductPrice getProductPrice(long brandId, long productId, LocalDateTime date);
}
