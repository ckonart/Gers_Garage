package Gers_Garage.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GarageUtils {

    private GarageUtils() {

    }

    public static ResponseEntity<String> getResponseEntity(String responseMessage, HttpStatus httpStatus) {
        return new ResponseEntity<String>("{\"message\":\""+responseMessage+"\"}", httpStatus);
    }
}
