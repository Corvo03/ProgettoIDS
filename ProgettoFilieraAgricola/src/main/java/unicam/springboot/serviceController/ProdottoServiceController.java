package unicam.springboot.serviceController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.modelli.actors.azienda.Azienda;
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

    @GetMapping("/prodotto")
    public ResponseEntity<Prodotto> getProdotto(@RequestParam String id) {
        if(data.getProdottoById(id) == null) return ResponseEntity.ok(new Prodotto(1.00,"aaa","dddeee",data.getAziendaById("1"),null,"peffoh"));
        return ResponseEntity.ok(data.getProdottoById(id));
    }

    @PostMapping("/prodotto")
    public ResponseEntity<Object> addProdotto(@RequestBody AddProdottoDTO addProdottoDTO) {
        if(addProdottoDTO.getIdAzienda() == null){
            return ResponseEntity.badRequest().body("Azienda non trovata");
        }
        Azienda azienda = data.getAziendaById(addProdottoDTO.getIdAzienda());
        if(azienda != null){
            switch (azienda) {
                case Produttore produttore -> {
                    produttore.creaProdotto(addProdottoDTO.getPrezzo(), addProdottoDTO.getNome(), addProdottoDTO.getDescrizione(), (MetodoProduzione) addProdottoDTO.getInformazioneAggiuntiva(),addProdottoDTO.getId());
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

}
