package lk.ijse.backend.service;

import lk.ijse.backend.DTO.PlacePaymentDTO;

public interface PlacePaymentService {
    int savePayment(PlacePaymentDTO placePaymentDTO);
}
