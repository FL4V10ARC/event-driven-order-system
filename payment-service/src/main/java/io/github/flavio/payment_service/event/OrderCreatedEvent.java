package io.github.flavio.payment_service.event;

public class OrderCreatedEvent {

    private Long orderId;
    private Long productId;

    public OrderCreatedEvent() {
    }

    public OrderCreatedEvent(Long orderId, Long productId) {
        this.orderId = orderId;
        this.productId = productId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}