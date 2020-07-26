package com.deliveryit.challenge.thiago.core.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InvoiceRequest implements Serializable {
    private String name;
    private String amount;
    private Date dueDate;
    private Date paymentDate;
}
