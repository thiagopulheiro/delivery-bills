package com.deliveryit.challenge.thiago.domain.fines;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MediumFineTest {

    @Test
    public void testAccept() {
        MediumFine mediumFine = new MediumFine();
        Assert.assertFalse(mediumFine.accept(3));
        Assert.assertTrue(mediumFine.accept(4));
        Assert.assertTrue(mediumFine.accept(5));
        Assert.assertFalse(mediumFine.accept(6));
    }

    @Test
    public void testApply() {
        MediumFine mediumFine = new MediumFine();
        BigDecimal result = mediumFine.apply(new BigDecimal(100), 1);
        Assert.assertEquals(new BigDecimal(103.20).setScale(2, RoundingMode.HALF_EVEN), result);
    }

}
