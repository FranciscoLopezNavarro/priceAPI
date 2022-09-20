package com.kairos.gridtest.domain.model;

import java.time.LocalDateTime;

public class ProductPrice {

    private final long productId;
    private final int priceId;
    private final int priority;
    private final Amount price;

    private final LocalDateTime startDate;
    private final LocalDateTime endDate;

    public ProductPrice(long productId, int priceId, int priority, Amount price, LocalDateTime startDate, LocalDateTime endDate) {
        this.productId = productId;
        this.priceId = priceId;
        this.priority = priority;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getPriceId() {
        return priceId;
    }

    public int getPriority() {
        return priority;
    }

    public Amount getPrice() {
        return price;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }
}
