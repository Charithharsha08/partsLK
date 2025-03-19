package lk.ijse.backend.service.impl;

import lk.ijse.backend.DTO.ReviewDTO;
import lk.ijse.backend.entity.Review;
import lk.ijse.backend.entity.Services;
import lk.ijse.backend.entity.Shop;
import lk.ijse.backend.entity.User;
import lk.ijse.backend.repo.ReviewRepository;
import lk.ijse.backend.repo.ServiceRepository;
import lk.ijse.backend.repo.ShopRepository;
import lk.ijse.backend.repo.UserRepository;
import lk.ijse.backend.service.ReviewService;
import lk.ijse.backend.util.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public int saveReview(ReviewDTO reviewDTO) {
        System.out.println("service Id - "+reviewDTO.getServiceDTO().getServiceId());
        System.out.println("shop Id - "+reviewDTO.getShopDTO().getShopId());
        try {
            if (reviewRepository.existsById(reviewDTO.getReviewId())) {
                return VarList.Not_Acceptable;
            } else {
                reviewRepository.save(modelMapper.map(reviewDTO, Review.class));
                return VarList.Created;
            }
        } catch (Exception e) {
            return VarList.Bad_Gateway;
        }
    }

}
