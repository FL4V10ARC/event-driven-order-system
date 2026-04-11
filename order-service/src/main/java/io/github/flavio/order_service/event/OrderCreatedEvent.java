package io.github.flavio.order_service.event;
public class OrderCreatedEvent {

    private Long orderId;
    private Long productId;

    // construtor vazio
    public OrderCreatedEvent() {
    }

    // construtor usado pelo controller
    public OrderCreatedEvent(Long orderId, Long productId) {
        this.orderId = orderId;
        this.productId = productId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}