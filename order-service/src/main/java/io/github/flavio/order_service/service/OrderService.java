package io.github.flavio.order_service.service;
import org.springframework.stereotype.Service;
import io.github.flavio.order_service.entity.Order;
import io.github.flavio.order_service.event.OrderCreatedEvent;
import io.github.flavio.order_service.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final KafkaProducerService kafkaProducerService;

    public OrderService(OrderRepository orderRepository,
                    KafkaProducerService kafkaProducerService) {

    this.orderRepository = orderRepository;
    this.kafkaProducerService = kafkaProducerService;
}
    
}
