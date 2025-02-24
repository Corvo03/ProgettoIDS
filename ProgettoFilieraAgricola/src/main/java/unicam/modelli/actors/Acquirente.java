package unicam.modelli.actors;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import unicam.modelli.elements.ElementoMarketplace;
import unicam.modelli.gestori.GestoreCarrello;
import unicam.modelli.gestori.GestoreSistema;
import unicam.modelli.marketplace.Carrello;
import unicam.modelli.marketplace.MetodoPagamento;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe che rappresenta un acquirente che può aggiungere elementi al carrello e acquistarli
 */
@Entity
public class Acquirente extends UtenteAutenticato {
    @Id
    private String id;
    @Transient
    private GestoreCarrello gestoreCarrello;

    public Acquirente(String id,String email, String nomeUtente) {
        super(email, nomeUtente);
        this.gestoreCarrello = new GestoreCarrello();
        this.id = id;
    }

    public Acquirente() {}

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

    public void eliminaElementoDalCarrello(ElementoMarketplace elemento) {
        gestoreCarrello.getCarrello().rimuoviElementoDalCarrello(elemento);
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

    public Object getId() {
        return id;
    }

    public Carrello getCarrello() {
        return gestoreCarrello.getCarrello();
    }
}
