package unicam.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.modelli.actors.azienda.Azienda;
import unicam.modelli.gestori.GestoreInformazioni;
import unicam.springboot.dto.AddProdottoDTO;
import unicam.modelli.actors.DistributoreTipicita;
import unicam.modelli.actors.Produttore;
import unicam.modelli.actors.Trasformatore;
import unicam.modelli.elements.Prodotto;
import unicam.modelli.informazioniAggiuntive.MetodoProduzione;
import unicam.modelli.informazioniAggiuntive.ProcessoTrasformazione;
import unicam.repository.Data;

@RestController
public class ProdottoServiceController {
    Data data = Data.getIstance();


    @PostMapping("/prodotto")
    public ResponseEntity<Object> addProdotto(@RequestBody AddProdottoDTO addProdottoDTO) {
        if(addProdottoDTO.getIdAzienda() == null){
            return ResponseEntity.badRequest().body("Azienda non trovata");
        }
        Azienda azienda = data.getAziendaById(addProdottoDTO.getIdAzienda());
        if(azienda != null){
            switch (azienda) {
                case Produttore produttore -> {
                    produttore.creaProdotto( addProdottoDTO.getIdProdotto(),addProdottoDTO.getPrezzo(), addProdottoDTO.getNome(), addProdottoDTO.getDescrizione(), (MetodoProduzione) addProdottoDTO.getInformazioneAggiuntiva());
                }
                case Trasformatore trasformatore -> {
                    trasformatore.creaProdotto(addProdottoDTO.getIdProdotto(), addProdottoDTO.getPrezzo(), addProdottoDTO.getNome(), addProdottoDTO.getDescrizione(), (ProcessoTrasformazione) addProdottoDTO.getInformazioneAggiuntiva());
                }
                case DistributoreTipicita distributoreTipicita -> {
                    distributoreTipicita.creaProdotto(addProdottoDTO.getIdProdotto(), addProdottoDTO.getPrezzo(), addProdottoDTO.getNome(), addProdottoDTO.getDescrizione());
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


    @GetMapping("/prodotto")
    public ResponseEntity<Object> getProdotto(@RequestParam String idProdotto) {
        if(GestoreInformazioni.getInstance().getInformazioneDaApprovareDaId(idProdotto) != null){

            return ResponseEntity.ok(GestoreInformazioni.getInstance().getInformazioneDaApprovareDaId(idProdotto));
        }else
            return ResponseEntity.badRequest().body("Prodotto non trovato");
    }
}
