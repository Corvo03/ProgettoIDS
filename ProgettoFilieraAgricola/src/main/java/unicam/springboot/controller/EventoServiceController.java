package unicam.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unicam.repository.Data;

import java.util.List;

@RestController
public class EventoServiceController {

    @GetMapping(value="/eventi")
    public ResponseEntity<Object> getEventi(){
        return new ResponseEntity<>(Data.eventi, HttpStatus.OK);
    }

    @GetMapping(value="/evento")
    public ResponseEntity<Object> getEventi(){
        return new ResponseEntity<>(Data.eventi, HttpStatus.OK);
    }
}
