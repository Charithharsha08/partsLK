package lk.ijse.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class OrderedItemDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderedItemDetailId;
    private long orderId;
    private long itemId;
    private String description;
    private double price;
    private double itemPrice;
    private int qty;

    @ManyToOne
    @JoinColumn(name = "orderId", referencedColumnName = "orderId",insertable = false, updatable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "itemId", referencedColumnName = "itemId",insertable = false, updatable = false)
    private Item item;

}
