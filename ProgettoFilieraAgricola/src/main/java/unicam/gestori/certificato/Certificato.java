package unicam.gestori.certificato;

public class Certificato {
    private String nome;
    private String descrizione;

    public Certificato(String nome, String descrizione) {
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
