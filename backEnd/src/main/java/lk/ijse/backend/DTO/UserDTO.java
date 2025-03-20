package lk.ijse.backend.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

public class  UserDTO {
    private UUID userId;
    @Email(message = "Please provide a valid email address")
    private String email;
    @Pattern(regexp = "^[0-9]{10}$", message = "Please provide a valid mobile number")
    private String mobile;
    @NotBlank(message = "Name is required")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Name must contain only letters and spaces")
    @Size(min = 3, max = 50, message = "Name must contain 3-50 characters")
    private String address;
    @Pattern(regexp = "^[0-9]{9}[vVxX]$", message = "Please provide a valid NIC")
    private String nic;
    @Pattern(regexp = "^[0-9]{4}-[0-9]{2}-[0-9]{2}$", message = "Please provide a valid date of birth")
    private String dob;
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$", message = "Password must contain at least one uppercase letter, one lowercase letter, one number and at least 8 characters")
    private String password;
    private String role;

    public UserDTO() {
    }

    public UserDTO(UUID userId, String email, String mobile, String address, String nic, String dob, String password, String role) {
        this.userId = userId;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.nic = nic;
        this.dob = dob;
        this.password = password;
        this.role = role;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
