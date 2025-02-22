package unicam.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import unicam.modelli.actors.Curatore;
import unicam.modelli.elements.Item;
import unicam.modelli.elements.Prodotto;
import unicam.modelli.gestori.GestoreInformazioni;
import unicam.modelli.marketplace.InformazioneDaApprovare;
import unicam.springboot.dto.InformazioneDaApprovareDTO;

import java.util.ArrayList;
import java.util.List;


@RestController
public class InformazioneDaApprovareServiceController {
    private final Curatore curatore = new Curatore("nome","mail");
    private final GestoreInformazioni gi = GestoreInformazioni.getInstance();

    @GetMapping("/infoDaApprovare")
    public ResponseEntity<Object> getInformazioneDaApprovare() {
        List<InformazioneDaApprovareDTO> dtoList = convertitoreDTO(gi.getInformazioniDaApprovare());
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    private List<InformazioneDaApprovareDTO> convertitoreDTO(List<InformazioneDaApprovare> informazioniDaApprovare) {
        List<InformazioneDaApprovareDTO> dtoList = new ArrayList<>();
        for (InformazioneDaApprovare info : informazioniDaApprovare) {
            InformazioneDaApprovareDTO dto = new InformazioneDaApprovareDTO();
            if (info instanceof Prodotto prodotto) {
                dto.setNomeItem(prodotto.getNomeItem());
                dto.setPrezzo(prodotto.getPrezzo());
                dto.setDescrizione(prodotto.getDescrizione());
                dto.setNomeAziendaProduttrice(prodotto.getAziendaProduttrice().getId());
            }
            dtoList.add(dto);
        }
        return dtoList;
    }

    @PostMapping("/infoDaApprovare/approvaInfo")
    public ResponseEntity<Object> approvaInformazione(@RequestBody InformazioneDaApprovare informazioneDaApprovare) {
        curatore.approvaInformazione(informazioneDaApprovare);
        return new ResponseEntity<>("Informazione approvata",HttpStatus.OK);
    }

    @PostMapping("/infoDaApprovare/rifiutaInfo")
    public ResponseEntity<Object> rifiutaInformazione(@RequestBody InformazioneDaApprovare informazioneDaApprovare) {
        curatore.rifiutaInformazione(informazioneDaApprovare);
        return new ResponseEntity<>("Informazione rifiutata", HttpStatus.OK);
    }

}
