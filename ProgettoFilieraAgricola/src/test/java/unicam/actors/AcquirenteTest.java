package unicam.actors;

import org.junit.jupiter.api.Test;
import unicam.modelli.actors.Acquirente;
import unicam.modelli.actors.Produttore;
import unicam.modelli.elements.ElementoMarketplace;
import unicam.modelli.elements.Prodotto;
import unicam.modelli.elements.Stock;
import unicam.modelli.marketplace.Bancomat;

import static org.junit.jupiter.api.Assertions.*;

class AcquirenteTest {
    Acquirente acquirente = new Acquirente("email", "nomeUtente");
    Produttore produttore = new Produttore("nome", "cognome", null, null);
    Prodotto prodotto = new Prodotto(10.0f, "Prodotto1", "Descrizione1", produttore);
    ElementoMarketplace elementoMarketplace = new ElementoMarketplace(1,new Stock(prodotto));
    Prodotto prodotto2 = new Prodotto(20.0f, "Prodotto2", "Descrizione2", produttore);
    ElementoMarketplace elementoMarketplace2 = new ElementoMarketplace(1,new Stock(prodotto2));

    private void ricaricaElementi() {
        elementoMarketplace.getStock().addQuantita(10);
        elementoMarketplace2.getStock().addQuantita(10);
    }

    @Test
    void completaAcquisto() {
        ricaricaElementi();
        acquirente.aggiungiElementoAlCarrello(elementoMarketplace, 1);
        acquirente.aggiungiElementoAlCarrello(elementoMarketplace2, 3);
        assertTrue(acquirente.getListaElementiCarrello().contains(elementoMarketplace));
        assertTrue(acquirente.getListaElementiCarrello().contains(elementoMarketplace2));
        String ricevuta = acquirente.completaAcquisto(new Bancomat());
        assertTrue(acquirente.getListaElementiCarrello().isEmpty());
        assertFalse(acquirente.getListaElementiCarrello().contains(elementoMarketplace));
        assertFalse(acquirente.getListaElementiCarrello().contains(elementoMarketplace2));
        acquirente.aggiungiElementoAlCarrello(elementoMarketplace, 1);
        acquirente.aggiungiElementoAlCarrello(elementoMarketplace2, 3);
        assertEquals(ricevuta, acquirente.completaAcquisto(new Bancomat()));
    }

    @Test
    void aggiungiElementoAlCarrello() {
        ricaricaElementi();
        assertTrue(acquirente.getListaElementiCarrello().isEmpty());
        acquirente.aggiungiElementoAlCarrello(elementoMarketplace, 1);
        acquirente.aggiungiElementoAlCarrello(elementoMarketplace2, 3);
        assertFalse(acquirente.getListaElementiCarrello().isEmpty());
        assertTrue(acquirente.getListaElementiCarrello().contains(elementoMarketplace));
        assertTrue(acquirente.getListaElementiCarrello().contains(elementoMarketplace2));
        assertEquals(2, acquirente.getListaElementiCarrello().size());
    }

    @Test
    void eliminaElementoDalCarrello() {
        ricaricaElementi();
        acquirente.aggiungiElementoAlCarrello(elementoMarketplace, 1);
        acquirente.aggiungiElementoAlCarrello(elementoMarketplace2, 3);
        assertEquals(2, acquirente.getListaElementiCarrello().size());
        assertTrue(acquirente.getListaElementiCarrello().contains(elementoMarketplace));
        assertTrue(acquirente.getListaElementiCarrello().contains(elementoMarketplace2));
        acquirente.eliminaElementoDalCarrello(elementoMarketplace, 1);
        assertFalse(acquirente.getListaElementiCarrello().contains(elementoMarketplace));
        assertTrue(acquirente.getListaElementiCarrello().contains(elementoMarketplace2));
        acquirente.eliminaElementoDalCarrello(elementoMarketplace2, 3);
        assertTrue(acquirente.getListaElementiCarrello().isEmpty());
        assertFalse(acquirente.getListaElementiCarrello().contains(elementoMarketplace));
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