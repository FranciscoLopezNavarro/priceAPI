package com.kairos.gridtest.domain.model;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class Amount {
    private BigDecimal value;
    private String currency;
}
