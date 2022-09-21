package com.kairos.gridtest.domain.model.dto;

import com.kairos.gridtest.domain.model.Amount;

import java.time.LocalDateTime;

public class ProductPrice {
    private long brandId;
    private long productId;
    private int priceList;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Amount price;

    public long getBrandId() {
        return brandId;
    }

    public void setBrandId(long brandId) {
        this.brandId = brandId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getPriceList() {
        return priceList;
    }

    public void setPriceList(int priceList) {
        this.priceList = priceList;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Amount getPrice() {
        return price;
    }

    public void setPrice(Amount price) {
        this.price = price;
    }
}
