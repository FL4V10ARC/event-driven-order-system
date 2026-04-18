package io.github.flavio.payment_service.consumer;
import io.github.flavio.payment_service.event.OrderCreatedEvent;
import io.github.flavio.payment_service.event.PaymentApprovedEvent;
import io.github.flavio.payment_service.producer.PaymentProducer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderCreatedConsumer {

    private final PaymentProducer paymentProducer;

    public OrderCreatedConsumer(PaymentProducer paymentProducer) {
        this.paymentProducer = paymentProducer;
    }

    @KafkaListener(topics = "order-created", groupId = "payment-group")
    public void consume(OrderCreatedEvent event) {

        System.out.println("Processing payment for order: " + event.getOrderId());
        System.out.println("Product id: " + event.getProductId());

        PaymentApprovedEvent paymentApprovedEvent =
                new PaymentApprovedEvent(
                        event.getOrderId(),
                        event.getProductId(),
                        "APPROVED"
                );

        paymentProducer.sendPaymentApprovedEvent(paymentApprovedEvent);

        System.out.println("Payment approved event published for order: " + event.getOrderId());
    }
}