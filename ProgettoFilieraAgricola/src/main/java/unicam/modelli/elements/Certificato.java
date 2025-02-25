package unicam.modelli.elements;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
/**
 * Classe che rappresenta un certificato
 */
@Entity
public class Certificato {
    @Id
    private String Id;
    private String nome;
    private String descrizione;

    /**
     * Crea un certificato con parametri passati
     * @param id
     * @param nome
     * @param descrizione
     */
    public Certificato(String id,String nome, String descrizione) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.Id = id;
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
