package unicam.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.modelli.actors.DistributoreTipicita;
import unicam.modelli.elements.ElementoMarketplace;
import unicam.modelli.elements.Item;
import unicam.modelli.elements.Pacchetto;
import unicam.modelli.elements.Prodotto;
import unicam.modelli.gestori.GestoreSistema;
import unicam.repository.Data;
import unicam.springboot.dto.AddPacchettoDTO;
import unicam.springboot.dto.PacchettoDTO;
import unicam.springboot.dto.ProdottoDTO;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PacchettoServiceController {
 Data data = Data.getIstance();
    GestoreSistema gs = GestoreSistema.getInstance();

    @PostMapping("/pacchetto/{id}")
    public ResponseEntity<Object> addPacchetto(@PathVariable("id") String idAzienda,
                                               @RequestBody AddPacchettoDTO pacchettoDTO) {

        if (data.getAziendaById(idAzienda) instanceof DistributoreTipicita distrTipicita) {
            List<Prodotto> listaProdotto = new ArrayList<>();

            for (String id : pacchettoDTO.getListaProdotti()) {
                if(gs.getElementoMarketplaceDaId(id).getItem() instanceof Prodotto prodotto) {
                    listaProdotto.add(prodotto);
                }
            }
            distrTipicita.creaPacchetto(
                    pacchettoDTO.getId(),
                    pacchettoDTO.getPrezzo(),
                    pacchettoDTO.getNomeItem(),
                    pacchettoDTO.getDescrizione(),
                    listaProdotto
            );
            return new ResponseEntity<>("Pacchetto creato", HttpStatus.CREATED);
        }
        else
            return new ResponseEntity<>("Pacchetto non creato", HttpStatus.BAD_REQUEST);
    }
}
