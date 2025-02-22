package unicam.springboot.serviceController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import unicam.modelli.actors.Produttore;
import unicam.modelli.elements.ElementoMarketplace;
import unicam.modelli.elements.Prodotto;
import unicam.modelli.elements.Stock;

@RestController
public class ElementiMarketPlaceServiceController {
    private final ElementoMarketplace elementoMarketplace = new ElementoMarketplace
            (new Stock
                    (new Prodotto(19.99,"nome","descrizione",
                            new Produttore("1","nome","descrizione",null,null),"aaa")));

    @GetMapping("/elementiMarketPlace")
    public ResponseEntity<Object> getQuantitaDisponibile(){
        return new ResponseEntity<>(elementoMarketplace.getQuantitaDisponibile(), HttpStatus.OK);
    }

    @PostMapping("/elementiMarketPlace")
    public ResponseEntity<Object> decrementaQuantita(int quantita){
        elementoMarketplace.decrementaQuantita(quantita);
        return new ResponseEntity<>("elemento decrementato", HttpStatus.OK);
    }
}
