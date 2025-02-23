package unicam.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.modelli.actors.azienda.Azienda;
import unicam.modelli.actors.azienda.InformazioniSensibili;
import unicam.repository.Data;
import unicam.springboot.dto.AziendaDTO;
import unicam.springboot.dto.ProfiloDTO;

import java.util.List;

@RestController
public class DatiAziendaServiceController {
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

    @GetMapping(value="dati-azienda/{id}")
    public ResponseEntity<Object> getAzienda(@PathVariable("id") String idAzienda){
        Azienda azienda = data.getAziendaById(idAzienda);
        AziendaDTO aziendaDTO  = new AziendaDTO(azienda);
        return new ResponseEntity<>(aziendaDTO, HttpStatus.OK);
    }

    @PutMapping(value="/dati-azienda/sedi-produttive/{id}")
    public ResponseEntity<Object> modificaSediProduttive(@PathVariable("id") String idAzienda,
                                                        @RequestBody List<String> sedi) {
        Azienda azienda = data.getAziendaById(idAzienda);
        if(azienda == null)
            return new ResponseEntity<>("Azienda non presente", HttpStatus.BAD_REQUEST);
        azienda.setIndirizzoSediProduttive(sedi);
        return new ResponseEntity<>(sedi, HttpStatus.OK);
    }
}