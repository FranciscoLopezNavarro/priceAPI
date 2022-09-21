package com.kairos.gridtest.domain.model;

import java.time.LocalDateTime;

public class Price {

    private final long brandId;
    private final long productId;
    private final int priceId;
    private final int priority;
    private final Amount amount;

    private final LocalDateTime startDate;
    private final LocalDateTime endDate;

    public Price(long brandId, long productId, int priceId, int priority, Amount amount, LocalDateTime startDate, LocalDateTime endDate) {
        this.brandId = brandId;
        this.productId = productId;
        this.priceId = priceId;
        this.priority = priority;
        this.amount = amount;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public long getBrandId() {
        return brandId;
    }

    public long getProductId() {
        return productId;
    }

    public int getPriceId() {
        return priceId;
    }

    public int getPriority() {
        return priority;
    }

    public Amount getAmount() {
        return amount;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }
}
