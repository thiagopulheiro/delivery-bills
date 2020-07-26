package com.deliveryit.challenge.thiago.domain.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "invoice")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
@NoArgsConstructor
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, columnDefinition = "char(250) default ''")
    private String name;
    @Column(nullable = false)
    private BigDecimal amount;
    @Column(nullable = false)
    private BigDecimal amountAfterTax;
    @Column(nullable = false)
    private Integer daysOverdue;
    @Column(nullable = false)
    private Date paymentDate;

    @Builder
    public Invoice(String name, BigDecimal amount, BigDecimal amountAfterTax, Integer daysOverdue, Date paymentDate) {
        this.name = name;
        this.amount = amount;
        this.amountAfterTax = amountAfterTax;
        this.daysOverdue = daysOverdue;
        this.paymentDate = paymentDate;
    }
}