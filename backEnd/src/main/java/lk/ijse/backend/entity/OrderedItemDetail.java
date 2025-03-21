package lk.ijse.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/*@AllArgsConstructor
@NoArgsConstructor
@Data*/
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

    public OrderedItemDetail() {
    }

    public OrderedItemDetail(long orderedItemDetailId, long orderId, long itemId, String description, double price, double itemPrice, int qty, Order order, Item item) {
        this.orderedItemDetailId = orderedItemDetailId;
        this.orderId = orderId;
        this.itemId = itemId;
        this.description = description;
        this.price = price;
        this.itemPrice = itemPrice;
        this.qty = qty;
        this.order = order;
        this.item = item;
    }

    public long getOrderedItemDetailId() {
        return orderedItemDetailId;
    }

    public void setOrderedItemDetailId(long orderedItemDetailId) {
        this.orderedItemDetailId = orderedItemDetailId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
