package unicam.springboot.serviceController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import unicam.repository.Data;

@RestController
public class EventoServiceController {

    @GetMapping(value="/eventi")
    public ResponseEntity<Object> getEventi(){
        return new ResponseEntity<>(Data.eventi, HttpStatus.OK);
    }

}
