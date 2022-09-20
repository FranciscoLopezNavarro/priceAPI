package com.kairos.gridtest.domain.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Product {
    private long brandId;
    private long productId;
    private List<ProductPrice> prices;

    public Product(long brandId, long productId, ProductPrice productPrice) {
        this.brandId = brandId;
        this.productId = productId;
        this.prices = new ArrayList<>(List.of(productPrice));
    }

    public ProductPrice getPriorityPrice() {
        return prices.stream().max(Comparator.comparing(ProductPrice::getPriority)).orElse(null);
    }

    public void addProductPrice(int priority, Amount price, LocalDateTime startDate, LocalDateTime endDate) {
        prices.add(new ProductPrice(this.productId, prices.size() + 1, priority, price, startDate, endDate));
    }

    public long getBrandId() {
        return brandId;
    }

    public long getProductId() {
        return productId;
    }

    public List<ProductPrice> getPrices() {
        return prices;
    }
}
