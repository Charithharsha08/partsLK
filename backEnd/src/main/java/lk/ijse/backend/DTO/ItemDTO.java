package lk.ijse.backend.DTO;


public class ItemDTO {
    private String itemId;
    private String itemName;
    private String itemDescription;
    private String vehicleModel;
    private String fuelType;
    private String itemPrice;
    private String itemQty;
    private String itemImage;

    public ItemDTO() {
    }

    public ItemDTO(String itemId, String itemName, String itemDescription, String vehicleModel, String fuelType, String itemPrice, String itemQty) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.vehicleModel = vehicleModel;
        this.fuelType = fuelType;
        this.itemPrice = itemPrice;
        this.itemQty = itemQty;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemQty() {
        return itemQty;
    }

    public void setItemQty(String itemQty) {
        this.itemQty = itemQty;
    }
}
