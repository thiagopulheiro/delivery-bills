
package com.deliveryit.challenge.thiago.domain.fines;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CriticalFineTest {

    @Test
    public void testAccept() {
        CriticalFine criticalFine = new CriticalFine();
        Assert.assertFalse(criticalFine.accept(5));
        Assert.assertTrue(criticalFine.accept(6));
    }

    @Test
    public void testApply() {
        CriticalFine criticalFine = new CriticalFine();
        BigDecimal result = criticalFine.apply(new BigDecimal(100), 1);
        Assert.assertEquals(new BigDecimal(105.30).setScale(2, RoundingMode.HALF_EVEN), result);
    }

}
