package io.github.flavio.notification_service.consumer;

import io.github.flavio.notification_service.event.InventoryUpdatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class InventoryUpdatedConsumer {

    @KafkaListener(topics = "inventory-updated", groupId = "notification-group")
    public void consume(InventoryUpdatedEvent event) {

        System.out.println("Sending notification for order: " + event.getOrderId());
        System.out.println("Product id: " + event.getProductId());
        System.out.println("Inventory status: " + event.getStatus());
        System.out.println("Notification sent successfully.");

    }
}