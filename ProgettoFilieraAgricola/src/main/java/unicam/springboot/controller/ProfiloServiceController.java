package unicam.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.modelli.actors.azienda.Azienda;
import unicam.modelli.actors.azienda.Profilo;
import unicam.modelli.gestori.GestoreSistema;
import unicam.repository.Data;
import unicam.springboot.dto.ProfiloDTO;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProfiloServiceController {

    Data data = Data.getIstance();
    GestoreSistema gs = GestoreSistema.getInstance();
    @GetMapping(value="/profili")
    public ResponseEntity<Object> getProfili() {
        gs.getListaProfili();
        List<ProfiloDTO> profiliDTO = new ArrayList<ProfiloDTO>();
        for(Profilo profilo : gs.getListaProfili())
            profiliDTO.add(new ProfiloDTO(profilo));

        return new ResponseEntity<>(profiliDTO, HttpStatus.OK);
    }

    @PutMapping(value="/profilo/{id}")
    public ResponseEntity<Object> getProfili(@PathVariable("id") String idAzienda,
                                             @RequestBody ProfiloDTO profiloDTO) {
        Azienda azienda = data.getAziendaById(idAzienda);
        if(azienda == null)
            return new ResponseEntity<>("Azienda non presente", HttpStatus.BAD_REQUEST);
        try{
            azienda.modificaProfilo(profiloDTO.getNome(), profiloDTO.getDescrizione());
            return new ResponseEntity<>("Profilo modificato", HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}