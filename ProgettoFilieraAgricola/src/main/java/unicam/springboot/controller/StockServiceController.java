package unicam.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.modelli.actors.Produttore;
import unicam.modelli.elements.Prodotto;
import unicam.modelli.elements.Stock;
import unicam.modelli.gestori.GestoreSistema;


@RestController
public class StockServiceController {

    GestoreSistema gs = GestoreSistema.getInstance();


    @GetMapping ("/stocks/")
    public ResponseEntity<Object> getQuantita(@RequestBody String idAzienda, @RequestBody String idProdotto){
        return new ResponseEntity<>(gs.getAzienda(idAzienda).getGestoreStock()
                .getStock(idProdotto).getQuantita(), HttpStatus.OK);
    }

    @PostMapping("/stock/add")
    public ResponseEntity<Object> addQuantita(@RequestParam Integer quantita){
//        stock.addQuantita(quantita);
        return new ResponseEntity<>("quantità aggiunta", HttpStatus.OK);
    }


}
