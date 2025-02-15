package unicam;

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
            elemento.DecrementaQuantita(elementiCarrello.get(elemento));
        }
    }

    public List<ElementoMarketplace> getElementiDisponibiliMarketplace() {
        return marketPlace.getElementiDisponibiliMarketplace();
    }
}
