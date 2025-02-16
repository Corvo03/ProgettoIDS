package unicam.actors;

import org.junit.jupiter.api.Test;
import unicam.elements.ElementoMarketplace;
import unicam.elements.Prodotto;
import unicam.elements.Stock;
import unicam.marketplace.Bancomat;
import unicam.marketplace.Marketplace;

import static org.junit.jupiter.api.Assertions.*;

class AcquirenteTest {
    Acquirente acquirente = new Acquirente("email", "nomeUtente");
    Produttore produttore = new Produttore("nome", "cognome");
    Prodotto prodotto = new Prodotto(10.0f, "Prodotto1", "Descrizione1", produttore);
    ElementoMarketplace elementoMarketplace = new ElementoMarketplace(1,new Stock(prodotto));
    Prodotto prodotto2 = new Prodotto(20.0f, "Prodotto2", "Descrizione2", produttore);
    ElementoMarketplace elementoMarketplace2 = new ElementoMarketplace(1,new Stock(prodotto2));

    private void ricaricaElementi() {
        produttore.getGestoreStock().ricaricaProdotto(produttore.getGestoreStock().getListaStock().getFirst(), 5);
        produttore.getGestoreStock().ricaricaProdotto(produttore.getGestoreStock().getListaStock().getLast(), 5);
    }

    @Test
    void completaAcquisto() {
        ricaricaElementi();
        acquirente.aggiungiElementoAlCarrello(elementoMarketplace, 1);
        acquirente.aggiungiElementoAlCarrello(elementoMarketplace2, 3);
        assertTrue(acquirente.getListaMarketplace().contains(elementoMarketplace));
        assertTrue(acquirente.getListaMarketplace().contains(elementoMarketplace2));
        String ricevuta = acquirente.completaAcquisto(new Bancomat());
        assertTrue(acquirente.getListaMarketplace().isEmpty());
        assertFalse(acquirente.getListaMarketplace().contains(elementoMarketplace));
        assertFalse(acquirente.getListaMarketplace().contains(elementoMarketplace2));
        acquirente.aggiungiElementoAlCarrello(elementoMarketplace, 1);
        acquirente.aggiungiElementoAlCarrello(elementoMarketplace2, 3);
        assertEquals(ricevuta, acquirente.completaAcquisto(new Bancomat()));
    }

    @Test
    void aggiungiElementoAlCarrello() {
        ricaricaElementi();
        assertTrue(acquirente.getListaMarketplace().isEmpty());
        acquirente.aggiungiElementoAlCarrello(elementoMarketplace, 1);
        acquirente.aggiungiElementoAlCarrello(elementoMarketplace2, 3);
        assertFalse(acquirente.getListaMarketplace().isEmpty());
        assertTrue(acquirente.getListaMarketplace().contains(elementoMarketplace));
        assertTrue(acquirente.getListaMarketplace().contains(elementoMarketplace2));
        assertEquals(2, acquirente.getListaMarketplace().size());
    }

    @Test
    void eliminaElementoDalCarrello() {
        ricaricaElementi();
        acquirente.aggiungiElementoAlCarrello(elementoMarketplace, 1);
        acquirente.aggiungiElementoAlCarrello(elementoMarketplace2, 3);
        assertEquals(2, acquirente.getListaMarketplace().size());
        assertTrue(acquirente.getListaMarketplace().contains(elementoMarketplace));
        assertTrue(acquirente.getListaMarketplace().contains(elementoMarketplace2));
        acquirente.eliminaElementoDalCarrello(elementoMarketplace, 1);
        assertFalse(acquirente.getListaMarketplace().contains(elementoMarketplace));
        assertTrue(acquirente.getListaMarketplace().contains(elementoMarketplace2));
        acquirente.eliminaElementoDalCarrello(elementoMarketplace2, 3);
        assertTrue(acquirente.getListaMarketplace().isEmpty());
        assertFalse(acquirente.getListaMarketplace().contains(elementoMarketplace));
    }

    @Test
    void getListaElementiCarrello() {
        ricaricaElementi();
        acquirente.aggiungiElementoAlCarrello(elementoMarketplace, 1);
        acquirente.aggiungiElementoAlCarrello(elementoMarketplace2, 3);
        assertEquals(2, acquirente.getListaElementiCarrello().size());
        assertTrue(acquirente.getListaElementiCarrello().contains(elementoMarketplace));
        assertTrue(acquirente.getListaElementiCarrello().contains(elementoMarketplace2));
    }
}