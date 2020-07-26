package com.deliveryit.challenge.thiago.domain.fines;

import com.deliveryit.challenge.thiago.domain.Fine;

import java.math.BigDecimal;

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
        BigDecimal fine = amount.multiply(BigDecimal.valueOf(finePercentage / 100));
        BigDecimal daily = amount.multiply(BigDecimal.valueOf((dailyPercentage * daysOverdue) / 100));
        return amount.add(fine).add(daily);
    }

    public static void main(String[] args) {
        BigDecimal amount = new BigDecimal(100);
        int finePercentage = 3;
        float dailyPercentage = 0.1f;
        int daysOverdue = 3;
        BigDecimal fine = amount.multiply(BigDecimal.valueOf(finePercentage / 100));
        System.out.println(fine);
        BigDecimal daily = amount.multiply(BigDecimal.valueOf((dailyPercentage * daysOverdue) / 100));
        System.out.println(daily);
         amount.add(fine).add(daily);
        System.out.println(amount);
    }
}
