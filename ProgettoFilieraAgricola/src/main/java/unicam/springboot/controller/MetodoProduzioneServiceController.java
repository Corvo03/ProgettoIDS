package unicam.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.modelli.actors.Produttore;
import unicam.modelli.informazioniAggiuntive.MetodoProduzione;
import unicam.repository.Data;
import unicam.springboot.dto.MetodoProduzioneAggiungiMetodoDTO;

@RestController
public class MetodoProduzioneServiceController {
    Data data = Data.getIstance();

    @GetMapping ("/metodoProduzione")
    public ResponseEntity<Object> getMetodoProduzione(@RequestParam String idProduttore,@RequestParam String nome) {
        if(data.getAziendaById(idProduttore) instanceof Produttore produttore){
            return ResponseEntity.ok(produttore.getMetodoProduzione(nome));
        }else {
            return ResponseEntity.badRequest().body("Errore");
        }
    }

    @PostMapping("/metodoProduzione/aggiungiMetodoProduzione")
    public ResponseEntity<Object> creaMetodoProduzione(@RequestParam String idProduttore, @RequestParam String nomeMetodoProduzione,@RequestParam String nomeStep) {

        if(data.getAziendaById(idProduttore) instanceof Produttore produttore){
            produttore.getGestoreMetodoProduzione().aggiungiMetodoProduzione(nomeMetodoProduzione, nomeStep);
            if(produttore.getMetodoProduzione(nomeMetodoProduzione)!=null) {
                return ResponseEntity.ok("Metodo creato");
            }
        }
        return ResponseEntity.badRequest().body("Errore");
    }

    @PostMapping("/metodoProduzione/eliminaMetodoProduzione")
    public ResponseEntity<Object> eliminaMetodoProduzione(@RequestParam String idProduttore,@RequestParam String nomeMetodoProduzione) {
        if (data.getAziendaById(idProduttore) instanceof Produttore produttore) {
            produttore.getGestoreMetodoProduzione().eliminaMetodoProduzione(nomeMetodoProduzione);
            return ResponseEntity.ok("Metodo eliminato");
        } else {
            return ResponseEntity.badRequest().body("Errore");
        }
    }


    @PostMapping("/metodoProduzione/aggiungiMetodoProduzione/metodoProduzione")
    public ResponseEntity<Object> aggiungiMetodoProduzione(@RequestBody MetodoProduzioneAggiungiMetodoDTO metodoProduzioneAggiungiMetodoDTO) {
        if(data.getAziendaById(metodoProduzioneAggiungiMetodoDTO.getId()) instanceof Produttore produttore){
            produttore.getGestoreMetodoProduzione().aggiungiMetodoProduzione(metodoProduzioneAggiungiMetodoDTO.getMetodoProduzione());
        }
        return ResponseEntity.ok("Step aggiunto");
    }

}
