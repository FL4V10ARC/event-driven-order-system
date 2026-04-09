package io.github.flavio.order_service.controller;
import io.github.flavio.order_service.entity.Order;
import io.github.flavio.order_service.event.OrderCreatedEvent;
import io.github.flavio.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderRepository repository;
    private final KafkaTemplate<String, Object> kafkaTemplate;
    
@PostMapping
    public Order create(@RequestBody Order order){

        Order saved = repository.save(order);

        OrderCreatedEvent event =
                new OrderCreatedEvent(saved.getId(), saved.getProductId());

        kafkaTemplate.send("order-created", event);

        return saved;
    }

}
