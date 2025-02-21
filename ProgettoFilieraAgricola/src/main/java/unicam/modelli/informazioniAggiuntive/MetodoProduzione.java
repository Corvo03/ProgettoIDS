package unicam.modelli.informazioniAggiuntive;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;
@Entity
public class MetodoProduzione extends InformazioneAggiuntiva {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String nome;
    private String descrizione;

    public MetodoProduzione(String nome, String descrizione) {
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
