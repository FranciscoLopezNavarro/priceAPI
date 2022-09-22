package com.kairos.gridtest.domain.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class Price {
    private final long brandId;
    private final long productId;
    private final int priceId;
    private final int priority;
    private final Amount amount;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
}
