package com.deliveryit.challenge.thiago.core.messaging;

import com.deliveryit.challenge.thiago.core.PaymentService;
import com.deliveryit.challenge.thiago.core.data.InvoiceRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Component
@Slf4j
public class PaymentConsumer {

    @Autowired
    private PaymentService paymentService;

    @RabbitListener(queues = "#{paymentQueue.name}")
    public void listen(final InvoiceRequest invoiceRequest) {
        if (Objects.isNull(invoiceRequest)) {
            log.warn("Invalid message {}, will be ignored.", invoiceRequest);
            return;
        }
        log.debug("Submitting new invoice: {}...", invoiceRequest);
        try {
            this.paymentService.pay(invoiceRequest);
        }  catch (final Exception e) {
            log.error("Something went wrong for invoice request: {}.", invoiceRequest, e);
            return;
        }
    }

}
