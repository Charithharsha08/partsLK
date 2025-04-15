package lk.ijse.backend.controller;

import lk.ijse.backend.DTO.PlacePaymentDTO;
import lk.ijse.backend.service.OrderService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;

@RequestMapping
@RestController("/api/v")
public class OrderController {
}
