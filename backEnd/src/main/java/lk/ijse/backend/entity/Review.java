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
public class Review {
    @Id
    private String reviewId;
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
    private Service service;
}
