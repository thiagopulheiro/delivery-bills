package com.deliveryit.challenge.thiago.domain.fines;

public class MediumFine extends AbstractFine {

    private static final int LIMIT = 3;
    private static final int FINE_PERCENTAGE = 3;
    private static final float DAILY_ADD_PERCENTAGE = 0.2f;

    public MediumFine() {
        super(FINE_PERCENTAGE, DAILY_ADD_PERCENTAGE);
    }

    @Override
    public boolean accept(Integer daysOverdue) {
        return daysOverdue > LIMIT;
    }
}
