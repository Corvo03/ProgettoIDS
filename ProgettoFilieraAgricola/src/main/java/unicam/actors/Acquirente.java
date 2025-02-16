package unicam.actors;

import unicam.elements.ElementoMarketplace;
import unicam.gestori.GestoreCarrello;
import unicam.gestori.GestoreSistema;
import unicam.marketplace.Carrello;
import unicam.marketplace.MetodoPagamento;

import java.util.ArrayList;
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
    public String completaAcquisto(MetodoPagamento metodoPagamento) {
        return gestoreCarrello.completaAcquisto(metodoPagamento);
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

    /**
     * Ottiene la lista di tutti gli elementi presenti nel carrello.
     *
     * @return
     */
    public List<ElementoMarketplace> getListaElementiCarrello(){
        return new ArrayList<>(gestoreCarrello.getCarrello().getElementiCarrello().keySet());
    }
}
