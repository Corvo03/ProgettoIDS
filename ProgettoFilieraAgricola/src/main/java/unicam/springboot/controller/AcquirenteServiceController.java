package unicam.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import unicam.modelli.actors.Acquirente;

@RestController
public class AcquirenteServiceController {
    private final Acquirente acquirente = new Acquirente("email","nome");

    @GetMapping("/acquirente")
    public ResponseEntity<Object> ottieniElementiMarketPlace(){
        return new ResponseEntity<>(acquirente.getListaMarketplace(), HttpStatus.OK);
    }

    //SERVE????
}
