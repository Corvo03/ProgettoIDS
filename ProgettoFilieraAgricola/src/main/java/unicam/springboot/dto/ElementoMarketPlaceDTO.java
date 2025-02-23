package unicam.springboot.dto;

import unicam.modelli.elements.Biglietto;
import unicam.modelli.elements.ElementoMarketplace;
import unicam.modelli.elements.Pacchetto;
import unicam.modelli.elements.Prodotto;
import unicam.modelli.gestori.GestoreSistema;

public class ElementoMarketPlaceDTO {
    private String nomeProdotto;
    private String azienda;
    private Integer quantita;
    private Double prezzo;
    private String idProdotto;
    private String idAzienda;

    public ElementoMarketPlaceDTO(ElementoMarketplace e) {
        switch (e.getStock().getItem()){
            case Prodotto prodotto -> {
                this.nomeProdotto = prodotto.getNomeItem();
                this.azienda = prodotto.getAzienda().getNome();
                this.quantita = e.getQuantitaDisponibile();
                this.prezzo = e.getStock().getItem().getPrezzo();
                this.idProdotto = e.getId();
                this.idAzienda = prodotto.getAzienda().getId();
            }
            case Pacchetto pacchetto -> {
                this.nomeProdotto = pacchetto.getNomeItem();
                this.azienda = pacchetto.getAziendaProduttrice().getNome();
                this.quantita = e.getQuantitaDisponibile();
                this.prezzo = e.getStock().getItem().getPrezzo();
                this.idProdotto = e.getId();
                this.idAzienda = pacchetto.getAziendaProduttrice().getId();
            }
            case Biglietto biglietto -> {
                this.nomeProdotto = biglietto.getNomeItem();
                this.azienda = biglietto.getAnimatore().getNomeUtente();
                this.quantita = e.getQuantitaDisponibile();
                this.prezzo = e.getStock().getItem().getPrezzo();
                this.idProdotto = e.getId();
                this.idAzienda = biglietto.getAnimatore().getId();
            }
            default -> throw new IllegalStateException("Unexpected value: " + e.getStock().getItem());
        }
    }
    public String getNomeProdotto() {
        return nomeProdotto;
    }

    public String getAzienda() {
        return azienda;
    }

    public Integer getQuantita() {
        return quantita;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public String getIdProdotto() {
        return idProdotto;
    }

    public String getIdAzienda() {
        return idAzienda;
    }

    public void setNomeProdotto(String nomeProdotto) {
        this.nomeProdotto = nomeProdotto;
    }

    public void setAzienda(String azienda) {
        this.azienda = azienda;
    }

    public void setQuantita(Integer quantita) {
        this.quantita = quantita;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    public void setIdProdotto(String idProdotto) {
        this.idProdotto = idProdotto;
    }

    public void setIdAzienda(String idAzienda) {
        this.idAzienda = idAzienda;
    }
}
