package lk.ijse.backend.controller;

import jakarta.validation.Valid;
import lk.ijse.backend.DTO.ItemDTO;
import lk.ijse.backend.DTO.PlacePaymentDTO;
import lk.ijse.backend.DTO.ResponseDTO;
import lk.ijse.backend.DTO.UserDTO;
import lk.ijse.backend.service.ItemService;
import lk.ijse.backend.service.PlacePaymentService;
import lk.ijse.backend.service.UserService;
import lk.ijse.backend.util.JwtUtil;
import lk.ijse.backend.util.VarList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/placeOrder")
@CrossOrigin

public class PlaceOrderController {
    private final PlacePaymentService placePaymentService;
    private final UserService userService;
    private final ItemService itemService;
    private final JwtUtil jwtUtil;

    public PlaceOrderController(PlacePaymentService placePaymentService, UserService userService, ItemService itemService, JwtUtil jwtUtil) {
        this.placePaymentService = placePaymentService;
        this.userService = userService;
        this.itemService = itemService;

        this.jwtUtil = jwtUtil;
    }


    @PostMapping("/save")
    public ResponseEntity<ResponseDTO> placeOrder(@RequestHeader ("Authorization") String authHeader,@Valid @RequestBody PlacePaymentDTO placePaymentDTO ) {
        try{
            System.out.println("place order method DTO" + placePaymentDTO);
            String token = authHeader.substring(7);

            String username = jwtUtil.getUsernameFromToken(token);
            UserDTO userDTO = userService.searchUser(username);
            placePaymentDTO.setUserDTO(userDTO);

            for (ItemDTO itemDTO : placePaymentDTO.getItemDTOS()) {
                System.out.println("Controller eke thiyana dto eka "+itemDTO);
                ItemDTO item = itemService.searchItem(itemDTO.getItemId());
                itemDTO.setItemDescription(item.getItemDescription());
                if (item.getItemQty() < itemDTO.getItemQty()) {
                    return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                            .body(new ResponseDTO(VarList.Not_Acceptable, "Item Quantity Not Available", null));
                }
            }

            int res = placePaymentService.placePayment(placePaymentDTO);

            switch (res){
                case VarList.Created -> {
                    return ResponseEntity.status(HttpStatus.CREATED)
                            .body(new ResponseDTO(VarList.Created, "Success", null));
                }
                case VarList.Not_Acceptable -> {
                    return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                            .body(new ResponseDTO(VarList.Not_Acceptable, "Can't Place Order", null));
                }
                default -> {
                    return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                            .body(new ResponseDTO(VarList.Bad_Gateway, "Error", null));
                }
            }

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(VarList.Internal_Server_Error, e.getMessage(), null));
        }
    }
}
