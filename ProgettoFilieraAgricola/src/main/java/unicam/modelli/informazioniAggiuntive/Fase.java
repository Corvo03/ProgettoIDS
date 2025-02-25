package unicam.modelli.informazioniAggiuntive;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * Classe che rappresenta una fase all'interno di un metodo di trasformazione
 */
@Entity
public class Fase {
    @Id
    private String id;
    private String descrizione;

    /**
     * Crea una fase con descrizione passata
     * @param descrizione
     */
    public Fase(String descrizione) {
        this.descrizione = descrizione;
    }

    public Fase(){}

    public String getDescrizione() {
        return descrizione;
    }
}
