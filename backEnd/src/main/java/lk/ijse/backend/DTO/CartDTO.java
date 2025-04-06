package lk.ijse.backend.DTO;

public class CartDTO {
    private long cartId;
    private UserDTO userDTO;
    private long itemId;
    private String name;
    private String image;
    private int qty;
    private double price;
    private ShopDTO shopDTO;

    public CartDTO() {
    }

    public CartDTO(long cartId, UserDTO userDTO, long itemId, String name, String image, int qty, double price, ShopDTO shopDTO) {
        this.cartId = cartId;
        this.userDTO = userDTO;
        this.itemId = itemId;
        this.name = name;
        this.image = image;
        this.qty = qty;
        this.price = price;
        this.shopDTO = shopDTO;
    }

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
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

    public ShopDTO getShopDTO() {
        return shopDTO;
    }

    public void setShopDTO(ShopDTO shopDTO) {
        this.shopDTO = shopDTO;
    }
}
