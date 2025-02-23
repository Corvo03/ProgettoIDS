package unicam.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import unicam.modelli.gestori.GestoreSistema;

@RestController
public class MarketPlaceServiceController {
    GestoreSistema gs = GestoreSistema.getInstance();

    @GetMapping("/marketplace")
    public ResponseEntity<Object> getMarketPlace() {
        return new ResponseEntity<>(gs.getElementiDisponibiliMarketplace(), HttpStatus.OK);
    }
}
