package unicam.actors;

import org.junit.jupiter.api.Test;
import unicam.modelli.actors.Curatore;
import unicam.modelli.actors.Produttore;
import unicam.modelli.gestori.GestoreInformazioni;
import unicam.modelli.gestori.GestoreSistema;
import unicam.modelli.informazioniAggiuntive.MetodoProduzione;

import static org.junit.jupiter.api.Assertions.*;

class CuratoreTest {

    Curatore curatore = new Curatore("nomeUtente", "email");
    Produttore produttore = new Produttore("nome", "cognome", null, null);

    @Test
    void approvaInformazione() {
        produttore.creaProdotto(10.f, "nome", "descrizione", new MetodoProduzione("metodo", "descrizione"));
        assertEquals(1, GestoreInformazioni.getInstance().getInformazioniDaApprovare().size());
        curatore.approvaInformazione(GestoreInformazioni.getInstance().getInformazioniDaApprovare().getFirst());
        assertTrue(GestoreInformazioni.getInstance().getInformazioniDaApprovare().isEmpty());
        produttore.getGestoreStock().ricaricaProdotto(produttore.getGestoreStock().getListaStock().getFirst(), 5);
        assertEquals(1, GestoreSistema.getInstance().getElementiDisponibiliMarketplace().size());
        assertEquals("nome", GestoreSistema.getInstance().getElementiDisponibiliMarketplace().getFirst().getStock().getNomeItem());
    }

    @Test
    void rifiutaInformazione() {
        produttore.creaProdotto(10.f, "nome", "descrizione", new MetodoProduzione("metodo", "descrizione"));
        assertEquals(1, GestoreInformazioni.getInstance().getInformazioniDaApprovare().size());
        curatore.rifiutaInformazione(GestoreInformazioni.getInstance().getInformazioniDaApprovare().getFirst());
        assertTrue(GestoreInformazioni.getInstance().getInformazioniDaApprovare().isEmpty());
        assertTrue(GestoreSistema.getInstance().getElementiDisponibiliMarketplace().isEmpty());
    }
}