package lk.ijse.backend.advicer;

import lk.ijse.backend.DTO.ResponseDTO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AppWideExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseDTO exceptionHandler(Exception exception ){
        return new ResponseDTO(500,exception.getMessage(),null);
    }
}