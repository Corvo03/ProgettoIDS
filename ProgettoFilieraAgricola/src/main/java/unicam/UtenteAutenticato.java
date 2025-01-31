package unicam;

public abstract class UtenteAutenticato {
    private String email;
    private String password;
    private String nomeUtente;

    public UtenteAutenticato(String email, String password, String nomeUtente) {
        this.email = email;
        this.password = password;
        this.nomeUtente = nomeUtente;
    }

    public UtenteAutenticato() {

    }
}
