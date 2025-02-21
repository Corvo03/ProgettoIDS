package unicam.modelli.elements;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Certificato {
    @Id
    private String Id;
    private String nome;
    private String descrizione;

    public Certificato(String nome, String descrizione) {
        this.nome = nome;
        this.descrizione = descrizione;
    }

    public Certificato() {
    }

    public String getNome() {
        return nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getId() {
        return Id;
    }
}
