package unicam;

import java.util.List;
import java.util.Map;

public class GestoreMarketplace {
    private Marketplace marketPlace;

    public GestoreMarketplace() {
        marketPlace = new Marketplace();
    }

    public ElementoMarketplace creaElementoMarketPlace(Stock stock){
        ElementoMarketplace elementoMarketplace = new ElementoMarketplace(marketPlace.getMaxId()+1, stock);
        marketPlace.addElementoMarketplace(elementoMarketplace);
        return elementoMarketplace;
    }

    public Marketplace getMarketPlace() {
        return marketPlace;
    }

    public void aggiornaQuantitaElementi(Map<ElementoMarketplace, Integer> elementiCarrello) {
        for (ElementoMarketplace elemento : elementiCarrello.keySet()) {
            elemento.getStock().setQuantita(elemento.getStock().getQuantita() -
                    elementiCarrello.get(elemento));
        }
    }

    public List<ElementoMarketplace> getElementiDisponibiliMarketplace() {
        return marketPlace.getElementiDisponibiliMarketplace();
    }
}
