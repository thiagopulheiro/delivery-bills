package com.deliveryit.challenge.thiago.core.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InvoiceRequest implements Serializable {
    private String name;
    private BigDecimal amount;
    private Date dueDate;
    private Date paymentDate;
}
