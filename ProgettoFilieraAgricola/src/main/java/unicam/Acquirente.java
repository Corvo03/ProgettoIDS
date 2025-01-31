package unicam;

public class Acquirente extends UtenteAutenticato{
    private GestoreCarrello gestoreCarrello;

    public Acquirente(String email, String password, String nomeUtente) {
        super(email, password, nomeUtente);
        this.gestoreCarrello = new GestoreCarrello();
    }

    public void completaAcquisto(MetodoPagamento metodoPagamento) {
        gestoreCarrello.completaAcquisto(metodoPagamento);
    }

    public void aggiungiElementoAlCarrello(ElementoMarketplace elemento, int quantita) {
        gestoreCarrello.aggiungiElementoAlCarrello(elemento, quantita);
    }
    public void eliminaElementoDalCarrello(ElementoMarketplace elemento, int quantita) {
        gestoreCarrello.getCarrello().rimuoviElementoDalCarrello(elemento, quantita);
    }
}
