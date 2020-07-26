
package com.deliveryit.challenge.thiago.domain.fines;

        import org.junit.Assert;
        import org.junit.Test;

        import java.math.BigDecimal;
        import java.math.RoundingMode;

public class NoFineTest {

    @Test
    public void testAccept() {
        NoFine noFine = new NoFine();
        Assert.assertTrue(noFine.accept(0));
    }

    @Test
    public void testApply() {
        NoFine noFine = new NoFine();
        BigDecimal result = noFine.apply(new BigDecimal(100), 0);
        Assert.assertEquals(new BigDecimal(100), result);
    }

}
