package unicam;

/**
 * descrive elementi dell'acquirente
 */
public class Acquirente extends UtenteAutenticato{
    private GestoreCarrello gestoreCarrello;

    /**
     *
     * @param email
     * @param password
     * @param nomeUtente
     */
    public Acquirente(String email, String password, String nomeUtente) {
        super(email, password, nomeUtente);
        this.gestoreCarrello = new GestoreCarrello();
    }

    /**
     * delega al gestore il completamento acquisto del carrello
     * @param metodoPagamento
     */
    public void completaAcquisto(MetodoPagamento metodoPagamento) {
        gestoreCarrello.completaAcquisto(metodoPagamento);
    }

    /**
     * delega al gestore l'aggiunta di elementi del marketplacec nel carrello
     * @param elemento
     * @param quantita
     */
    public void aggiungiElementoAlCarrello(ElementoMarketplace elemento, int quantita) {
        gestoreCarrello.aggiungiElementoAlCarrello(elemento, quantita);
    }

    /**
     * delega al gestore l'eliminazione di un elemento dal carrello
     * @param elemento
     * @param quantita
     */
    public void eliminaElementoDalCarrello(ElementoMarketplace elemento, int quantita) {
        gestoreCarrello.getCarrello().rimuoviElementoDalCarrello(elemento, quantita);
    }
}
