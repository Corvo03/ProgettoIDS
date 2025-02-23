package unicam.springboot.dto;

import unicam.modelli.elements.ElementoMarketplace;
import unicam.modelli.marketplace.Carrello;

public class CarrelloDTO {
    private String nomeElemento;
    private int quantita;
    private double prezzo;
    private String idElemento;

    public CarrelloDTO(ElementoMarketplace elementoMarketplace, int quantita) {
        this.nomeElemento = elementoMarketplace.getStock().getItem().getNomeItem();
        this.quantita = quantita;
        this.prezzo = elementoMarketplace.getStock().getItem().getPrezzo();
        this.idElemento = elementoMarketplace.getId();
    }

    public String getNomeElemento() {
        return nomeElemento;
    }

    public void setNomeElemento(String nomeElemento) {
        this.nomeElemento = nomeElemento;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public String getIdElemento() {
        return idElemento;
    }

    public void setIdElemento(String idElemento) {
        this.idElemento = idElemento;
    }
}
