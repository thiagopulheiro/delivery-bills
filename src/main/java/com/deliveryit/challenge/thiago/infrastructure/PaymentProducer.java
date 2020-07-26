package com.deliveryit.challenge.thiago.infrastructure;

import com.deliveryit.challenge.thiago.application.data.InvoiceRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Async;

@AllArgsConstructor
@Slf4j
public class PaymentProducer {

    private final RabbitTemplate rabbitTemplate;
    private final String paymentQueueName;

    @Async
    public void send(final InvoiceRequest invoiceRequest) {
        this.rabbitTemplate.convertAndSend(paymentQueueName, invoiceRequest);
    }

}
