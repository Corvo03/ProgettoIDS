package unicam.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import unicam.modelli.actors.azienda.InformazioniSensibili;
import unicam.modelli.elements.Biglietto;
import unicam.modelli.elements.ElementoMarketplace;
import unicam.modelli.elements.Pacchetto;
import unicam.modelli.elements.Prodotto;
import unicam.modelli.gestori.GestoreSistema;
import unicam.modelli.marketplace.InformazioneDaApprovare;
import unicam.springboot.dto.BigliettoDTO;
import unicam.springboot.dto.ElementoMarketPlaceDTO;
import unicam.springboot.dto.PacchettoDTO;
import unicam.springboot.dto.ProdottoDTO;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MarketPlaceServiceController {
    GestoreSistema gs = GestoreSistema.getInstance();

    @GetMapping("/marketplace")
    public ResponseEntity<Object> getMarketPlace() {
        return new ResponseEntity<>(convertitoreElemetoToDTO(gs.getElementiDisponibiliMarketplace()), HttpStatus.OK);
    }

    private List<ElementoMarketPlaceDTO> convertitoreElemetoToDTO(List<ElementoMarketplace> elementiMarketplace) {
        List<ElementoMarketPlaceDTO> dtoList = new ArrayList<>();
        for (ElementoMarketplace e : elementiMarketplace) {
            ElementoMarketPlaceDTO dto = new ElementoMarketPlaceDTO(e);
            dtoList.add(dto);
        }
        return dtoList;
    }
}
