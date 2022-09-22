package com.kairos.gridtest.domain.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class Price {
    private long brandId;
    private long productId;
    private int priceId;
    private int priority;
    private Amount amount;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
