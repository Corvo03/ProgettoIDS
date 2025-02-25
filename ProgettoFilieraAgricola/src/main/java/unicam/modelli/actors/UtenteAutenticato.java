package unicam.modelli.actors;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * Classe astratta che rappresenta un utente autenticato
 * Un utente autenticato è un utente che ha effettuato la registrazione
 * come uno dei tipi di utenti previsti dal sistema
 */
@Entity
public abstract class UtenteAutenticato {
    @Id
    private String id;
    private String email;
    private String nomeUtente;

    /**
     * Costruttore di UtenteAutenticato
     * @param id
     * @param email
     * @param nomeUtente
     */
    public UtenteAutenticato(String id,String email, String nomeUtente) {
        this.id = id;
        this.email = email;
        this.nomeUtente = nomeUtente;
    }

    public UtenteAutenticato() {}

    public String getNomeUtente() {
        return nomeUtente;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }
}
