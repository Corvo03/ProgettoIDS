package unicam.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.modelli.actors.Produttore;
import unicam.modelli.elements.Prodotto;
import unicam.modelli.elements.Stock;

@RestController
public class StockServiceController {
    Stock stock = new Stock(new Prodotto(19.99,"nome","descrizione",
            new Produttore("nome","descrizione",null,null)));

    @GetMapping ("/stock")
    public ResponseEntity<Object> getQuantita(){
        return new ResponseEntity<>(stock.getQuantita(), HttpStatus.OK);
    }

    @PostMapping("/stock")
    public ResponseEntity<Object> setQuantita(@RequestParam Integer quantita){
        stock.setQuantita(quantita);
        return new ResponseEntity<>("quantità settata", HttpStatus.OK);
    }

    @PostMapping("/stock/add")
    public ResponseEntity<Object> addQuantita(@RequestParam Integer quantita){
        stock.addQuantita(quantita);
        return new ResponseEntity<>("quantità aggiunta", HttpStatus.OK);
    }

    @GetMapping("/stock/item")
    public ResponseEntity<Object> getItem(){
        return new ResponseEntity<>(stock.getItem(), HttpStatus.OK);
    }

    @GetMapping("/stock/nomeItem")
    public ResponseEntity<Object> getNomeItem(){
        return new ResponseEntity<>(stock.getNomeItem(), HttpStatus.OK);
    }
}
