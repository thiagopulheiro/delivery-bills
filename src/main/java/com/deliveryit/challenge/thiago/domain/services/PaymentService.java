package com.deliveryit.challenge.thiago.domain.services;

import com.deliveryit.challenge.thiago.application.data.InvoiceRequest;
import com.deliveryit.challenge.thiago.domain.repositories.InvoiceRepository;
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
