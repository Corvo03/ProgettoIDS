package unicam;

import java.util.List;

/**
 * Classe che rappresenta un acquirente che può aggiungere elementi al carrello e acquistarli
 */
public class Acquirente extends UtenteAutenticato {
    private final GestoreCarrello gestoreCarrello;

    public Acquirente(String email, String nomeUtente) {
        super(email, nomeUtente);
        this.gestoreCarrello = new GestoreCarrello();
    }

    /**
     * Delega al gestore il completamento acquisto del carrello
     *
     * @param metodoPagamento metodo di pagamento selezionato
     */
    public void completaAcquisto(MetodoPagamento metodoPagamento) {
        gestoreCarrello.completaAcquisto(metodoPagamento);
    }

    /**
     * Delega al gestore l'aggiunta di elementi del marketplacec nel carrello
     *
     * @param elemento elemento selezionato
     * @param quantita quantità da aggiungere
     */
    public void aggiungiElementoAlCarrello(ElementoMarketplace elemento, int quantita) {
        gestoreCarrello.aggiungiElementoAlCarrello(elemento, quantita);
    }

    /**
     * Delega al gestore l'eliminazione di un elemento dal carrello
     *
     * @param elemento elemento selezionato
     * @param quantita quantità da eliminare
     */
    public void eliminaElementoDalCarrello(ElementoMarketplace elemento, int quantita) {
        gestoreCarrello.getCarrello().rimuoviElementoDalCarrello(elemento, quantita);
    }

    /**
     * Ottiene la lista di tutti gli elementi disponibili nel marketplace.
     *
     * @return lista di elementi nel marketplace
     */
    public List<ElementoMarketplace> getListaMarketplace(){
        return GestoreSistema.getInstance().getElementiDisponibiliMarketplace();
    }
}
