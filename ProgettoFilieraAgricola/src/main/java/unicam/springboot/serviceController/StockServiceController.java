package unicam.springboot.serviceController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.modelli.gestori.GestoreSistema;


@RestController
public class StockServiceController {

    GestoreSistema gs = GestoreSistema.getInstance();

    @GetMapping("/stocks/")
    public ResponseEntity<Object> getQuantita(@RequestBody String idAzienda, @RequestBody String idProdotto) {
        return new ResponseEntity<>(gs.getAzienda(idAzienda).getGestoreStock()
                .getStock(idProdotto).getQuantita(), HttpStatus.OK);
    }

    @PostMapping("/stock/add/{idAzienda}/{idProdotto}")
    public ResponseEntity<Object> addQuantita(@RequestParam Integer quantita) {
//        stock.addQuantita(quantita);
        return new ResponseEntity<>("quantità aggiunta", HttpStatus.OK);
    }


}
