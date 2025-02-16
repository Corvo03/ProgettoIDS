package unicam.actors;

public abstract class UtenteAutenticato {
    private String email;
    private String nomeUtente;

    public UtenteAutenticato(String email, String nomeUtente) {
        this.email = email;
        this.nomeUtente = nomeUtente;
    }
}
