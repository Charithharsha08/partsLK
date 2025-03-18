package lk.ijse.backend.DTO;

import org.springframework.stereotype.Component;

import java.sql.Date;


public class ShopDTO {
    private long shopName;
    private String shopAddress;
    private String shopLocation;
    private String shopContact;
    private String shopEmail;
    private String shopOwner;
    private String shopOwnerContact;
    private String shopOwnerEmail;
    private String shopOwnerNIC;
    private Date shopOwnerDOB;
    private String shopOwnerPassword;
    private String shopOwnerRole;
    private UserDTO userDTO;

    public ShopDTO() {
    }

    public ShopDTO(long shopName, String shopAddress, String shopLocation, String shopContact, String shopEmail, String shopOwner, String shopOwnerContact, String shopOwnerEmail, String shopOwnerNIC, Date shopOwnerDOB, String shopOwnerPassword, String shopOwnerRole, UserDTO userDTO) {
        this.shopName = shopName;
        this.shopAddress = shopAddress;
        this.shopLocation = shopLocation;
        this.shopContact = shopContact;
        this.shopEmail = shopEmail;
        this.shopOwner = shopOwner;
        this.shopOwnerContact = shopOwnerContact;
        this.shopOwnerEmail = shopOwnerEmail;
        this.shopOwnerNIC = shopOwnerNIC;
        this.shopOwnerDOB = shopOwnerDOB;
        this.shopOwnerPassword = shopOwnerPassword;
        this.shopOwnerRole = shopOwnerRole;
        this.userDTO = userDTO;
    }

    public long getShopName() {
        return shopName;
    }

    public void setShopName(long shopName) {
        this.shopName = shopName;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getShopLocation() {
        return shopLocation;
    }

    public void setShopLocation(String shopLocation) {
        this.shopLocation = shopLocation;
    }

    public String getShopContact() {
        return shopContact;
    }

    public void setShopContact(String shopContact) {
        this.shopContact = shopContact;
    }

    public String getShopEmail() {
        return shopEmail;
    }

    public void setShopEmail(String shopEmail) {
        this.shopEmail = shopEmail;
    }

    public String getShopOwner() {
        return shopOwner;
    }

    public void setShopOwner(String shopOwner) {
        this.shopOwner = shopOwner;
    }

    public String getShopOwnerContact() {
        return shopOwnerContact;
    }

    public void setShopOwnerContact(String shopOwnerContact) {
        this.shopOwnerContact = shopOwnerContact;
    }

    public String getShopOwnerEmail() {
        return shopOwnerEmail;
    }

    public void setShopOwnerEmail(String shopOwnerEmail) {
        this.shopOwnerEmail = shopOwnerEmail;
    }

    public String getShopOwnerNIC() {
        return shopOwnerNIC;
    }

    public void setShopOwnerNIC(String shopOwnerNIC) {
        this.shopOwnerNIC = shopOwnerNIC;
    }

    public Date getShopOwnerDOB() {
        return shopOwnerDOB;
    }

    public void setShopOwnerDOB(Date shopOwnerDOB) {
        this.shopOwnerDOB = shopOwnerDOB;
    }

    public String getShopOwnerPassword() {
        return shopOwnerPassword;
    }

    public void setShopOwnerPassword(String shopOwnerPassword) {
        this.shopOwnerPassword = shopOwnerPassword;
    }

    public String getShopOwnerRole() {
        return shopOwnerRole;
    }

    public void setShopOwnerRole(String shopOwnerRole) {
        this.shopOwnerRole = shopOwnerRole;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}
