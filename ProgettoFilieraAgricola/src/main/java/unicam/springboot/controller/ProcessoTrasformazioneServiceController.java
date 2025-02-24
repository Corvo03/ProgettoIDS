package unicam.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.modelli.actors.Curatore;
import unicam.modelli.actors.Trasformatore;
import unicam.modelli.gestori.GestoreSistema;
import unicam.modelli.informazioniAggiuntive.Fase;
import unicam.modelli.informazioniAggiuntive.ProcessoTrasformazione;
import unicam.repository.Data;
import unicam.springboot.dto.ProcessoTrasformazioneAggiungiStepDTO;

import java.util.List;

@RestController
public class ProcessoTrasformazioneServiceController {
    Data data = Data.getIstance();

    @GetMapping("/processoTrasformazione/nome")
    public ResponseEntity<ProcessoTrasformazione> getProcessoTrasformazione(@RequestParam String id,@RequestParam String nome) {
        if(data.getAziendaById(id)==null)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        if(data.getAziendaById(id) instanceof Trasformatore trasformatore){
            return ResponseEntity.ok(trasformatore.getProcessoTrasformazione(nome));
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/processoTrasformazione/aggiungiStep")
    public ResponseEntity<Object> aggiungiStepAlProcesso(@RequestBody ProcessoTrasformazioneAggiungiStepDTO processoTrasformazioneAggiungiStepDTO) {
        Trasformatore trasformatore = (Trasformatore) data.getAziendaById(processoTrasformazioneAggiungiStepDTO.getId());
        trasformatore.aggiungiStepAlProcesso(processoTrasformazioneAggiungiStepDTO.getFase(), processoTrasformazioneAggiungiStepDTO.getNomeProcesso());
        return new ResponseEntity<>("Step aggiunto", HttpStatus.OK);
    }

    @PostMapping("/processoTrasformazione/creaProcesso")
    public ResponseEntity<Object> creaProcesso(@RequestParam String id,@RequestParam String nome, @RequestParam String descrizione) {
        Trasformatore trasformatore = (Trasformatore) data.getAziendaById(id);
        trasformatore.creaProcesso(nome, descrizione);
        return new ResponseEntity<>("Processo creato", HttpStatus.OK);
    }

    @GetMapping("/processoTrasformazione/listaProcessi")
    public ResponseEntity<List<ProcessoTrasformazione>> getProcessi(@RequestParam String id) {
        Trasformatore trasformatore = (Trasformatore) data.getAziendaById(id);
        return new ResponseEntity<>(trasformatore.getListaProcessiTrasformazione(), HttpStatus.OK);
    }

    @DeleteMapping("/processoTrasformazione")
    public ResponseEntity<Object> eliminaMetodoTrasformazione(@RequestParam String id, @RequestParam String nomeMetodoTrasformazione) {
        Trasformatore trasformatore = (Trasformatore) data.getAziendaById(id);
        trasformatore.getGestoreProcessoTrasformazione().eliminaMetodoTrasformazione(nomeMetodoTrasformazione);
        return new ResponseEntity<>("Metodo rimosso", HttpStatus.OK);
    }

    @PostMapping("/processoTrasformazione/setListaMetodiTrasformazione")
    public ResponseEntity<Object> setListaProcessiTrasformazione(@RequestBody List<ProcessoTrasformazione> listaProcessiTrasformazione) {
        Trasformatore trasformatore = (Trasformatore) data.getAziendaById("1");
        trasformatore.getGestoreProcessoTrasformazione().setListaProcessiTrasformazione(listaProcessiTrasformazione);
        return new ResponseEntity<>("Lista metodi impostata", HttpStatus.OK);
    }
}