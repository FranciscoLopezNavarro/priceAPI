package com.kairos.gridtest.domain.ports.input.dto;

import com.kairos.gridtest.domain.model.Amount;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class ProductPrice {
    private long brandId;
    private long productId;
    private int priceList;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Amount price;
}
