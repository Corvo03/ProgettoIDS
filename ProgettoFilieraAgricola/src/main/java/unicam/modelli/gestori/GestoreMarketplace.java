package unicam.modelli.gestori;

import unicam.modelli.elements.Item;
import unicam.modelli.marketplace.Marketplace;
import unicam.modelli.elements.ElementoMarketplace;
import unicam.modelli.elements.Stock;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Classe che rappresenta il gestore del marketplace
 */
public class GestoreMarketplace {
    private Marketplace marketPlace;

    public GestoreMarketplace() {
        marketPlace = new Marketplace();
    }

    /**
     * Crea un nuovo elemento del marketplace a partire da uno Stock.
     * @param stock da inserire nel marketplace.
     * @return l'elemento del marketplace creato
     */
    public ElementoMarketplace creaElementoMarketPlace(Stock stock){
        ElementoMarketplace elementoMarketplace = new ElementoMarketplace(stock);
        marketPlace.addElementoMarketplace(elementoMarketplace);
        return elementoMarketplace;
    }

    /**
     * Elimina un elemento dal marketplace.
     * @param stock
     */
    public void eliminaElementoMarketplace(Stock stock) {
        marketPlace.eliminaElementoMarketplace(stock);
    }

    /**
     *
     * @param elementiCarrello
     */
    public void aggiornaQuantitaElementi(Map<ElementoMarketplace, Integer> elementiCarrello) {
        for (ElementoMarketplace elemento : elementiCarrello.keySet()) {
            elemento.decrementaQuantita(elementiCarrello.get(elemento));
        }
    }

    /**
     * Metodo per ottenere l'istanza del marketplace
     * @return l'istanza del marketplace.
     */
    public Marketplace getMarketPlace() {
        return marketPlace;
    }


    public List<ElementoMarketplace> getElementiDisponibiliMarketplace() {
        return marketPlace.getElementiDisponibiliMarketplace();
    }

    /**
     * Metodo per ottenere la scheda dell'item di uno speciale elemento marketplace a partire dall'id.
     * @param id da ricercare.
     * @return l'Item relativo all'elemento marketplace con quell'id, null se non lo trova.
     */
    public Item getItemById(String  id) {
        for(ElementoMarketplace elemento : getElementiDisponibiliMarketplace())
            if(Objects.equals(elemento.getId(), id))
                return elemento.getStock().getItem();
        //elemento non trovato
        return null;
    }



    public ElementoMarketplace getElementoMarketplaceDaId(String idElemento) {
        return marketPlace.getElementoMarketplaceDaId(idElemento);
    }

}
