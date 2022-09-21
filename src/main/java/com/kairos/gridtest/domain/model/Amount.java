package com.kairos.gridtest.domain.model;

import java.math.BigDecimal;

public class Amount {
    private BigDecimal value;
    private String currency;

    public Amount() {
    }

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

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
