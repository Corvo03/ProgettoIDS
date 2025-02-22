package unicam.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import unicam.modelli.actors.Curatore;
import unicam.modelli.actors.Produttore;
import unicam.modelli.actors.azienda.Azienda;
import unicam.modelli.elements.Prodotto;
import unicam.modelli.gestori.GestoreInformazioni;
import unicam.modelli.marketplace.InformazioneDaApprovare;

@RestController
public class InformazioneDaApprovareServiceController {
    private final Curatore curatore = new Curatore("nome","mail");
    private final GestoreInformazioni gi = GestoreInformazioni.getInstance();

    @GetMapping("/infoDaApprovare")
    public ResponseEntity<Object> getInformazioneDaApprovare() {
        return new ResponseEntity<>(gi.getInformazioniDaApprovare(), HttpStatus.OK);
    }

    @PostMapping("/infoDaApprovare/approvaInfo")
    public ResponseEntity<Object> approvaInformazione(InformazioneDaApprovare informazioneDaApprovare) {
        curatore.approvaInformazione(informazioneDaApprovare);
        return new ResponseEntity<>("Informazione approvata",HttpStatus.OK);
    }

    @PostMapping("/infoDaApprovare/rifiutaInfo")
    public ResponseEntity<Object> rifiutaInformazione(InformazioneDaApprovare informazioneDaApprovare) {
        curatore.rifiutaInformazione(informazioneDaApprovare);
        return new ResponseEntity<>("Informazione rifiutata", HttpStatus.OK);
    }
}
