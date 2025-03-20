package lk.ijse.backend.DTO;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class PlacePaymentDTO {
    private UserDTO userDTO;
    private List<ItemDTO> itemDTOS;
    private List<ServiceDTO> serviceDTOS;
    @NotBlank
    private String paymentMethod;
    private String orderStatus;

    public PlacePaymentDTO() {
    }

    public PlacePaymentDTO(UserDTO userDTO, List<ItemDTO> itemDTOS, List<ServiceDTO> serviceDTOS, String paymentMethod, String orderStatus) {
        this.userDTO = userDTO;
        this.itemDTOS = itemDTOS;
        this.serviceDTOS = serviceDTOS;
        this.paymentMethod = paymentMethod;
        this.orderStatus = orderStatus;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public List<ItemDTO> getItemDTOS() {
        return itemDTOS;
    }

    public void setItemDTOS(List<ItemDTO> itemDTOS) {
        this.itemDTOS = itemDTOS;
    }

    public List<ServiceDTO> getServiceDTOS() {
        return serviceDTOS;
    }

    public void setServiceDTOS(List<ServiceDTO> serviceDTOS) {
        this.serviceDTOS = serviceDTOS;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
