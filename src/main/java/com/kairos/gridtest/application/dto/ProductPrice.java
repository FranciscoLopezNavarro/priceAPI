package com.kairos.gridtest.application.dto;

import com.kairos.gridtest.domain.model.Amount;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Builder
@Value
public class ProductPrice {
    long brandId;
    long productId;
    int priceList;
    LocalDateTime startDate;
    LocalDateTime endDate;
    Amount price;
}
