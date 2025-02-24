package unicam.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.modelli.actors.Acquirente;
import unicam.modelli.elements.ElementoMarketplace;
import unicam.modelli.gestori.GestoreSistema;
import unicam.modelli.marketplace.Bancomat;
import unicam.modelli.marketplace.MetodoPagamento;
import unicam.modelli.marketplace.PayPal;
import unicam.repository.Data;
import unicam.springboot.dto.CarrelloDTO;
import unicam.springboot.dto.ElementoMarketPlaceDTO;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CarrelloServiceController {
    private final GestoreSistema gS = GestoreSistema.getInstance();

    @GetMapping("/carrello/{idAcquirente}")
    public ResponseEntity<Object> getCarrello(@PathVariable String idAcquirente) {
        Acquirente acquirente = Data.getIstance().getAcquirenteById(idAcquirente);
        if (acquirente == null) {
            return new ResponseEntity<>("Acquirente non trovato", HttpStatus.BAD_REQUEST);
        }
        List<CarrelloDTO> dto = new ArrayList<>();
        for (ElementoMarketplace e : acquirente.getCarrello().getElementiCarrello().keySet()) {
            dto.add(new CarrelloDTO(e, acquirente.getCarrello().getElementiCarrello().get(e)));
        }
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PutMapping("/carrello/{idAcquirente}/{idElemento}/{quantita}")
    public ResponseEntity<Object> aggiungiElementoAlCarrello(@PathVariable String idAcquirente
            , @PathVariable String idElemento, @PathVariable Integer quantita){
        Acquirente acquirente = Data.getIstance().getAcquirenteById(idAcquirente);
        if (acquirente == null) {
            return new ResponseEntity<>("Acquirente non trovato", HttpStatus.BAD_REQUEST);
        }
        ElementoMarketplace elemento = gS.getElementoMarketplaceDaId(idElemento);
        if (elemento == null) {
            return new ResponseEntity<>("Elemento non trovato", HttpStatus.BAD_REQUEST);
        }
        if (quantita <= 0) {
            return new ResponseEntity<>("Quantità non valida", HttpStatus.BAD_REQUEST);
        }
        if (quantita > elemento.getStock().getQuantita()) {
            return new ResponseEntity<>("Quantità non disponibile", HttpStatus.BAD_REQUEST);
        }
        acquirente.aggiungiElementoAlCarrello(elemento, quantita);
        return new ResponseEntity<>("Elemento aggiunto al carrello", HttpStatus.OK);
    }

    @DeleteMapping("/carrello/{idAcquirente}/{idElemento}/{quantita}")
    public ResponseEntity<Object> rimuoviElementoDalCarrello(@PathVariable String idAcquirente,
                                                             @PathVariable String idElemento, @PathVariable Integer quantita){
        Acquirente acquirente = Data.getIstance().getAcquirenteById(idAcquirente);
        if (acquirente == null) {
            return new ResponseEntity<>("Acquirente non trovato", HttpStatus.BAD_REQUEST);
        }
        ElementoMarketplace elemento = gS.getElementoMarketplaceDaId(idElemento);
        if (elemento == null) {
            return new ResponseEntity<>("Elemento non trovato", HttpStatus.BAD_REQUEST);
        }
        if (quantita <= 0) {
            return new ResponseEntity<>("Quantità non valida", HttpStatus.BAD_REQUEST);
        }
        if (quantita > acquirente.getCarrello().getElementiCarrello().get(elemento)) {
            return new ResponseEntity<>("Quantità non valida", HttpStatus.BAD_REQUEST);
        }
        acquirente.eliminaElementoDalCarrello(elemento, quantita);
        return new ResponseEntity<>("Elemento rimosso dal carrello", HttpStatus.OK);
    }

    @DeleteMapping("/carrello/remove/{idAcquirente}/{idElemento}")
    public ResponseEntity<Object> rimuoviElementoDalCarrello(@PathVariable String idAcquirente,
                                                             @PathVariable String idElemento){
        Acquirente acquirente = Data.getIstance().getAcquirenteById(idAcquirente);
        if (acquirente == null) {
            return new ResponseEntity<>("Acquirente non trovato", HttpStatus.BAD_REQUEST);
        }
        ElementoMarketplace elemento = gS.getElementoMarketplaceDaId(idElemento);
        if (elemento == null) {
            return new ResponseEntity<>("Elemento non trovato", HttpStatus.BAD_REQUEST);
        }
        acquirente.eliminaElementoDalCarrello(elemento);
        return new ResponseEntity<>("Elemento rimosso dal carrello", HttpStatus.OK);
    }

    @PostMapping("/carrello/paga/paypal/{idAcquirente}")
    public ResponseEntity<Object> pagaCarrelloPaypal(@PathVariable String idAcquirente){
        Acquirente acquirente = Data.getIstance().getAcquirenteById(idAcquirente);
        if (acquirente == null) {
            return new ResponseEntity<>("Acquirente non trovato", HttpStatus.BAD_REQUEST);
        }
        MetodoPagamento metodoPagamento = new PayPal();
        return new ResponseEntity<>(acquirente.completaAcquisto(metodoPagamento), HttpStatus.OK);
    }

    @PostMapping("/carrello/paga/bancomat/{idAcquirente}")
    public ResponseEntity<Object> pagaCarrelloBancomat(@PathVariable String idAcquirente){
        Acquirente acquirente = Data.getIstance().getAcquirenteById(idAcquirente);
        if (acquirente == null) {
            return new ResponseEntity<>("Acquirente non trovato", HttpStatus.BAD_REQUEST);
        }
        MetodoPagamento metodoPagamento = new Bancomat();
        return new ResponseEntity<>(acquirente.completaAcquisto(metodoPagamento), HttpStatus.OK);
    }
}
