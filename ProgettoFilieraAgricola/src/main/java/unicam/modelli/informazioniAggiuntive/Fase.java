package unicam.modelli.informazioniAggiuntive;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Fase {
    @Id
    private String id;
    private String descrizione;

    public Fase(String descrizione) {
        this.descrizione = descrizione;
    }

    public Fase(){}

    public String getDescrizione() {
        return descrizione;
    }
}
