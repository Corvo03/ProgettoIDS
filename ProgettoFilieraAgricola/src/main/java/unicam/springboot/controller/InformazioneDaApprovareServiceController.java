package unicam.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.modelli.actors.Curatore;
import unicam.modelli.actors.azienda.InformazioniSensibili;
import unicam.modelli.elements.Biglietto;
import unicam.modelli.elements.Pacchetto;
import unicam.modelli.elements.Prodotto;
import unicam.modelli.gestori.GestoreInformazioni;
import unicam.modelli.marketplace.InformazioneDaApprovare;
import unicam.repository.Data;
import unicam.springboot.dto.BigliettoDTO;
import unicam.springboot.dto.PacchettoDTO;
import unicam.springboot.dto.ProdottoDTO;

import java.util.ArrayList;
import java.util.List;


@RestController
public class InformazioneDaApprovareServiceController {
    private final GestoreInformazioni gi = GestoreInformazioni.getInstance();

    @GetMapping("/infoDaApprovare")
    public ResponseEntity<Object> getInformazioneDaApprovare() {
        List<InformazioneDaApprovare> dtoList = convertitoreInfoToDTO(gi.getInformazioniDaApprovare());
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    private List<InformazioneDaApprovare> convertitoreInfoToDTO(List<InformazioneDaApprovare> informazioniDaApprovare) {
        List<InformazioneDaApprovare> dtoList = new ArrayList<>();
        for (InformazioneDaApprovare info : informazioniDaApprovare) {
            InformazioneDaApprovare dto;
            switch (info) {
                case Prodotto prodotto -> dto = new ProdottoDTO(prodotto);
                case Biglietto biglietto -> dto = new BigliettoDTO(biglietto);
                case Pacchetto pacchetto -> dto = new PacchettoDTO(pacchetto);
                case InformazioniSensibili informazioniSensibili -> dto = informazioniSensibili;
                default -> throw new IllegalStateException("Unexpected value: " + info);
            }
            dtoList.add(dto);
        }
        return dtoList;
    }

    @PostMapping("/infoDaApprovare/approvaInfo/{idCuratore}/{idInfo}")
    public ResponseEntity<Object> approvaInformazione(@PathVariable String idCuratore ,@PathVariable String idInfo) {
        if (idInfo == null) {
            return new ResponseEntity<>("IdInfo non iserita correattamente", HttpStatus.BAD_REQUEST);
        }
        if (idCuratore == null) {
            return new ResponseEntity<>("IdCuratore non iserito correattamente", HttpStatus.BAD_REQUEST);
        }
        Curatore curatore = Data.getIstance().getCuratoreById(idCuratore);
        if (curatore == null) {
            return new ResponseEntity<>("Curatore non trovato", HttpStatus.BAD_REQUEST);
        }
        InformazioneDaApprovare infoDaApprovare = gi.getInformazioneDaApprovareDaId(idInfo);
        if (infoDaApprovare == null) {
            return new ResponseEntity<>("Informazione non trovata", HttpStatus.BAD_REQUEST);
        }
        curatore.approvaInformazione(infoDaApprovare);
        return new ResponseEntity<>("Informazione approvata", HttpStatus.OK);
    }

    @PostMapping("/infoDaApprovare/rifiutaInfo/{idCuratore}/{idInfo}")
    public ResponseEntity<Object> rifiutaInformazione(@PathVariable String idCuratore ,@PathVariable String idInfo) {
        if (idInfo == null) {
            return new ResponseEntity<>("Id non iserito correattamente", HttpStatus.BAD_REQUEST);
        }
        if (idCuratore == null) {
            return new ResponseEntity<>("Id non iserito correattamente", HttpStatus.BAD_REQUEST);
        }
        Curatore curatore = Data.getIstance().getCuratoreById(idCuratore);
        if (curatore == null) {
            return new ResponseEntity<>("Curatore non trovato", HttpStatus.BAD_REQUEST);
        }
        InformazioneDaApprovare infoDaApprovare = gi.getInformazioneDaApprovareDaId(idInfo);
        if (infoDaApprovare == null) {
            return new ResponseEntity<>("Informazione non trovata", HttpStatus.BAD_REQUEST);
        }
        curatore.rifiutaInformazione(infoDaApprovare);
        return new ResponseEntity<>("Informazione rifiutata", HttpStatus.OK);
    }
}