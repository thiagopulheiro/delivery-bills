package com.deliveryit.challenge.thiago.domain;

import com.deliveryit.challenge.thiago.core.DateUtility;
import com.deliveryit.challenge.thiago.core.data.InvoiceRequest;
import com.deliveryit.challenge.thiago.domain.entities.Invoice;
import com.deliveryit.challenge.thiago.domain.repositories.InvoiceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class PaymentService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private FineService fineService;

    @Transactional
    public void pay(InvoiceRequest invoiceRequest) {

        final Integer daysOverdue = DateUtility.diff(invoiceRequest.getDueDate(), invoiceRequest.getPaymentDate(), TimeUnit.DAYS);
        final Fine fine = fineService.locate(daysOverdue);
        log.debug("Applying fine: {} with days overdue {}.", fine, daysOverdue);
        final Invoice invoice = Invoice.builder()
                .name(invoiceRequest.getName())
                .amount(invoiceRequest.getAmount())
                .amountAfterTax(fine.apply(invoiceRequest.getAmount(), daysOverdue))
                .daysOverdue(daysOverdue)
                .paymentDate(invoiceRequest.getPaymentDate())
                .build();
        invoiceRepository.save(invoice);
    }

    @Transactional(readOnly = true)
    public List<Invoice> listAllInvoices() {
        return invoiceRepository.findAll();
    }

}
