package unicam.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.modelli.actors.Acquirente;
import unicam.modelli.elements.ElementoMarketplace;
import unicam.modelli.gestori.GestoreSistema;
import unicam.modelli.marketplace.MetodoPagamento;

@RestController
public class CarrelloServiceController {
    private final GestoreSistema gS = GestoreSistema.getInstance();
    private final Acquirente acquirente = new Acquirente("email","nome");

    @GetMapping("/carrello")
    public ResponseEntity<Object> getElementiCarrello(){
        return new ResponseEntity<>(acquirente.getListaElementiCarrello(), HttpStatus.OK);
    }

    @PostMapping("/carrello")
    public ResponseEntity<Object> aggiungiElementoAlCarrello(@RequestBody ElementoMarketplace elemento){
        acquirente.aggiungiElementoAlCarrello(elemento,1);
        return new ResponseEntity<>("Elemento aggiunto al carrello",HttpStatus.OK);
    }

    @DeleteMapping("/carrello")
    public ResponseEntity<Object> rimuoviElementoCarrello(@RequestBody ElementoMarketplace elemento,Integer quantita){
        acquirente.eliminaElementoDalCarrello(elemento,quantita);
        return new ResponseEntity<>("Elementi rimosso dal carrello",HttpStatus.OK);
    }

    @PostMapping("/carrello/paga")
    public ResponseEntity<Object> pagaCarrello(@RequestBody MetodoPagamento metodoPagamento){
        return new ResponseEntity<>(acquirente.completaAcquisto(metodoPagamento),HttpStatus.OK);
    }
}
