package com.kairos.gridtest.domain.ports.output;

import com.kairos.gridtest.domain.model.Price;

import java.util.List;

public interface PriceRepository {
    List<Price> findPriceByBrandAndProduct(long brandId, long productId);
}
