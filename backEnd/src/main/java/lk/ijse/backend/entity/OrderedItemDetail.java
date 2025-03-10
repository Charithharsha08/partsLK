package lk.ijse.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class OrderedItemDetail {
    @Id
    private String orderedItemDetailId;
    private String orderId;
    private String itemId;
    private String description;
    private String price;
    private String itemPrice;
    private String qty;
    private String total;

    @ManyToOne
    @JoinColumn(name = "orderId", referencedColumnName = "orderId",insertable = false, updatable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "itemId", referencedColumnName = "itemId",insertable = false, updatable = false)
    private Item item;

}
