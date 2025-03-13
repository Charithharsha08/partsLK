package lk.ijse.backend.service.impl;

import lk.ijse.backend.DTO.ReviewDTO;
import lk.ijse.backend.entity.Review;
import lk.ijse.backend.entity.Shop;
import lk.ijse.backend.entity.User;
import lk.ijse.backend.repo.ReviewRepository;
import lk.ijse.backend.service.ReviewService;
import lk.ijse.backend.util.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
private ReviewRepository reviewRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public int saveReview(ReviewDTO reviewDTO) {
        if (reviewRepository.existsById(reviewDTO.getReviewId())) {
            return VarList.Not_Acceptable;
        } else {
          /*  Shop shop = new ModelMapper().map(reviewDTO.getShopDTO(), Shop.class);
            User user = new ModelMapper().map(reviewDTO.getUserDTO(), User.class);
            lk.ijse.backend.entity.Service service = new ModelMapper().map(reviewDTO.getServiceDTO(), lk.ijse.backend.entity.Service.class);
            Review review = new ModelMapper().map(reviewDTO, Review.class);
            review.setShop(shop);
            review.setUser(user);
            review.setService(service);

            reviewRepository.save(review);*/

            reviewRepository.save(new ModelMapper().map(reviewDTO, Review.class));

            return VarList.Created;
        }
    }
}
