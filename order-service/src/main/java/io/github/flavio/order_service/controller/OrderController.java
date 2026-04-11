package io.github.flavio.order_service.controller;

import io.github.flavio.order_service.entity.Order;
import io.github.flavio.order_service.event.OrderCreatedEvent;
import io.github.flavio.order_service.repository.OrderRepository;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderRepository repository;
    private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;

    // Construtor para injeção do Spring
    public OrderController(
            OrderRepository repository,
            KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate) {

        this.repository = repository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {

        Order saved = repository.save(order);

        OrderCreatedEvent event =
                new OrderCreatedEvent(saved.getId(), saved.getProductId());

        kafkaTemplate.send("order-created", event);

        return saved;
    }
}