package com.deliveryit.challenge.thiago.domain.fines;

public class CriticalFine extends AbstractFine {

    private static final int LIMIT = 5;
    private static final int FINE_PERCENTAGE = 5;
    private static final float DAILY_ADD_PERCENTAGE = 0.3f;

    public CriticalFine() {
        super(FINE_PERCENTAGE, DAILY_ADD_PERCENTAGE);
    }

    @Override
    public boolean accept(Integer daysOverdue) {
        return daysOverdue > LIMIT;
    }

}
