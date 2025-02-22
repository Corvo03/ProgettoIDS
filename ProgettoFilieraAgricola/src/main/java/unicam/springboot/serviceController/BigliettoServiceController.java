package unicam.springboot.serviceController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import unicam.modelli.actors.AnimatoreFiliera;
import unicam.modelli.inviti.Evento;
import unicam.repository.Data;

@RestController
public class BigliettoServiceController {
    Data data = Data.getIstance();

    @PostMapping("/addbiglietto")
    public ResponseEntity<Object> addBiglietto(@RequestBody double prezzo,
                                             @RequestBody String nomeItem,
                                             @RequestBody String descrizione,
                                             @RequestBody String IdAnimatore,
                                             @RequestBody String IdEvento) {
        AnimatoreFiliera animatore = data.getAnimatoreById(IdAnimatore);
        Evento evento = data.getEventoById(IdEvento);
        if(evento==null)
            return new ResponseEntity<>("Evento non presente", HttpStatus.BAD_REQUEST);
        if(animatore == null)
            return new ResponseEntity<>("Animatore non presente", HttpStatus.BAD_REQUEST);
        try {
            animatore.creaBiglietto(prezzo, nomeItem, descrizione, animatore, evento);
            return new ResponseEntity<>("Biglietto creato con successo per l'evento"+evento.getNome(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
