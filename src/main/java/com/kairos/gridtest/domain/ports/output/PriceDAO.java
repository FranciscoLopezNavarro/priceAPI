package com.kairos.gridtest.domain.ports.output;

import com.kairos.gridtest.domain.model.Price;

import java.util.List;

public interface PriceDAO {
    List<Price> findPriceByBrandAndProduct(long brandId, long productId);
}
