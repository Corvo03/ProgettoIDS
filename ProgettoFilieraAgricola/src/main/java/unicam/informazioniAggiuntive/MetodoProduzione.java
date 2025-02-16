package unicam.informazioniAggiuntive;

import java.util.Objects;

public class MetodoProduzione implements InformazioneAggiuntiva {
    private final String nome;
    private final String descrizione;

    public MetodoProduzione(String nome, String descrizione) {
        this.nome = nome;
        this.descrizione = descrizione;
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
