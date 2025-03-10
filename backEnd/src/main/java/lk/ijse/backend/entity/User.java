package lk.ijse.backend.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {
    @Id
    private String userId;
    private String username;
    private String email;
    private String mobile;
    private String address;
    private String nic;
    private String dob;
    private String password;
    private String role;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "user")
    private List<Order> orders;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "user")
    private List<Review> reviews;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "user")
    private List<Shop> shops;




}
