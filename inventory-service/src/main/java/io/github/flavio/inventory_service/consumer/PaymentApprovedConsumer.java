package io.github.flavio.inventory_service.consumer;
import io.github.flavio.inventory_service.event.PaymentApprovedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentApprovedConsumer {

    @KafkaListener(topics = "payment-approved", groupId = "inventory-group")
    public void consume(PaymentApprovedEvent event) {

        System.out.println("Updating inventory for order: " + event.getOrderId());
        System.out.println("Product id: " + event.getProductId());
        System.out.println("Payment status: " + event.getStatus());
        System.out.println("Inventory updated successfully.");

    }
}