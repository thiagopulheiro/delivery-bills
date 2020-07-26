package com.deliveryit.challenge.thiago.domain;

import com.deliveryit.challenge.thiago.domain.fines.CriticalFine;
import com.deliveryit.challenge.thiago.domain.fines.EarlyFine;
import com.deliveryit.challenge.thiago.domain.fines.MediumFine;
import com.deliveryit.challenge.thiago.domain.fines.NoFine;
import org.junit.Assert;
import org.junit.Test;

public class FineServiceTest {

    private FineService fineService = new FineService();

    @Test
    public void testLocate() {
        fineService.buildFineList();
        Assert.assertTrue(fineService.locate(0) instanceof NoFine);
        Assert.assertTrue(fineService.locate(2) instanceof EarlyFine);
        Assert.assertTrue(fineService.locate(5) instanceof MediumFine);
        Assert.assertTrue(fineService.locate(6) instanceof CriticalFine);
    }
}
