package unicam;

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
}
