package unicam.springboot.dto;

public class BigliettoDTO {

    double prezzo;
    private String nomeItem;
    private String descrizione;
    private String idAnimatore;
    private String idEvento;

    public BigliettoDTO(double prezzo, String nomeItem, String descrizione, String idAnimatore, String idEvento) {

        this.prezzo = prezzo;
        this.nomeItem = nomeItem;
        this.descrizione = descrizione;
        this.idAnimatore = idAnimatore;
        this.idEvento = idEvento;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getIdAnimatore() {
        return idAnimatore;
    }

    public String getIdEvento() {
        return idEvento;
    }
}

