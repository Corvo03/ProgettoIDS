package unicam.marketplace;

import org.junit.jupiter.api.Test;
import unicam.modelli.actors.Produttore;
import unicam.modelli.elements.ElementoMarketplace;
import unicam.modelli.elements.Prodotto;
import unicam.modelli.elements.Stock;
import unicam.modelli.marketplace.Marketplace;

import static org.junit.jupiter.api.Assertions.*;

class MarketplaceTest {

    Marketplace marketplace = new Marketplace();
    Produttore produttore = new Produttore("id1","nome", "cognome",null,null);
    Prodotto prodotto = new Prodotto("id2",10.0, "Prodotto1", "Descrizione1", produttore);
    ElementoMarketplace elementoMarketplace = new ElementoMarketplace(new Stock(prodotto));

    @Test
    void getElementiDisponibiliMarketplace() {
        assertTrue(marketplace.getElementiDisponibiliMarketplace().isEmpty());
        marketplace.addElementoMarketplace(elementoMarketplace);
        assertTrue(marketplace.getElementiDisponibiliMarketplace().isEmpty());
        produttore.getGestoreStock().ricaricaProdotto(elementoMarketplace.getStock(), 2);
        assertFalse(marketplace.getElementiDisponibiliMarketplace().isEmpty());
        assertTrue(marketplace.getElementiDisponibiliMarketplace().contains(elementoMarketplace));
        assertEquals(1, marketplace.getElementiDisponibiliMarketplace().size());
    }

    @Test
    void testAddElementoMarketplace() {
        assertTrue(marketplace.getElementiDisponibiliMarketplace().isEmpty());
        marketplace.addElementoMarketplace(elementoMarketplace);
        assertTrue(marketplace.getElementiDisponibiliMarketplace().isEmpty());
        produttore.getGestoreStock().ricaricaProdotto(elementoMarketplace.getStock(), 2);
        assertFalse(marketplace.getElementiDisponibiliMarketplace().isEmpty());
        assertTrue(marketplace.getElementiDisponibiliMarketplace().contains(elementoMarketplace));
        assertEquals(1, marketplace.getElementiDisponibiliMarketplace().size());
    }

    @Test
    void removeElementoMarketplace() {
        assertTrue(marketplace.getElementiDisponibiliMarketplace().isEmpty());
        marketplace.addElementoMarketplace(elementoMarketplace);
        assertTrue(marketplace.getElementiDisponibiliMarketplace().isEmpty());
        produttore.getGestoreStock().ricaricaProdotto(elementoMarketplace.getStock(), 2);
        assertFalse(marketplace.getElementiDisponibiliMarketplace().isEmpty());
        assertTrue(marketplace.getElementiDisponibiliMarketplace().contains(elementoMarketplace));
        assertEquals(1, marketplace.getElementiDisponibiliMarketplace().size());
        assertThrows(IllegalArgumentException.class, () -> marketplace.removeElementoMarketplace
                (new ElementoMarketplace(new Stock(new Prodotto("id3",10.0, "Prodotto2",
                        "Descrizione2", produttore)))));
        marketplace.removeElementoMarketplace(elementoMarketplace);
        assertTrue(marketplace.getElementiDisponibiliMarketplace().isEmpty());
        assertFalse(marketplace.getElementiDisponibiliMarketplace().contains(elementoMarketplace));
    }

    @Test
    void testRemoveElementoMarketplace() {
    }

    @Test
    void getListaElementi() {

    }
}