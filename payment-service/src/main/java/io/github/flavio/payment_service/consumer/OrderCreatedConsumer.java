package io.github.flavio.payment_service.consumer;
import io.github.flavio.payment_service.event.OrderCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderCreatedConsumer {

    @KafkaListener(topics = "order-created", groupId = "payment-group")
    public void consume(OrderCreatedEvent event) {
        System.out.println("Processing payment for order: " + event.getOrderId());
        System.out.println("Product id: " + event.getProductId());
    }
}