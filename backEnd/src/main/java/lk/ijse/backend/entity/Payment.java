package lk.ijse.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Payment {
    @Id
    private String paymentId;
    private String paymentDate;
    private String paymentTime;
    private String paymentDescription;
    private String paymentAmount;
    private String paymentMethod;
    private String paymentStatus;

    @OneToOne
    @JoinColumn(name = "orderId", referencedColumnName = "orderId")
    private Order order;


}
