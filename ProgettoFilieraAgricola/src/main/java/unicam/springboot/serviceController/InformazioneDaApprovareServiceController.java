package unicam.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import unicam.modelli.actors.Curatore;
import unicam.modelli.actors.azienda.InformazioniSensibili;
import unicam.modelli.elements.Biglietto;
import unicam.modelli.elements.Item;
import unicam.modelli.elements.Pacchetto;
import unicam.modelli.elements.Prodotto;
import unicam.modelli.gestori.GestoreInformazioni;
import unicam.modelli.marketplace.InformazioneDaApprovare;
import unicam.springboot.dto.InformazioneDaApprovareDTO;

import java.util.ArrayList;
import java.util.List;


@RestController
public class InformazioneDaApprovareServiceController {
    private final Curatore curatore = new Curatore("nome", "mail");
    private final GestoreInformazioni gi = GestoreInformazioni.getInstance();

    @GetMapping("/infoDaApprovare")
    public ResponseEntity<Object> getInformazioneDaApprovare() {
        List<InformazioneDaApprovareDTO> dtoList = convertitoreInfoToDTO(gi.getInformazioniDaApprovare());
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    private List<InformazioneDaApprovareDTO> convertitoreInfoToDTO(List<InformazioneDaApprovare> informazioniDaApprovare) {
        List<InformazioneDaApprovareDTO> dtoList = new ArrayList<>();
        for (InformazioneDaApprovare info : informazioniDaApprovare) {
            InformazioneDaApprovareDTO dto = new InformazioneDaApprovareDTO();
            if (info instanceof Prodotto prodotto) {
                dto.setNomeItem(prodotto.getNomeItem());
                dto.setPrezzo(prodotto.getPrezzo());
                dto.setDescrizione(prodotto.getDescrizione());
                dto.setNomeAziendaProduttrice(prodotto.getAziendaProduttrice().getId());
                dto.setIdItem(prodotto.getId());
            }
            dtoList.add(dto);
        }
        return dtoList;
    }

    @PostMapping("/infoDaApprovare/approvaInfo")
    public ResponseEntity<Object> approvaInformazione(@RequestBody InformazioneDaApprovareDTO informazioneDaApprovare) {
        if (informazioneDaApprovare == null) {
            return new ResponseEntity<>("Informazione non trovata", HttpStatus.BAD_REQUEST);
        }
        InformazioneDaApprovare info = convertDTOToInformazione(informazioneDaApprovare);
        if (!gi.getInformazioniDaApprovare().contains(info)) {
            return new ResponseEntity<>("Informazione non trovata", HttpStatus.BAD_REQUEST);
        }
        curatore.approvaInformazione(info);

        return new ResponseEntity<>("Informazione approvata", HttpStatus.OK);
    }

    @PostMapping("/infoDaApprovare/rifiutaInfo")
    public ResponseEntity<Object> rifiutaInformazione(@RequestBody InformazioneDaApprovareDTO informazioneDaApprovare) {
        if (informazioneDaApprovare == null) {
            return new ResponseEntity<>("Informazione non trovata", HttpStatus.BAD_REQUEST);
        }
        InformazioneDaApprovare info = convertDTOToInformazione(informazioneDaApprovare);
        if (!gi.getInformazioniDaApprovare().contains(info)) {
            return new ResponseEntity<>("Informazione non trovata", HttpStatus.BAD_REQUEST);
        }
        curatore.rifiutaInformazione(info);
        return new ResponseEntity<>("Informazione rifiutata", HttpStatus.OK);
    }

    private InformazioneDaApprovare convertDTOToInformazione(InformazioneDaApprovareDTO dto) {
        for (InformazioneDaApprovare info : gi.getInformazioniDaApprovare()) {
            switch (info) {
                case Prodotto prodotto -> {
                    if (controlloProdotto(prodotto, dto)) {
                        return prodotto;
                    }
                }
                case Pacchetto pacchetto -> {
                    if (controlloPacchetto(pacchetto, dto)) {
                        return pacchetto;
                    }
                }
                case Biglietto biglietto -> {
                    if (controlloBiglietto(biglietto, dto)) {
                        return biglietto;
                    }
                }
                default -> {
                }
            }

        }
        return null;
    }

    private boolean controlloProdotto(Prodotto prodotto, InformazioneDaApprovareDTO dto) {
        return prodotto.getNomeItem().equals(dto.getNomeItem()) &&
                prodotto.getPrezzo() == dto.getPrezzo() &&
                prodotto.getDescrizione().equals(dto.getDescrizione()) &&
                prodotto.getAziendaProduttrice().getId().equals(dto.getNomeAziendaProduttrice()) &&
                prodotto.getId().equals(dto.getIdItem());
    }

    private boolean controlloPacchetto(Pacchetto pacchetto, InformazioneDaApprovareDTO dto) {
        return pacchetto.getNomeItem().equals(dto.getNomeItem()) &&
                pacchetto.getPrezzo() == dto.getPrezzo() &&
                pacchetto.getDescrizione().equals(dto.getDescrizione()) &&
                pacchetto.getAziendaProduttrice().getId().equals(dto.getNomeAziendaProduttrice()) &&
                pacchetto.getId().equals(dto.getIdItem());
    }

    private boolean controlloBiglietto(Biglietto biglietto, InformazioneDaApprovareDTO dto) {
        return biglietto.getNomeItem().equals(dto.getNomeItem()) &&
                biglietto.getPrezzo() == dto.getPrezzo() &&
                biglietto.getDescrizione().equals(dto.getDescrizione()) &&
                biglietto.getAnimatore().getId().equals(dto.getNomeAziendaProduttrice()) &&
                biglietto.getId().equals(dto.getIdItem());
    }
}
