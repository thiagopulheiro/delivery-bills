package com.deliveryit.challenge.thiago.domain.fines;

import com.deliveryit.challenge.thiago.domain.Fine;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class AbstractFine implements Fine {
    private Integer finePercentage;
    private Float dailyPercentage;

    public AbstractFine(Integer finePercentage, Float dailyPercentage) {
        this.finePercentage = finePercentage;
        this.dailyPercentage = dailyPercentage;
    }

    @Override
    public boolean accept(Integer daysOverdue) {
        return false;
    }

    @Override
    public BigDecimal apply(BigDecimal amount, Integer daysOverdue) {
        BigDecimal fine = amount.multiply(new BigDecimal(finePercentage)
                .divide(new BigDecimal(100)));
        BigDecimal daily = amount.multiply((new BigDecimal(dailyPercentage).multiply(new BigDecimal(daysOverdue)))
                .divide(new BigDecimal(100)));
        return amount.add(fine).add(daily).setScale(2, RoundingMode.HALF_EVEN);
    }
}
