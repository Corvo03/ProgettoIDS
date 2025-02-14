package unicam;

import org.junit.Assert;

import static org.junit.jupiter.api.Assertions.*;


class ProduttoreTest {

    Produttore produttore = new Produttore();
    @org.junit.jupiter.api.Test
    void creaProdotto() {
        MetodoProduzione info =  produttore.creaMetodoProduzione("Metodo1", "DescMetodo1");
        CreatorProdotto creatorProdotto1 = new CreatorProdotto("prodotto1", "descr1",
                23.5, info, produttore);

        Prodotto p = (Prodotto) creatorProdotto1.createItem();

        assertEquals(p.getNomeItem(), "prodotto1");
        assertEquals(p.getDescrizione(), "descr1");
        assertEquals(p.getPrezzo(), 23.5);
        assertEquals(p.getInformazioneAggiuntiva(), info);
        assertEquals(p.getAziendaProduttrice(), produttore);

    }

    @org.junit.jupiter.api.Test
    void testCreaMetodoProduzione() {
        MetodoProduzione info =  produttore.creaMetodoProduzione("Metodo1", "DescMetodo1");
        assertEquals(info.getNome(), "Metodo1");
        assertEquals(info.getDescrizione(), "DescMetodo1");
    }
}