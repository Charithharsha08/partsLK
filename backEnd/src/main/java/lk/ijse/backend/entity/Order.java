package lk.ijse.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name = "`order`")

public class Order {
    @Id
    private String orderId;
    private String orderDate;
    private String orderTime;
    private String orderStatus;
    private String paymentType;
    private String orderTotal;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

    @OneToOne(mappedBy = "order")
    private Payment payment;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "order")
    private List<OrderedServiceDetails> serviceDetails = new ArrayList<>();



}
