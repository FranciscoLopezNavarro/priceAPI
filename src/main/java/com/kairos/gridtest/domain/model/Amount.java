package com.kairos.gridtest.domain.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class Amount {
    private final BigDecimal value;
    private final String currency;
}
