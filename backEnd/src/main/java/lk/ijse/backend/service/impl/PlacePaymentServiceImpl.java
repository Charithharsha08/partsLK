package lk.ijse.backend.service.impl;

import lk.ijse.backend.DTO.ItemDTO;
import lk.ijse.backend.DTO.PlacePaymentDTO;
import lk.ijse.backend.DTO.ServiceDTO;
import lk.ijse.backend.entity.*;
import lk.ijse.backend.repo.ItemRepository;
import lk.ijse.backend.repo.OrderItemDetailRepository;
import lk.ijse.backend.repo.OrderRepository;
import lk.ijse.backend.repo.OrderedServiceDetailRepository;
import lk.ijse.backend.service.PlacePaymentService;
import lk.ijse.backend.util.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Time;

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
    public int placePayment(PlacePaymentDTO placePaymentDTO) {
        double total = 0.0;
        for (ItemDTO itemDTO : placePaymentDTO.getItemDTOS()) {
            total += itemDTO.getItemQty() * itemDTO.getItemPrice();
        }

        for (ServiceDTO serviceDTO : placePaymentDTO.getServiceDTOS()) {
            total += serviceDTO.getServicePrice();
        }

        //save order table
        Order order = new Order();
        order.setOrderDate(new Date(System.currentTimeMillis()));
        order.setOrderTime(new Time(System.nanoTime()));
        order.setOrderStatus(placePaymentDTO.getOrderStatus());
        order.setPaymentType(placePaymentDTO.getPaymentMethod());
        order.setUser(modelMapper.map(placePaymentDTO.getUserDTO(), User.class));
        order.setOrderTotal(total);
        orderRepository.save(order);


        //save order item detail table
        if (placePaymentDTO.getItemDTOS() != null) {
            for (ItemDTO itemDTO : placePaymentDTO.getItemDTOS()) {
                OrderedItemDetail orderedItemDetail = new OrderedItemDetail();
                orderedItemDetail.setOrder(order);
                orderedItemDetail.setItem(modelMapper.map(itemDTO, lk.ijse.backend.entity.Item.class));
                orderedItemDetail.setDescription(itemDTO.getItemName());
                orderedItemDetail.setItemPrice(itemDTO.getItemPrice());
                orderedItemDetail.setQty(itemDTO.getItemQty());
                orderedItemDetail.setPrice(itemDTO.getItemQty() * itemDTO.getItemPrice());
                orderItemDetailRepository.save(orderedItemDetail);

            }
        }

        //save order service detail table
        if (placePaymentDTO.getServiceDTOS() != null) {
            for (ServiceDTO serviceDTO : placePaymentDTO.getServiceDTOS()) {
                OrderedServiceDetails orderedServiceDetails = new OrderedServiceDetails();
                orderedServiceDetails.setOrder(order);
                orderedServiceDetails.setServices(modelMapper.map(serviceDTO, lk.ijse.backend.entity.Services.class));
                orderedServiceDetails.setServiceDate(new Date(System.currentTimeMillis()));
                orderedServiceDetails.setServiceDuration(serviceDTO.getServiceDuration());
                orderedServiceDetails.setServiceName(serviceDTO.getServiceName());
                orderedServiceDetails.setServicePrice(serviceDTO.getServicePrice());
                orderedServiceDetails.setServiceStatus("Done");
                orderedServiceDetails.setServiceType(serviceDTO.getServiceType());
            }
        }

        //save payment table
        Payment payment = new Payment();
        payment.setOrder(order);
        payment.setPaymentDate(new Date(System.currentTimeMillis()));
        payment.setPaymentTime(new Time(System.nanoTime()));
        payment.setPaymentAmount(total);
        payment.setPaymentStatus("Done");
        payment.setPaymentMethod(placePaymentDTO.getPaymentMethod());
        order.setPayment(payment);


        //update item table
        if (placePaymentDTO.getItemDTOS() != null) {
            for (ItemDTO itemDTO : placePaymentDTO.getItemDTOS()) {
                Item item = itemRepository.findById(itemDTO.getItemId()).get();
                item.setItemQty(item.getItemQty() - itemDTO.getItemQty());
                itemRepository.save(item);
            }
        }
        return VarList.Created;
    }
}

