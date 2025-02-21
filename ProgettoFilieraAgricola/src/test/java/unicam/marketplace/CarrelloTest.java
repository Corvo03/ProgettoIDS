package unicam.marketplace;

import org.junit.jupiter.api.Test;
import unicam.modelli.actors.Produttore;
import unicam.modelli.elements.ElementoMarketplace;
import unicam.modelli.elements.Prodotto;
import unicam.modelli.elements.Stock;
import unicam.modelli.marketplace.Carrello;
import unicam.modelli.marketplace.Marketplace;

import static org.junit.jupiter.api.Assertions.*;

class CarrelloTest {
    Marketplace marketplace = new Marketplace();
    Carrello carrello = new Carrello();
    Produttore produttore = new Produttore("nome", "cognome",null,null);
    Prodotto prodotto = new Prodotto(10.0, "Prodotto1", "Descrizione1", produttore);
    ElementoMarketplace elementoMarketplace = new ElementoMarketplace(1,new Stock(prodotto));
    Prodotto prodotto2 = new Prodotto(20.0, "Prodotto2", "Descrizione2", produttore);
    ElementoMarketplace elementoMarketplace2 = new ElementoMarketplace(1,new Stock(prodotto2));
    private void ricaricaElementi() {
        elementoMarketplace.getStock().addQuantita(10);
        elementoMarketplace2.getStock().addQuantita(10);
    }

    @Test
    void svuotaCarrello() {
        ricaricaElementi();
        assertTrue(carrello.getElementiCarrello().isEmpty());
        carrello.aggiungiElementoAlCarrello(elementoMarketplace, 1);
        carrello.aggiungiElementoAlCarrello(elementoMarketplace2, 1);
        assertEquals(2, carrello.getElementiCarrello().size());
        assertTrue(carrello.getElementiCarrello().containsKey(elementoMarketplace));
        assertTrue(carrello.getElementiCarrello().containsKey(elementoMarketplace2));
        carrello.svuotaCarrello();
        assertTrue(carrello.getElementiCarrello().isEmpty());
        assertFalse(carrello.getElementiCarrello().containsKey(elementoMarketplace));
        assertFalse(carrello.getElementiCarrello().containsKey(elementoMarketplace2));
    }

    @Test
    void aggiungiElementoAlCarrello() {
        ricaricaElementi();
        assertTrue(carrello.getElementiCarrello().isEmpty());
        carrello.aggiungiElementoAlCarrello(elementoMarketplace, 1);
        assertEquals(1, carrello.getElementiCarrello().size());
        assertTrue(carrello.getElementiCarrello().containsKey(elementoMarketplace));
        assertThrows(IllegalArgumentException.class, () -> carrello.aggiungiElementoAlCarrello
                (elementoMarketplace, 100));
    }

    @Test
    void rimuoviElementoDalCarrello() {
        ricaricaElementi();
        carrello.aggiungiElementoAlCarrello(elementoMarketplace, 1);
        assertEquals(1, carrello.getElementiCarrello().size());
        assertTrue(carrello.getElementiCarrello().containsKey(elementoMarketplace));
        assertThrows(IllegalArgumentException.class, () -> carrello.rimuoviElementoDalCarrello
                (elementoMarketplace, 2));
        carrello.rimuoviElementoDalCarrello(elementoMarketplace, 1);
        assertTrue(carrello.getElementiCarrello().isEmpty());
        assertFalse(carrello.getElementiCarrello().containsKey(elementoMarketplace));
        assertThrows(IllegalArgumentException.class, () -> carrello.rimuoviElementoDalCarrello
                (elementoMarketplace, 1));
    }
}