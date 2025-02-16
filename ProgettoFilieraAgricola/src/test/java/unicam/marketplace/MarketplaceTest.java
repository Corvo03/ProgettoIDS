package unicam.marketplace;

import org.junit.jupiter.api.Test;
import unicam.actors.Produttore;
import unicam.elements.ElementoMarketplace;
import unicam.elements.Prodotto;
import unicam.elements.Stock;
import unicam.informazioniAggiuntive.MetodoProduzione;

import static org.junit.jupiter.api.Assertions.*;

class MarketplaceTest {

    Marketplace marketplace = new Marketplace();
    Produttore produttore = new Produttore("nome", "cognome");
    Prodotto prodotto = new Prodotto(10.0f, "Prodotto1", "Descrizione1", produttore);
    ElementoMarketplace elementoMarketplace = new ElementoMarketplace(1,new Stock(prodotto));

    @Test
    void getElementiDisponibiliMarketplace() {
        assertTrue(marketplace.getElementiDisponibiliMarketplace().isEmpty());
        marketplace.addElementoMarketplace(elementoMarketplace);
        assertTrue(marketplace.getElementiDisponibiliMarketplace().isEmpty());
        produttore.getGestoreStock().ricaricaProdotto(produttore.getGestoreStock().getListaStock().getFirst(), 2);
        assertFalse(marketplace.getElementiDisponibiliMarketplace().isEmpty());
        assertTrue(marketplace.getElementiDisponibiliMarketplace().contains(elementoMarketplace));
        assertEquals(1, marketplace.getElementiDisponibiliMarketplace().size());
    }

    @Test
    void testAddElementoMarketplace() {
    }

    @Test
    void removeElementoMarketplace() {
    }

    @Test
    void testRemoveElementoMarketplace() {
    }

    @Test
    void getListaElementi() {

    }
}