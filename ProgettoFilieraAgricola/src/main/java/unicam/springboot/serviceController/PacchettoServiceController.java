package unicam.springboot.serviceController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import unicam.modelli.actors.DistributoreTipicita;
import unicam.modelli.elements.Item;
import unicam.modelli.elements.Pacchetto;
import unicam.modelli.elements.Prodotto;

import java.util.List;

@RestController
public class PacchettoServiceController {
    private final DistributoreTipicita distributoreTipicita = new DistributoreTipicita("nome","descrizione",null, null);


    @PostMapping("/pacchetto/creaPacchetto")
    public ResponseEntity<Object> crePacchetto(float prezzo, String nome, String descrizione, List<Prodotto> listaProdotti) {
        distributoreTipicita.creaPacchetto(prezzo, nome, descrizione, listaProdotti);
        return new ResponseEntity<>("pacchetto creato", HttpStatus.OK);
    }

    @PostMapping("/pacchetto/creaPacchetto/conDescrizione")
    public ResponseEntity<Object> crePacchetto(float prezzo, String nome, String descrizione) {
        distributoreTipicita.creaPacchetto(prezzo, nome, descrizione);
        return new ResponseEntity<>("pacchetto creato", HttpStatus.OK);
    }

    @PostMapping("/pacchetto/aggiungiItem")
    public ResponseEntity<Object> aggiungiItemAPacchetto(Pacchetto pacchetto, Prodotto prodotto) {
        distributoreTipicita.aggiungiItemAPacchetto(pacchetto, prodotto);
        return new ResponseEntity<>("Item aggiunto", HttpStatus.OK);
    }

    @GetMapping ("/pacchetto/listaPacchetti")
    public ResponseEntity<List<Item>> getPacchetto() {
        return new ResponseEntity<>( distributoreTipicita.getPacchettiStock() ,HttpStatus.OK);
    }

    @GetMapping ("/pacchetto/nome")
    public ResponseEntity<Pacchetto> getPacchetto(@RequestParam String nome) {
        return new ResponseEntity<>(distributoreTipicita.getPacchettoStock(nome), HttpStatus.OK);
    }

}
