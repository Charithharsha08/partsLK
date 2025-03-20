package lk.ijse.backend.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Component;

import java.sql.Date;


public class ShopDTO {
    private long shopId;
    @NotBlank(message = "Shop name is required")
    private String shopName;
    @NotBlank(message = "Shop address is required")
    @Size(min = 5, max = 100, message = "Shop address must contain 5-100 characters")
    private String shopAddress;
    @NotBlank(message = "Shop location is required")
    private String shopLocation;
    @Pattern(regexp = "^[0-9]{10}$", message = "Invalid phone number")
    private String shopContact;
    @Email(message = "Invalid email")
    private String shopEmail;
    @NotBlank
    private String shopOwner;
    @Pattern(regexp = "^[0-9]{10}$", message = "Invalid phone number")
    private String shopOwnerContact;
    @Email
    private String shopOwnerEmail;
    @Pattern(regexp = "^[0-9]{9}[vVxX]$", message = "Please provide a valid NIC")
    private String shopOwnerNIC;
    @Pattern(regexp = "^[0-9]{4}-[0-9]{2}-[0-9]{2}$", message = "Please provide a valid date of birth")
    private Date shopOwnerDOB;
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$", message = "Password must contain at least one uppercase letter, one lowercase letter, one number and at least 8 characters")
    private String shopOwnerPassword;
    @NotBlank(message = "Role is required")
    private String shopOwnerRole;
    private UserDTO userDTO;

    public ShopDTO() {
    }

    public ShopDTO(long shopId, String shopName, String shopAddress, String shopLocation, String shopContact, String shopEmail, String shopOwner, String shopOwnerContact, String shopOwnerEmail, String shopOwnerNIC, Date shopOwnerDOB, String shopOwnerPassword, String shopOwnerRole, UserDTO userDTO) {
        this.shopId = shopId;
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

    public long getShopId() {
        return shopId;
    }

    public void setShopId(long shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
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
