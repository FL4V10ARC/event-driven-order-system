package io.github.flavio.payment_service.producer;
import io.github.flavio.payment_service.event.PaymentApprovedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentProducer {

    private final KafkaTemplate<String, PaymentApprovedEvent> kafkaTemplate;

    public PaymentProducer(KafkaTemplate<String, PaymentApprovedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendPaymentApprovedEvent(PaymentApprovedEvent event) {
        kafkaTemplate.send("payment-approved", event);
    }
}