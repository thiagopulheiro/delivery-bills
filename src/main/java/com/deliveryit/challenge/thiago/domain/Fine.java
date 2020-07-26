package com.deliveryit.challenge.thiago.domain;

import java.math.BigDecimal;

public interface Fine {
    boolean accept(Integer daysOverdue);

    BigDecimal apply(BigDecimal amount, Integer daysOverdue);
}
