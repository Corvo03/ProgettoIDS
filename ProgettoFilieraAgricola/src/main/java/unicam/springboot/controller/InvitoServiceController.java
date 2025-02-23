package unicam.springboot.controller;

import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import unicam.modelli.actors.AnimatoreFiliera;
import unicam.modelli.actors.azienda.Azienda;
import unicam.modelli.inviti.Invito;
import unicam.repository.Data;
import unicam.springboot.dto.InvitoDTO;

import java.util.ArrayList;
import java.util.List;

@RestController
public class InvitoServiceController {

    /* INVITI AZIENDA */
    Data data = Data.getIstance();

    @GetMapping(value= "/inviti/ricevuti/{id}")
    public ResponseEntity<Object> visualizzaInvitiRicevuti(@PathVariable String id) {
        Azienda azienda = data.getAziendaById(id);
        if(azienda == null)
            return new ResponseEntity<>("Azienda non presente", HttpStatus.BAD_REQUEST);
        List<Invito> listInviti = azienda.getInviti();
        List<InvitoDTO> listInvitoDTO = new ArrayList<InvitoDTO>();

        for(Invito invito : listInviti) {
            InvitoDTO invitoDTO = new InvitoDTO(invito);
            listInvitoDTO.add(invitoDTO);
        }

        if(listInvitoDTO.isEmpty())
            return new ResponseEntity<>("Nessun invito presente", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(listInvitoDTO, HttpStatus.OK);
    }


    /* AZIENDA ACCETTA INVITO */
    @GetMapping(value= "/invito-ricevuto/accetta")
    public ResponseEntity<Object> accettaInvito(@PathParam("idAzienda") String idAzienda,
                                                @PathParam("idInvito") String idInvito ) {

        Invito invitoRicevuto = data.getInvitoById(idInvito, idAzienda);
        if(invitoRicevuto == null)
            return new ResponseEntity<>("Invito non presente", HttpStatus.BAD_REQUEST);
        Azienda azienda = data.getAziendaById(idAzienda);
        if(azienda == null)
            return new ResponseEntity<>("Azienda non presente", HttpStatus.BAD_REQUEST);
        azienda.accettaInvito(invitoRicevuto);
        return new ResponseEntity<>(new InvitoDTO(invitoRicevuto), HttpStatus.OK);
    }

    /* AZIENDA RIFIUTA INVITO */
    @GetMapping(value= "/invito-ricevuto/rifiuta")
    public ResponseEntity<Object> rifiuta(@PathParam("idAzienda") String idAzienda,
                                                @PathParam("idInvito") String idInvito ) {
        Invito invitoRicevuto = data.getInvitoById(idInvito, idAzienda);
        if(invitoRicevuto == null)
            return new ResponseEntity<>("Invito non presente", HttpStatus.BAD_REQUEST);
        Azienda azienda = data.getAziendaById(idAzienda);
        if(azienda == null)
            return new ResponseEntity<>("Azienda non presente", HttpStatus.BAD_REQUEST);
        azienda.rifiutaInvito(invitoRicevuto);
        return new ResponseEntity<>(new InvitoDTO(invitoRicevuto), HttpStatus.OK);
    }

    /* INVITI ANIMATORE */
    @GetMapping(value= "/inviti/invitati/{id}")
    public ResponseEntity<Object> visualizzaInvitiInviati(@PathVariable String id) {
        AnimatoreFiliera animatore = data.getAnimatoreById(id);
        if(animatore == null)
            return new ResponseEntity<>("Animatore non presente", HttpStatus.BAD_REQUEST);
        List<Invito> listInviti = animatore.getInviti();
        List<InvitoDTO> listInvitoDTO = new ArrayList<InvitoDTO>();

        for(Invito invito : listInviti) {
            InvitoDTO invitoDTO = new InvitoDTO(invito);
            listInvitoDTO.add(invitoDTO);
        }

        if(listInvitoDTO.isEmpty())
            return new ResponseEntity<>("Nessun invito presente", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(listInvitoDTO, HttpStatus.OK);
    }
}