package unicam.springboot.dto;

import unicam.modelli.elements.Item;
import unicam.modelli.elements.Prodotto;
import unicam.modelli.marketplace.InformazioneDaApprovare;


public class ProdottoDTO extends Item implements InformazioneDaApprovare {
    private String nomeAziendaProduttrice;
    private String idAzienda;

    public ProdottoDTO(double prezzo, String nomeItem, String descrizione, String idItem, String nomeAziendaProduttrice, String idAzienda) {
        super(idItem, prezzo, nomeItem, descrizione);
        this.nomeAziendaProduttrice = nomeAziendaProduttrice;
        this.idAzienda = idAzienda;
    }

    public ProdottoDTO(Prodotto prodotto) {
        super( prodotto.getId(),prodotto.getPrezzo(), prodotto.getNomeItem(), prodotto.getDescrizione());
        this.nomeAziendaProduttrice = prodotto.getAziendaProduttrice().getNome();
        this.idAzienda = prodotto.getAziendaProduttrice().getId();
    }

    public String getNomeAziendaProduttrice() {
        return nomeAziendaProduttrice;
    }

    public String getIdAzienda() {
        return idAzienda;
    }
}
