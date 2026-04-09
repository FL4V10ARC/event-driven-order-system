package io.github.flavio.order_service.entity;
import jakarta.persistence.*;
import lombok.Data;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    private Integer quantity;
    private Double price;
}
