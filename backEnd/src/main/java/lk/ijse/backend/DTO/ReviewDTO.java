package lk.ijse.backend.DTO;


public class ReviewDTO {
    private String reviewId;
    private String reviewDate;
    private String reviewTime;
    private String reviewDescription;
    private String reviewRating;
    private UserDTO userDTO;
    private ShopDTO shopDTO;
    private ServiceDTO serviceDTO;

    public ReviewDTO() {
    }

    public ReviewDTO(String reviewId, String reviewDate, String reviewTime, String reviewDescription, String reviewRating, UserDTO userDTO, ShopDTO shop, ServiceDTO serviceDTO) {
        this.reviewId = reviewId;
        this.reviewDate = reviewDate;
        this.reviewTime = reviewTime;
        this.reviewDescription = reviewDescription;
        this.reviewRating = reviewRating;
        this.userDTO = userDTO;
        this.shopDTO = shop;
        this.serviceDTO = serviceDTO;
    }

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public String getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(String reviewTime) {
        this.reviewTime = reviewTime;
    }

    public String getReviewDescription() {
        return reviewDescription;
    }

    public void setReviewDescription(String reviewDescription) {
        this.reviewDescription = reviewDescription;
    }

    public String getReviewRating() {
        return reviewRating;
    }

    public void setReviewRating(String reviewRating) {
        this.reviewRating = reviewRating;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public ShopDTO getShopDTO() {
        return shopDTO;
    }

    public void setShopDTO(ShopDTO shopDTO) {
        this.shopDTO = shopDTO;
    }

    public ServiceDTO getServiceDTO() {
        return serviceDTO;
    }

    public void setServiceDTO(ServiceDTO serviceDTO) {
        this.serviceDTO = serviceDTO;
    }
}
