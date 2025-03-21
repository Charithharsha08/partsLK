package lk.ijse.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/*
@AllArgsConstructor
@NoArgsConstructor
@Data
*/

@Entity
@Table(name = "`order`")

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;
    private Date orderDate;
    private Time orderTime;
    private String orderStatus;
    private String paymentType;
    private double orderTotal;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

    @OneToOne(mappedBy = "order")
    private Payment payment;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "order")
    private List<OrderedServiceDetails> serviceDetails = new ArrayList<>();

    public Order() {
    }

    public Order(long orderId, Date orderDate, Time orderTime, String orderStatus, String paymentType, double orderTotal, User user, Payment payment, List<OrderedServiceDetails> serviceDetails) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderTime = orderTime;
        this.orderStatus = orderStatus;
        this.paymentType = paymentType;
        this.orderTotal = orderTotal;
        this.user = user;
        this.payment = payment;
        this.serviceDetails = serviceDetails;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Time getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Time orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public List<OrderedServiceDetails> getServiceDetails() {
        return serviceDetails;
    }

    public void setServiceDetails(List<OrderedServiceDetails> serviceDetails) {
        this.serviceDetails = serviceDetails;
    }
}
