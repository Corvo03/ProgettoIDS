package unicam;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DistributoreTipicitaTest {

    DistributoreTipicita distributoreTipicita = new DistributoreTipicita();
    CreatorProdotto creatorProdotto1 = new CreatorProdotto("prodotto1", "descr1",
            23.5, distributoreTipicita);
    CreatorProdotto creatorProdotto2 = new CreatorProdotto("prodotto2", "descr2",
            27, distributoreTipicita);

    @Test
    void creaProdotto() {
        CreatorProdotto creatorProdotto1 = new CreatorProdotto("prodotto1", "descr1",
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
        Pacchetto p = new Pacchetto(50, "Pacchetto1", "DescrPacchett1", distributoreTipicita, listaProdotti);
        assertEquals(p.getNomeItem(), "Pacchetto1");
        assertEquals(p.getDescrizione(), "DescrPacchett1");
        assertEquals(p.getPrezzo(), 50);
        assertEquals(p.getAzienda(), distributoreTipicita);
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