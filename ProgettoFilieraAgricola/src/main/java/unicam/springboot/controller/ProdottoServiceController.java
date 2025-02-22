package unicam.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.DTO.AddProdottoDTO;
import unicam.modelli.actors.DistributoreTipicita;
import unicam.modelli.actors.Produttore;
import unicam.modelli.actors.Trasformatore;
import unicam.modelli.actors.azienda.Azienda;
import unicam.modelli.elements.Prodotto;
import unicam.modelli.informazioniAggiuntive.InformazioneAggiuntiva;
import unicam.modelli.informazioniAggiuntive.MetodoProduzione;
import unicam.modelli.informazioniAggiuntive.ProcessoTrasformazione;
import unicam.repository.Data;

@RestController
public class ProdottoServiceController {
    Data data = Data.getIstance();

    @GetMapping("/prodotto")
    public ResponseEntity<Prodotto> getProdotto(@RequestParam String id) {
        return ResponseEntity.ok(data.getProdottoById(id));
    }

    @PostMapping("/prodotto")
    public ResponseEntity<Object> addProdotto(@RequestBody AddProdottoDTO addProdottoDTO) {
        if(addProdottoDTO.getAzienda() == null){
            return ResponseEntity.badRequest().body("Azienda non trovata");
        }
        if(data.aziende.contains(addProdottoDTO.getAzienda())){
            switch (addProdottoDTO.getAzienda()) {
                case Produttore produttore -> {
                    produttore.creaProdotto(addProdottoDTO.getPrezzo(), addProdottoDTO.getNome(), addProdottoDTO.getDescrizione(), (MetodoProduzione) addProdottoDTO.getInformazioneAggiuntiva());
                }
                case Trasformatore trasformatore -> {
                    trasformatore.creaProdotto(addProdottoDTO.getPrezzo(), addProdottoDTO.getNome(), addProdottoDTO.getDescrizione(), (ProcessoTrasformazione) addProdottoDTO.getInformazioneAggiuntiva());
                }
                case DistributoreTipicita distributoreTipicita -> {
                    distributoreTipicita.creaProdotto(addProdottoDTO.getPrezzo(), addProdottoDTO.getNome(), addProdottoDTO.getDescrizione());
                }
                default -> {
                    return ResponseEntity.badRequest().body("Tipo di azienda non esistente");
                }
            }
        }else {
            return ResponseEntity.badRequest().body("Azienda non trovata");
        }
        return ResponseEntity.ok("Prodotto aggiunto");
    }
    /*
    @PostMapping("/prodotto/aggiungiInformazioneAggiuntiva")
    public ResponseEntity<Object> addInformazioneAggiuntiva(@RequestBody Prodotto prodotto, @RequestBody InformazioneAggiuntiva informazioneAggiuntiva) {
        if(prodotto == null){
            return ResponseEntity.badRequest().body("Prodotto non trovato");
        }
        prodotto.setInformazioneAggiuntiva(informazioneAggiuntiva);
        return ResponseEntity.ok("Informazione aggiuntiva aggiunta");
    }
    */

}
