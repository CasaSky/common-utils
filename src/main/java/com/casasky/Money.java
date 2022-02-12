package com.casasky;

import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
public class Money {

    private BigDecimal amount;
    private String currency;

    protected Money() {
    }

    private Money(BigDecimal amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static Money valueOf(BigDecimal value, String currency) {
        BigDecimal scaledValue = value.setScale(2, RoundingMode.UNNECESSARY);
        return new Money(scaledValue, currency);
    }
}
