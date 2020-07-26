package com.deliveryit.challenge.thiago.core;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUtilityTest {

    @Test
    public void testDateUtility() {
        Assert.assertEquals(new Integer(0), DateUtility.diff(new Date(), new Date(), TimeUnit.DAYS));
    }
}
