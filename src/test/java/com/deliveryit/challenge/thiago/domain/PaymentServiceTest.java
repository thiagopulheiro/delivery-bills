package com.deliveryit.challenge.thiago.domain;

import com.deliveryit.challenge.thiago.core.data.InvoiceRequest;
import com.deliveryit.challenge.thiago.domain.fines.NoFine;
import com.deliveryit.challenge.thiago.domain.repositories.InvoiceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Date;

@RunWith(MockitoJUnitRunner.class)
public class PaymentServiceTest {

    @Mock
    private InvoiceRepository invoiceRepository;

    @Mock
    private FineService fineService;

    @InjectMocks
    private PaymentService paymentService;

    @Test
    public void testPay() {
        when(fineService.locate(0)).thenReturn(new NoFine());
        when(invoiceRepository.save(any())).thenReturn(any());
        InvoiceRequest invoiceRequest = new InvoiceRequest();
        invoiceRequest.setDueDate(new Date());
        invoiceRequest.setPaymentDate(new Date());
        invoiceRequest.setAmount(new BigDecimal(10));
        paymentService.pay(invoiceRequest);
        verify(fineService).locate(0);
    }

    @Test
    public void listAllInvoices() {
        paymentService.listAllInvoices();
        verify(invoiceRepository).findAll();
    }
}
