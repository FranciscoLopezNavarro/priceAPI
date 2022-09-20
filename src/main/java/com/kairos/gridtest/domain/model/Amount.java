package com.kairos.gridtest.domain.model;

import java.math.BigDecimal;

public class Amount {
    private final BigDecimal value;
    private final String currency;

    public Amount(BigDecimal value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    public BigDecimal getValue() {
        return value;
    }

    public String getCurrency() {
        return currency;
    }
}
