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

    @PutMapping("/stocks/{idAzienda}/{idProdotto}/{quantita}")
    public ResponseEntity<Object> addQuantita(@PathVariable String idAzienda, @PathVariable String idProdotto, @PathVariable Integer quantita) {
        Data data = Data.getIstance();
        if (data.getAziendaById(idAzienda) == null) {
            return new ResponseEntity<>("Azienda non trovata", HttpStatus.BAD_REQUEST);
        }
        if (data.getProdottoByAzienda(idAzienda, idProdotto) == null) {
            return new ResponseEntity<>("Prodotto non trovato", HttpStatus.BAD_REQUEST);
        }
        data.getAziendaById(idAzienda).getGestoreStock().getStock(idProdotto).addQuantita(quantita);
        return new ResponseEntity<>("quantità aggiunta", HttpStatus.OK);
    }

    @DeleteMapping("/stocks/{idAzienda}/{idProdotto}/{quantita}")
    public ResponseEntity<Object> removeQuantita(@PathVariable String idAzienda, @PathVariable String idProdotto, @PathVariable Integer quantita){
        Data data = Data.getIstance();
        if (data.getAziendaById(idAzienda) == null) {
            return new ResponseEntity<>("Azienda non trovata", HttpStatus.BAD_REQUEST);
        }
        if (data.getProdottoByAzienda(idAzienda, idProdotto) == null) {
            return new ResponseEntity<>("Prodotto non trovato", HttpStatus.BAD_REQUEST);
        }
        if (data.getAziendaById(idAzienda).getGestoreStock().getStock(idProdotto).getQuantita() < quantita) {
            return new ResponseEntity<>("Quantità errata", HttpStatus.BAD_REQUEST);
        }
        data.getAziendaById(idAzienda).getGestoreStock().getStock(idProdotto).removeQuantita(quantita);
        return new ResponseEntity<>("quantità rimossa", HttpStatus.OK);
    }


}
