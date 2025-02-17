package unicam.gestori;

import unicam.elements.Item;
import unicam.marketplace.Marketplace;
import unicam.elements.ElementoMarketplace;
import unicam.elements.Stock;

import java.util.List;
import java.util.Map;

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
        ElementoMarketplace elementoMarketplace = new ElementoMarketplace(marketPlace.getMaxId()+1, stock);
        marketPlace.addElementoMarketplace(elementoMarketplace);
        return elementoMarketplace;
    }

    /**
     * Metodo per ottenere l'istanza del marketplace
     * @return l'istanza del marketplace.
     */
    public Marketplace getMarketPlace() {
        return marketPlace;
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

    public List<ElementoMarketplace> getElementiDisponibiliMarketplace() {
        return marketPlace.getElementiDisponibiliMarketplace();
    }

    /**
     * Metodo per ottenere la scheda dell'item di uno speciale elemento marketplace a partire dall'id.
     * @param id da ricercare.
     * @return l'Item relativo all'elemento marketplace con quell'id, null se non lo trova.
     */
    public Item getItemById(int id) {
        for(ElementoMarketplace elemento : getElementiDisponibiliMarketplace())
            if(elemento.getId() == id)
                return elemento.getStock().getItem();
        //elemento non trovato
        return null;
    }

    public void eliminaElementoMarketplace(Stock stock) {
        marketPlace.eliminaElementoMarketplace(stock);
    }
}
