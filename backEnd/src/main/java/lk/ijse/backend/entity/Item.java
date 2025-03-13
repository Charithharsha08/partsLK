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
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String itemId;
    private String itemName;
    private String itemDescription;
    private String vehicleModel;
    private String fuelType;
    private String itemPrice;
    private String itemQty;

    @OneToMany(cascade = CascadeType.ALL,
    fetch = FetchType.LAZY,
    mappedBy = "item")
    private List<OrderedItemDetail> itemDetails = new ArrayList<>();
}
