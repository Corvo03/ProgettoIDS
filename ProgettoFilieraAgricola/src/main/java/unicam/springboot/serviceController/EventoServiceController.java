package unicam.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.modelli.actors.AnimatoreFiliera;
import unicam.modelli.inviti.Evento;
import unicam.repository.Data;


@RestController
public class EventoServiceController {

    Data data = Data.getIstance();

    @GetMapping(value="/eventi/{id}")
    public ResponseEntity<Object> getEventi(@PathVariable("id") String id){
        AnimatoreFiliera animatore = data.getAnimatoreById(id);
        if(animatore == null)
            return new ResponseEntity<>("Animatore non presente", HttpStatus.BAD_REQUEST);
        if(!animatore.getListaEventi().isEmpty())
            return new ResponseEntity<>(animatore.getListaEventi(), HttpStatus.OK);
        return new ResponseEntity<>("eventi non trovati", HttpStatus.OK);
    }

    @PostMapping(value = "/evento/{id}")
    public ResponseEntity<Object> addEvento(@PathVariable("id") String idAnimatore,
                                            @RequestBody Evento evento){
        AnimatoreFiliera animatore = data.getAnimatoreById(idAnimatore);
        if(animatore == null)
            return new ResponseEntity<>("Animatore non presente", HttpStatus.BAD_REQUEST);
        animatore.creaEvento(evento);
        return new ResponseEntity<>("L'animatore "+animatore.getId()+"ha creato l'evento "+evento.getNome(),
                HttpStatus.CREATED);
    }
}