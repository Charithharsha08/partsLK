package lk.ijse.backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/placeOrder")
@CrossOrigin

public class PlaceOrderController {


    @PostMapping("/save")
    public void placeOrder(){

    }
}
