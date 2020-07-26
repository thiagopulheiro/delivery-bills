package com.deliveryit.challenge.thiago.core.messaging;

import com.deliveryit.challenge.thiago.core.data.InvoiceRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

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
