package lk.ijse.backend.controller;

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

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }


    @PostMapping("/save")
    public ResponseEntity<ResponseDTO> saveShop(@Valid @RequestBody ShopDTO shopDTO) {
        try {
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
    @DeleteMapping("/delete/{shopId}")
    public ResponseEntity<ResponseDTO> deleteShop(@PathVariable long shopId) {
        try {
            int res = shopService.deleteShop(shopId);
            switch (res){
                case VarList.OK -> {
                    return ResponseEntity.status(HttpStatus.OK)
                            .body(new ResponseDTO(VarList.OK, "Success", null));
                }
                case VarList.Not_Found -> {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND)
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

    @GetMapping("/search/{shopEmail}")
    public ResponseEntity<ResponseDTO> searchShop(@PathVariable String shopEmail) {
        try {
            ShopDTO shopDTO = shopService.searchShop(shopEmail);
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
