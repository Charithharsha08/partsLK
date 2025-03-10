package lk.ijse.backend.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Service {
    @Id
    private String serviceId;
    private String serviceName;
    private String serviceDescription;
    private String servicePrice;
    private String serviceDuration;
    private String serviceType;
    private String serviceStatus;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "service")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "service")
    private List<OrderedServiceDetails> serviceDetails = new ArrayList<>();

    public Service() {
    }

}
