package com.kairos.gridtest.domain.ports.input.dto;

import com.kairos.gridtest.domain.model.Amount;
import lombok.Builder;
import lombok.Getter;
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
