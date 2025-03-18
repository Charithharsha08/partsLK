package lk.ijse.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reviewId;
    private String reviewDate;
    private String reviewTime;
    private String reviewDescription;
    private String reviewRating;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "shopId" , referencedColumnName = "shopId")
    private Shop shop;

    @ManyToOne
    @JoinColumn(name = "serviceId" , referencedColumnName = "serviceId")
    private Services services;
}
