package unicam.modelli.elements;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import unicam.modelli.marketplace.InformazioneDaApprovare;
@Entity
public abstract class Item implements InformazioneDaApprovare {
    @Id
    private int id;
    private double prezzo;
    private String nomeItem;
    private String descrizione;
    public Item(double prezzo, String nomeItem, String descrizione) {
        this.prezzo = prezzo;
        this.nomeItem = nomeItem;
        this.descrizione = descrizione;
    }

    public Item() {}

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        if (prezzo < 0)
            throw new IllegalArgumentException("prezzo non valido");
        this.prezzo = prezzo;
    }
}