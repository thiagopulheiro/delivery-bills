package com.deliveryit.challenge.thiago.application;

import com.deliveryit.challenge.thiago.core.data.InvoiceRequest;
import com.deliveryit.challenge.thiago.domain.entities.Invoice;
import com.deliveryit.challenge.thiago.domain.PaymentService;
import com.deliveryit.challenge.thiago.infrastructure.PaymentProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired(required = false)
    private PaymentProducer paymentProducer;

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public void add(@RequestBody InvoiceRequest invoiceRequest) {
        if (paymentProducer == null) {
            log.warn("The broker service is not available at the moment, payment will be processed via ad-hoc.");
            paymentService.pay(invoiceRequest);
            return;
        }
        paymentProducer.send(invoiceRequest);
    }

    @GetMapping
    public List<Invoice> list() {
        return paymentService.listAllInvoices();
    }

}
