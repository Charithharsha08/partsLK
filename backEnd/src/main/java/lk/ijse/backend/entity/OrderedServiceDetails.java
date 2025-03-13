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
public class OrderedServiceDetails {
    @Id
    private String serviceDetailId;
    private String serviceId;
    private String userId;
    private String serviceName;
    private String serviceDate;
    private String servicePrice;
    private String serviceDuration;
    private String serviceType;
    private String serviceStatus;



    @ManyToOne
    @JoinColumn(name = "orderId", referencedColumnName = "orderId",insertable = false, updatable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "serviceId", referencedColumnName = "serviceId",insertable = false, updatable = false)
    private Services services;
}
