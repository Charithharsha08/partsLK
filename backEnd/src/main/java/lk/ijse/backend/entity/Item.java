package lk.ijse.backend.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Item {
    @Id
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
