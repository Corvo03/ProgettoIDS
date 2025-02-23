package unicam.springboot.dto;

import unicam.modelli.elements.Biglietto;
import unicam.modelli.elements.Item;
import unicam.modelli.marketplace.InformazioneDaApprovare;


public class BigliettoDTO extends Item implements InformazioneDaApprovare {

    private String idAnimatore;
    private String idEvento;

    public BigliettoDTO(String id, double prezzo, String nomeItem, String descrizione, String idAnimatore, String idEvento) {
        super(id, prezzo, nomeItem, descrizione);
        this.idAnimatore = idAnimatore;
        this.idEvento = idEvento;
    }

    public BigliettoDTO(Biglietto biglietto) {
        super(biglietto.getId(), biglietto.getPrezzo(), biglietto.getNomeItem(), biglietto.getDescrizione());
        this.idAnimatore = biglietto.getAnimatore().getId();
        this.idEvento = biglietto.getEvento().getId();
    }

    public String getIdAnimatore() {
        return idAnimatore;
    }

    public String getIdEvento() {
        return idEvento;
    }
}

