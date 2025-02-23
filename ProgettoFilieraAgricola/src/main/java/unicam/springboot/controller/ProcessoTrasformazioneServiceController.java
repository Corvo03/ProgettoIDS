package unicam.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.modelli.actors.Curatore;
import unicam.modelli.actors.Trasformatore;
import unicam.modelli.gestori.GestoreSistema;
import unicam.modelli.informazioniAggiuntive.Fase;
import unicam.modelli.informazioniAggiuntive.ProcessoTrasformazione;

import java.util.List;

@RestController
public class ProcessoTrasformazioneServiceController {
    private final Curatore curatore = new Curatore();
    private final GestoreSistema gS = GestoreSistema.getInstance();
    private final Trasformatore trasformatore = new Trasformatore();

    @GetMapping("/processoTrasformazione/nome")
    public ResponseEntity<ProcessoTrasformazione> getProcessoTrasformazione(@RequestParam String nome) {
        return ResponseEntity.ok(trasformatore.getProcessoTrasformazione(nome));

    }

    @PostMapping("/processoTrasformazione/aggiungiStep")
    public ResponseEntity<Object> aggiungiStepAlProcesso(Fase fase, String nomeProcesso) {
        trasformatore.aggiungiStepAlProcesso(fase, nomeProcesso);
        return new ResponseEntity<>("Step aggiunto", HttpStatus.OK);
    }

    @PostMapping("/processoTrasformazione/creaProcesso")
    public ResponseEntity<Object> creaProcesso(String nome, String descrizione) {
        trasformatore.creaProcesso(nome, descrizione);
        return new ResponseEntity<>("Processo creato", HttpStatus.OK);
    }

    @GetMapping("/processoTrasformazione/listaProcessi")
    public ResponseEntity<List<ProcessoTrasformazione>> getProcessi() {
        return new ResponseEntity<>(trasformatore.getListaProcessiTrasformazione(), HttpStatus.OK);
    }

    @DeleteMapping("/processoTrasformazione")
    public ResponseEntity<Object> eliminaMetodoTrasformazione(@RequestParam String nomeProcesso) {
        //trasformatore.getGestoreProcessoTrasformazione().eliminaMetodoTrasformazione(nomeProcesso);
        return new ResponseEntity<>("Metodo rimosso", HttpStatus.OK);
    }

    @PostMapping("/processoTrasformazione/setListaMetodiTrasformazione")
    public ResponseEntity<Object> setListaProcessiTrasformazione(List<ProcessoTrasformazione> listaProcessiTrasformazione) {
        trasformatore.getGestoreProcessoTrasformazione().setListaProcessiTrasformazione(listaProcessiTrasformazione);
        return new ResponseEntity<>("Lista metodi impostata", HttpStatus.OK);
    }

}