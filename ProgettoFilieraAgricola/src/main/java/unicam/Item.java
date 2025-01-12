package unicam;

public abstract class Item extends InformazioniDaApprovare {
    private float prezzo;
    private String nomeItem;
    private String descrizione;
    public Item(float prezzo, String nomeItem, String descrizione) {
        this.prezzo = prezzo;
        this.nomeItem = nomeItem;
        this.descrizione = descrizione;
    }

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

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        if (prezzo < 0)
            throw new IllegalArgumentException("prezzo non valido");
        this.prezzo = prezzo;
    }
}