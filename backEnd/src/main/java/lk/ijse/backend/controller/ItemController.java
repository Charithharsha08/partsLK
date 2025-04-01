package lk.ijse.backend.controller;


import lk.ijse.backend.DTO.ItemDTO;
import lk.ijse.backend.DTO.ResponseDTO;
import lk.ijse.backend.service.ItemService;
import lk.ijse.backend.util.FileUploadUtil;
import lk.ijse.backend.util.VarList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO> saveItem(@ModelAttribute ItemDTO itemDTO, @RequestParam("image") MultipartFile image) {
        try {
            String imagePath = FileUploadUtil.uploadFile("item-Images/", image.getOriginalFilename(), image);
            itemDTO.setItemImage("assets/images/item-Images/" + imagePath);
            int res = itemService.addItem(itemDTO);
            switch (res) {
                case VarList.Created -> {
                    return ResponseEntity.status(HttpStatus.CREATED)
                            .body(new ResponseDTO(VarList.Created, "Success", null));
                }
                case VarList.Not_Acceptable -> {
                    return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                            .body(new ResponseDTO(VarList.Not_Acceptable, "Item Already Exists", null));
                }
                default -> {
                    return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                            .body(new ResponseDTO(VarList.Bad_Gateway, "Error", null));
                }
            }
        } catch (IOException e) {
            return ResponseEntity.ok(new ResponseDTO(VarList.Internal_Server_Error, e.getMessage(), null));
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteItem(@PathVariable long id) {
        try {
            itemService.deleteItem(id);
            return ResponseEntity.ok(new ResponseDTO(VarList.OK, "Success", null));
        } catch (Exception e) {
            return ResponseEntity.ok(new ResponseDTO(VarList.Internal_Server_Error, e.getMessage(), null));
        }
    }
    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateItem(@ModelAttribute ItemDTO itemDTO, @RequestParam(value = "image", required = false) MultipartFile image) {
        try {
            if (image != null) {
                String imagePath = FileUploadUtil.uploadFile("item-Images/", image.getOriginalFilename(), image);
                System.out.println("ssaaa" + imagePath);
                itemDTO.setItemImage("assets/images/item-Images/" + imagePath);

                System.out.println(" meka print une "+itemDTO.getItemImage());
            }
           int res = itemService.updateItem(itemDTO);
            switch (res) {
                case VarList.OK -> {
                    return ResponseEntity.status(HttpStatus.OK)
                            .body(new ResponseDTO(VarList.OK, "Success", null));
                }
                case VarList.Not_Found -> {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND)
                            .body(new ResponseDTO(VarList.Not_Found, "Item Not Found", null));
                }
                default -> {
                    return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                            .body(new ResponseDTO(VarList.Bad_Gateway, "Error", null));
                }
            }
        } catch (IOException e) {
            return ResponseEntity.ok(new ResponseDTO(VarList.Internal_Server_Error, e.getMessage(), null));
        }
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<ResponseDTO> searchItem(@PathVariable long id) {
        ItemDTO itemDTO = itemService.searchItem(id);
        if (itemDTO != null) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDTO(VarList.OK, "Success", itemDTO));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponseDTO(VarList.Not_Found, "Item Not Found", null));
        }
    }
    @GetMapping("/check")
    public String check(){
        return "passed~!";
    }
}
