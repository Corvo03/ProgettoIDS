package unicam.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.modelli.gestori.GestoreSistema;
import unicam.repository.Data;


@RestController
public class StockServiceController {

    GestoreSistema gs = GestoreSistema.getInstance();

    @GetMapping("/stocks/{idAzienda}/{idProdotto}")
    public ResponseEntity<Object> getQuantita(@PathVariable String idAzienda, @PathVariable String idProdotto) {
        return new ResponseEntity<>(gs.getAzienda(idAzienda).getGestoreStock()
                .getStock(idProdotto).getQuantita(), HttpStatus.OK);
    }

    @PostMapping("/stocks/add/{idAzienda}/{idProdotto}/{quantita}")
    public ResponseEntity<Object> addQuantita(@PathVariable String idAzienda, @PathVariable String idProdotto, @PathVariable Integer quantita) {
        if (Data.getIstance().getAziendaById(idAzienda) == null) {
            return new ResponseEntity<>("Azienda non trovata", HttpStatus.BAD_REQUEST);
        }
        if (Data.getIstance().getProdottoByAzienda(idAzienda, idProdotto) == null) {
            return new ResponseEntity<>("Prodotto non trovato", HttpStatus.BAD_REQUEST);
        }
        Data.getIstance().getAziendaById(idAzienda).getGestoreStock().getStock(idProdotto).addQuantita(quantita);
        return new ResponseEntity<>("quantità aggiunta", HttpStatus.OK);
    }


}
