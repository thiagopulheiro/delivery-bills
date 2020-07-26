package com.deliveryit.challenge.thiago.core;

import lombok.experimental.UtilityClass;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@UtilityClass
public class DateUtility {

    public Integer diff(Date date1, Date date2, TimeUnit timeUnit) {
        Long diffInMillies = date2.getTime() - date1.getTime();
        return Long.valueOf(timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS)).intValue();
    }

}
