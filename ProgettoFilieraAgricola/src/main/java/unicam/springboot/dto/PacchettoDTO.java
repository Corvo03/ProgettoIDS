package unicam.springboot.dto;

import unicam.modelli.elements.Item;
import unicam.modelli.elements.Pacchetto;
import unicam.modelli.elements.Prodotto;
import unicam.modelli.marketplace.InformazioneDaApprovare;

import java.util.ArrayList;
import java.util.List;

public class PacchettoDTO extends Item implements InformazioneDaApprovare {
    private String nomeAziendaProduttrice;
    private String idAzienda;
    private List<ProdottoDTO> listaProdotti;

    public PacchettoDTO(Pacchetto pacchetto) {
        super(pacchetto.getId(), pacchetto.getPrezzo(), pacchetto.getNomeItem(), pacchetto.getDescrizione());
        this.listaProdotti = new ArrayList<>();
        this.caricaProdotti(pacchetto);
        this.nomeAziendaProduttrice = pacchetto.getAziendaProduttrice().getNome();
        this.idAzienda = pacchetto.getAziendaProduttrice().getId();
    }

    public PacchettoDTO(){
        this.listaProdotti = new ArrayList<>();
    }

    private void caricaProdotti(Pacchetto pacchetto) {
        for(Prodotto prodotto : pacchetto.getListaProdotti()){
            listaProdotti.add(new ProdottoDTO(prodotto));
        }
    }

    public String getIdAzienda() {
        return idAzienda;
    }

    public String getNomeAziendaProduttrice() {
        return nomeAziendaProduttrice;
    }

    public List<ProdottoDTO> getListaProdotti() {
        return listaProdotti;
    }
}
