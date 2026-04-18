package io.github.flavio.order_service.service;
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

    public Order createOrder(Order order) {
        Order saved = orderRepository.save(order);
        kafkaProducerService.sendOrderCreatedEvent(
                new OrderCreatedEvent(saved.getId(), saved.getProductId()));
        return saved;
    }
}
