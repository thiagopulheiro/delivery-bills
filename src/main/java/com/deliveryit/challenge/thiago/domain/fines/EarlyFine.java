package com.deliveryit.challenge.thiago.domain.fines;

public class EarlyFine extends AbstractFine {

    private static final int LIMIT = 3;
    private static final int FINE_PERCENTAGE = 2;
    private static final float DAILY_ADD_PERCENTAGE = 0.1f;

    public EarlyFine() {
        super(FINE_PERCENTAGE, DAILY_ADD_PERCENTAGE);
    }

    @Override
    public boolean accept(Integer daysOverdue) {
        return daysOverdue <= LIMIT;
    }

}
