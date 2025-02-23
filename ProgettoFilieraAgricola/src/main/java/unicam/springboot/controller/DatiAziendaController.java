package unicam.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.modelli.actors.azienda.Azienda;
import unicam.modelli.actors.azienda.InformazioniSensibili;
import unicam.modelli.actors.azienda.Profilo;
import unicam.repository.Data;
import unicam.springboot.dto.AziendaDTO;

@RestController
public class DatiAziendaController {
    Data data = Data.getIstance();

    @GetMapping(value="/dati-sensibili/{id}")
    public ResponseEntity<Object> getDatiSensibiili(@PathVariable("id") String idAzienda) {
        Azienda azienda = data.getAziendaById(idAzienda);
        if(azienda == null)
            return new ResponseEntity<>("Azienda non presente", HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(azienda.getInformazioniSensibili(), HttpStatus.OK);
    }

    @PutMapping(value="/dati-sensibili/{id}")
    public ResponseEntity<Object> modificaDatiSensibili(@PathVariable("id") String idAzienda,
                                                        @RequestBody InformazioniSensibili info) {
        Azienda azienda = data.getAziendaById(idAzienda);
        if(azienda == null)
            return new ResponseEntity<>("Azienda non presente", HttpStatus.BAD_REQUEST);
        azienda.modificaDatiSensibili(info);
        return new ResponseEntity<>(info, HttpStatus.OK);
    }

    @PutMapping(value="/profilo/{id}")
    public ResponseEntity<Object> modificaProfilo(@PathVariable("id") String idAzienda,
                                                  @RequestBody Profilo profilo) {
        Azienda azienda = data.getAziendaById(idAzienda);
        if(azienda == null)
            return new ResponseEntity<>("Azienda non presente", HttpStatus.BAD_REQUEST);
        if(profilo == null)
            return new ResponseEntity<>("Profilo non presente", HttpStatus.BAD_REQUEST);
        try{
            azienda.modificaProfilo(profilo.getNomeProfilo(), profilo.getDescrizione());
            return new ResponseEntity<>(profilo, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value="dati-azienda/{id}")
    public ResponseEntity<Object> getAzienda(@PathVariable("id") String idAzienda){
        Azienda azienda = data.getAziendaById(idAzienda);
        AziendaDTO aziendaDTO  = new AziendaDTO(azienda);
        return new ResponseEntity<>(aziendaDTO, HttpStatus.OK);
    }
}