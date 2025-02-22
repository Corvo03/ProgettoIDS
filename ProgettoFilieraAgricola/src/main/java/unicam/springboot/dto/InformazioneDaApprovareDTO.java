package unicam.springboot.dto;

import unicam.modelli.marketplace.InformazioneDaApprovare;

public class InformazioneDaApprovareDTO {
    private double prezzo;
    private String nomeItem;
    private String descrizione;
    private String idItem;
    private String nomeAziendaProduttrice;

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getNomeAziendaProduttrice() {
        return nomeAziendaProduttrice;
    }

    public void setNomeAziendaProduttrice(String nomeAziendaProduttrice) {
        this.nomeAziendaProduttrice = nomeAziendaProduttrice;
    }

    public String getIdItem() {
        return idItem;
    }

    public void setIdItem(String idItem) {
        this.idItem = idItem;
    }
}