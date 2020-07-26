package com.deliveryit.challenge.thiago.domain.fines;

import java.math.BigDecimal;

public class NoFine extends AbstractFine {

    public NoFine() {
        super(0, 0.0f);
    }

    @Override
    public boolean accept(Integer daysOverdue) {
        return true;
    }

    @Override
    public BigDecimal apply(BigDecimal amount, Integer daysOverdue) {
        return amount;
    }
}
