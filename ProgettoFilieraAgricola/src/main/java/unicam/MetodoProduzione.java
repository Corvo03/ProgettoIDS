package unicam;

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

    @Override public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MetodoProduzione mp))
            return false;
        return Objects.equals(mp.getNome(), this.getNome()) &&
                Objects.equals(mp.getDescrizione(), this.getDescrizione());
    }
}
