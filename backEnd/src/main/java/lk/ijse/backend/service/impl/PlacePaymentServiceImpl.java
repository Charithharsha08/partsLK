package lk.ijse.backend.service.impl;

import lk.ijse.backend.DTO.PlacePaymentDTO;
import lk.ijse.backend.entity.Item;
import lk.ijse.backend.repo.ItemRepository;
import lk.ijse.backend.repo.OrderItemDetailRepository;
import lk.ijse.backend.repo.OrderRepository;
import lk.ijse.backend.repo.OrderedServiceDetailRepository;
import lk.ijse.backend.service.PlacePaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PlacePaymentServiceImpl implements PlacePaymentService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderedServiceDetailRepository orderedServiceDetailRepository;

    @Autowired
    private OrderItemDetailRepository orderItemDetailRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public int savePayment(PlacePaymentDTO placePaymentDTO) {
        return 0;
    }
}
