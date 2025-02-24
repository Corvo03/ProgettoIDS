package unicam.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import unicam.modelli.elements.Biglietto;
import unicam.modelli.elements.ElementoMarketplace;
import unicam.modelli.elements.Pacchetto;
import unicam.modelli.elements.Prodotto;
import unicam.modelli.gestori.GestoreSistema;
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

    @GetMapping("/marketplace/prodotti")
    public ResponseEntity<Object> getProdottiMarketPlace() {
        List<ElementoMarketplace> listElementi =  gs.getElementiDisponibiliMarketplace();
        List<ProdottoDTO> prodottiDTO = new ArrayList<>();
        for(ElementoMarketplace elemento: listElementi) {
            if(elemento.getItem() instanceof Prodotto prodotto)
                prodottiDTO.add(new ProdottoDTO(prodotto));
        }
        return new ResponseEntity<>(prodottiDTO, HttpStatus.OK);
    }

    @GetMapping("/marketplace/biglietti")
    public ResponseEntity<Object> getBigliettiMarketPlace() {
        List<ElementoMarketplace> listElementi =  gs.getElementiDisponibiliMarketplace();
        List<BigliettoDTO> bigliettiDTO = new ArrayList<>();
        for(ElementoMarketplace elemento: listElementi) {
            if(elemento.getItem() instanceof Biglietto biglietto)
                bigliettiDTO.add(new BigliettoDTO(biglietto));
        }
        return new ResponseEntity<>(bigliettiDTO, HttpStatus.OK);
    }

    @GetMapping("/marketplace/pacchetti")
    public ResponseEntity<Object> getPacchettiMarketPlace() {
        List<ElementoMarketplace> listElementi =  gs.getElementiDisponibiliMarketplace();
        List<PacchettoDTO> pacchettoDTO = new ArrayList<>();
        for(ElementoMarketplace elemento: listElementi) {
            if(elemento.getItem() instanceof Pacchetto pacchetto)
                pacchettoDTO.add(new PacchettoDTO(pacchetto));
        }
        return new ResponseEntity<>(pacchettoDTO, HttpStatus.OK);
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
