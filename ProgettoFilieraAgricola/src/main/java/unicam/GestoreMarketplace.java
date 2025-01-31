package unicam;

import java.util.Map;

public class GestoreMarketplace {
    private static GestoreMarketplace istanza;
    private Marketplace marketPlace;

    private GestoreMarketplace() {
        marketPlace = new Marketplace();
    }

    public static GestoreMarketplace getInstance() {
        if (istanza == null)
            istanza = new GestoreMarketplace();
        return istanza;
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
}