package com.deliveryit.challenge.thiago.domain.fines;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class EarlyFineTest {

    @Test
    public void testAccept() {
        EarlyFine earlyFine = new EarlyFine();
        Assert.assertFalse(earlyFine.accept(0));
        Assert.assertTrue(earlyFine.accept(1));
        Assert.assertTrue(earlyFine.accept(2));
        Assert.assertTrue(earlyFine.accept(3));
        Assert.assertFalse(earlyFine.accept(4));
    }

    @Test
    public void testApply() {
        EarlyFine earlyFine = new EarlyFine();
        BigDecimal result = earlyFine.apply(new BigDecimal(100), 1);
        Assert.assertEquals(new BigDecimal(102.10).setScale(2, RoundingMode.HALF_EVEN), result);
    }

}
