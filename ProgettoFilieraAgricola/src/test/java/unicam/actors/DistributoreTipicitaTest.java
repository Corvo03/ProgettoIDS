package unicam.actors;

import org.junit.jupiter.api.Test;
import unicam.modelli.actors.DistributoreTipicita;
import unicam.modelli.creators.CreatorProdotto;
import unicam.modelli.elements.Pacchetto;
import unicam.modelli.elements.Prodotto;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DistributoreTipicitaTest {

    DistributoreTipicita distributoreTipicita = new DistributoreTipicita("1", "distributore", "distr@gmail.com", null, null);
    CreatorProdotto creatorProdotto1 = new CreatorProdotto("1","prodotto1", "descr1",
            23.5, distributoreTipicita);
    CreatorProdotto creatorProdotto2 = new CreatorProdotto("2", "prodotto2", "descr2",
            27, distributoreTipicita);

    @Test
    void creaProdotto() {
        CreatorProdotto creatorProdotto1 = new CreatorProdotto("1", "prodotto1", "descr1",
                23.5, distributoreTipicita);
        Prodotto p = (Prodotto) creatorProdotto1.createItem();

        assertEquals(p.getNomeItem(), "prodotto1");
        assertEquals(p.getDescrizione(), "descr1");
        assertEquals(p.getPrezzo(), 23.5);
        assertEquals(p.getAziendaProduttrice(), distributoreTipicita);
    }
    @Test
    void creaPacchetto() {
        Prodotto p1 = (Prodotto) creatorProdotto1.createItem();
        Prodotto p2 = (Prodotto) creatorProdotto2.createItem();
        ArrayList<Prodotto> listaProdotti = new ArrayList<>();
        listaProdotti.add(p1);
        listaProdotti.add(p2);
        Pacchetto p = new Pacchetto("1", 50, "Pacchetto1", "DescrPacchett1", distributoreTipicita, listaProdotti);
        assertEquals(p.getNomeItem(), "Pacchetto1");
        assertEquals(p.getDescrizione(), "DescrPacchett1");
        assertEquals(p.getPrezzo(), 50);
        assertEquals(p.getAziendaProduttrice(), distributoreTipicita);
        assertEquals(p.getListaProdotti().getFirst().getNomeItem(), p1.getNomeItem());
        assertEquals(p.getListaProdotti().getLast().getNomeItem(), p2.getNomeItem());

    }

    @Test
    void aggiungiItemAPacchetto() {

    }

    @Test
    void getProdottoMarkeplace() {
        //TODO
    }
}