package unicam.modelli.informazioniAggiuntive;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

/**
 * Rappresenta un metodo di produzione di un prodotto
 * creato da un produttore
 */
@Entity
public class MetodoProduzione extends InformazioneAggiuntiva {

    private String nome;
    private String descrizione;

    /**
     * Crea un metodo di produzione con i dati passati
     * @param id
     * @param nome
     * @param descrizione
     */
    public MetodoProduzione(String id,String nome, String descrizione) {
        super(id);
        this.nome = nome;
        this.descrizione = descrizione;
    }

    public MetodoProduzione() {
    }

    public String getNome() {
        return nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    /**
     * Confronta due metodi di produzione restituisce true se son uguali, false diversamente.
     * @param otherMetodo altro metodo da confrontare con questo.
     * @return true se i Metodi di produzione sono uguali, false altrimenti.
     */
    @Override public boolean equals(Object otherMetodo) {
        if (otherMetodo == this)
            return true;
        if (!(otherMetodo instanceof MetodoProduzione mp))
            return false;
        return Objects.equals(mp.getNome(), this.getNome()) &&
                Objects.equals(mp.getDescrizione(), this.getDescrizione());
    }
}
