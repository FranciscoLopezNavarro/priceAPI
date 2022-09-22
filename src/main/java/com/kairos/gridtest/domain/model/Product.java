package com.kairos.gridtest.domain.model;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Getter
public class Product {
    private final long brandId;
    private final long productId;
    private final List<Price> prices;

    public Product(long brandId, long productId, Price price) {
        this.brandId = brandId;
        this.productId = productId;
        this.prices = new ArrayList<>(List.of(price));
    }

    public Product(long brandId, long productId) {
        this.brandId = brandId;
        this.productId = productId;
        prices = new ArrayList<>();
    }

    public Price getPrice() {
        return prices.stream().max(Comparator.comparing(Price::getPriority)).orElse(null);
    }

    public void addProductPrice(Price price) {
        prices.add(price);
    }

}
