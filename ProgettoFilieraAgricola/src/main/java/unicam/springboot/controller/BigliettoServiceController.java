package unicam.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import unicam.springboot.dto.BigliettoDTO;
import unicam.modelli.actors.AnimatoreFiliera;
import unicam.modelli.inviti.Evento;
import unicam.repository.Data;

@RestController
public class BigliettoServiceController {
    Data data = Data.getIstance();

    /* Crea biglietto */
    @PostMapping("/biglietto")
    public ResponseEntity<Object> addBiglietto(@RequestBody BigliettoDTO bigliettoDTO) {
        AnimatoreFiliera animatore = data.getAnimatoreById(bigliettoDTO.getIdAnimatore());

        Evento evento = data.getEventoById(bigliettoDTO.getIdEvento(), bigliettoDTO.getIdAnimatore());
        if(evento==null)
            return new ResponseEntity<>("Evento non presente", HttpStatus.BAD_REQUEST);
        if(animatore == null)
            return new ResponseEntity<>("Animatore non presente", HttpStatus.BAD_REQUEST);
        try {
            animatore.creaBiglietto(bigliettoDTO.getId(), bigliettoDTO.getPrezzo(), bigliettoDTO.getNomeItem(), bigliettoDTO.getDescrizione(), animatore, evento);
            return new ResponseEntity<>("Biglietto creato con successo per l'evento "+evento.getNome(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}