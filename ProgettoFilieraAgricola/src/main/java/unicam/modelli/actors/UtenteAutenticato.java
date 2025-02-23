package unicam.modelli.actors;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public abstract class UtenteAutenticato {
    private String email;
    private String nomeUtente;
    @Id
    private String id;

    public UtenteAutenticato(String email, String nomeUtente) {
        this.email = email;
        this.nomeUtente = nomeUtente;
    }

    public UtenteAutenticato() {}

    public String getNomeUtente() {
        return nomeUtente;
    }
}
