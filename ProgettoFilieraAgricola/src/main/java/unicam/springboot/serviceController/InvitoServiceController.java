package unicam.springboot.controller;

import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
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
    public ResponseEntity<Object> visualizzaInviti(@PathVariable String id) {
        Azienda azienda = data.getAziendaById(id);
        if(azienda == null)
            return new ResponseEntity<>("Azienda non presente", HttpStatus.BAD_REQUEST);
        List<Invito> listInviti = azienda.getInviti();
        List<InvitoDTO> listInvitoDTO = new ArrayList<InvitoDTO>();

        for(Invito invito : listInviti) {
            InvitoDTO invitoDTO = new InvitoDTO(
                    invito.getAnimatoreFiliera(),
                    invito.getEvento(),
                    invito.getPartecipanteEvento(),
                    invito.getMessaggio()
            );
            listInvitoDTO.add(invitoDTO);
        }

        if(listInvitoDTO.isEmpty())
            return new ResponseEntity<>("Nessun invito presente", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(listInvitoDTO, HttpStatus.OK);

    }

    /* INVITI ANIMATORE */
}
