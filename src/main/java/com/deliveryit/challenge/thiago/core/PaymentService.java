package com.deliveryit.challenge.thiago.core;

import com.deliveryit.challenge.thiago.core.data.InvoiceRequest;
import com.deliveryit.challenge.thiago.port.InvoiceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
public class PaymentService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Transactional
    public void pay(InvoiceRequest invoiceRequest) {

    }

}
