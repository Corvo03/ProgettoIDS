package unicam.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import unicam.modelli.actors.Produttore;
import unicam.modelli.actors.azienda.Azienda;
import unicam.modelli.informazioniAggiuntive.MetodoProduzione;

@RestController
public class MetodoProduzioneServiceController {
    private final Produttore produttore = new Produttore("nome", "descrizione", null, null);


    @GetMapping ("/metodoProduzione")
    public ResponseEntity<Object> getMetodoProduzione(@RequestParam String nome) {
        return ResponseEntity.ok(produttore.getMetodoProduzione(nome));
    }

    @PostMapping("/metodoProduzione/aggiungiMetodoProduzione")
    public ResponseEntity<Object> creaMetodoProduzione(String nomeMetodoProduzione, String nomeStep) {
        produttore.creaMetodoProduzione(nomeMetodoProduzione, nomeStep);
        return ResponseEntity.ok("Step aggiunto");
    }

    @PostMapping("/metodoProduzione/eliminaMetodoProduzione")
    public ResponseEntity<Object> eliminaMetodoProduzione(String nomeMetodoProduzione) {
        produttore.getGestoreMetodoProduzione().eliminaMetodoProduzione(nomeMetodoProduzione);
        return ResponseEntity.ok("Metodo eliminato");
    }
    //TODO risolvere problema, stesso mapping definito sopra.
/*
    @PostMapping("/metodoProduzione/aggiungiMetodoProduzione")
    public ResponseEntity<Object> aggiungiMetodoProduzione(MetodoProduzione metodoProduzione) {
        produttore.getGestoreMetodoProduzione().aggiungiMetodoProduzione(metodoProduzione);
        return ResponseEntity.ok("Step aggiunto");
    }
    */
}
