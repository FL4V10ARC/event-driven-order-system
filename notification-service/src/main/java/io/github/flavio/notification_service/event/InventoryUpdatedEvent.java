package io.github.flavio.notification_service.event;

public class InventoryUpdatedEvent {

    private Long orderId;
    private Long productId;
    private String status;

    public InventoryUpdatedEvent() {
    }

    public InventoryUpdatedEvent(Long orderId, Long productId, String status) {
        this.orderId = orderId;
        this.productId = productId;
        this.status = status;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public String getStatus() {
        return status;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}