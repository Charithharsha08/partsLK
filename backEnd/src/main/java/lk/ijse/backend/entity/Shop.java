package lk.ijse.backend.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Shop {
    @Id
    private String shopId;
    private String shopName;
    private String shopAddress;
private String shopLocation;
    private String shopContact;
    private String shopEmail;
    private String shopOwner;
    private String shopOwnerContact;
    private String shopOwnerEmail;
    private String shopOwnerNIC;
    private String shopOwnerDOB;
    private String shopOwnerPassword;
    private String shopOwnerRole;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "shop")
    private List<Review> reviews = new ArrayList<>();

    public Shop() {
    }


}
