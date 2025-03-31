package lk.ijse.backend.controller;

import lk.ijse.backend.DTO.UserDTO;
import lk.ijse.backend.util.JwtUtil;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import lk.ijse.backend.DTO.ResponseDTO;
import lk.ijse.backend.DTO.ShopDTO;
import lk.ijse.backend.service.ShopService;
import lk.ijse.backend.util.VarList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("api/v1/shop")
@CrossOrigin
public class ShopController {
    private final ShopService shopService;
    private final JwtUtil jwtUtil;

    public ShopController(ShopService shopService, JwtUtil jwtUtil) {
        this.shopService = shopService;
        this.jwtUtil = jwtUtil;
    }


    @PostMapping("/save")
    public ResponseEntity<ResponseDTO> saveShop(@Valid @RequestBody ShopDTO shopDTO, @RequestHeader ("Authorization") String authHeader) {
        System.out.println("method called");


        try {
            String token = authHeader.substring(7);
            System.out.println(token);

            UserDTO userDTO = jwtUtil.getUserFromToken(token);

            System.out.println("User" +  userDTO.toString());

            shopDTO.setUserDTO(userDTO);

            int res = shopService.saveShop(shopDTO);
            switch (res){
                case VarList.Created -> {
                    return ResponseEntity.status(HttpStatus.CREATED)
                            .body(new ResponseDTO(VarList.Created, "Success", null));
                }
                case VarList.Not_Acceptable -> {
                    return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                            .body(new ResponseDTO(VarList.Not_Acceptable, "Email Already Used", null));
                }
                default -> {
                    return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                            .body(new ResponseDTO(VarList.Bad_Gateway, "Error", null));
                }
            }
        }   catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(VarList.Internal_Server_Error, e.getMessage(), null));
        }
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateShop(@Valid @RequestBody ShopDTO shopDTO) {
        try {
            int res = shopService.updateShop(shopDTO);
            switch (res){
                case VarList.Created -> {
                    return ResponseEntity.status(HttpStatus.CREATED)
                            .body(new ResponseDTO(VarList.Created, "Success", null));
                }
                case VarList.Not_Acceptable -> {
                    return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                            .body(new ResponseDTO(VarList.Not_Found, "Shop not Found", null));
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

    @GetMapping("/search")
    public ResponseEntity<ResponseDTO> searchShop(@RequestHeader("Authorization") String authHeader) {
        try {
            String token = authHeader.substring(7);
            UserDTO userDTO = jwtUtil.getUserFromToken(token);

            ShopDTO shopDTO = shopService.findShop(userDTO);
            if (shopDTO != null) {
                return ResponseEntity.status(HttpStatus.OK)
                        .body(new ResponseDTO(VarList.OK, "Success", shopDTO));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ResponseDTO(VarList.Not_Found, "Shop not Found", null));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(VarList.Internal_Server_Error, e.getMessage(), null));
        }
    }
}
