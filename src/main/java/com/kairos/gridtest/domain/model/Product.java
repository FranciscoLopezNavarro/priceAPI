package com.kairos.gridtest.domain.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Product {
    private long brandId;
    private long productId;
    private List<Price> prices;

    public Product(long brandId, long productId, Price price) {
        this.brandId = brandId;
        this.productId = productId;
        this.prices = new ArrayList<>(List.of(price));
    }

    public Price getPrice() {
        return prices.stream().max(Comparator.comparing(Price::getPriority)).orElse(null);
    }

    public void addProductPrice(int priority, Amount price, LocalDateTime startDate, LocalDateTime endDate) {
        prices.add(new Price(brandId, this.productId, prices.size() + 1, priority, price, startDate, endDate));
    }

    public long getBrandId() {
        return brandId;
    }

    public long getProductId() {
        return productId;
    }

    public List<Price> getPrices() {
        return prices;
    }
}
