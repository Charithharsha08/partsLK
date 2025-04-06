package lk.ijse.backend.DTO;

public class CartDTO {
    private long cartId;
    private long userId;
    private long itemId;
    private String name;
    private String image;
    private int qty;
    private double price;

    public CartDTO(long cartId, long userId, long itemId, String name, String image, int qty, double price) {
        this.cartId = cartId;
        this.userId = userId;
        this.itemId = itemId;
        this.name = name;
        this.image = image;
        this.qty = qty;
        this.price = price;
    }

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
