package unicam.actors;

import org.junit.jupiter.api.Test;
import unicam.modelli.actors.Trasformatore;
import unicam.modelli.creators.CreatorProdotto;
import unicam.modelli.elements.Prodotto;
import unicam.modelli.informazioniAggiuntive.ProcessoTrasformazione;

import static org.junit.jupiter.api.Assertions.*;

class TrasformatoreTest {

    Trasformatore trasformatore = new Trasformatore("T1", "T1@something.com",null, null);
    @Test
    void testCreaProdotto() {

        trasformatore.creaProcesso("Processo2", "DescProcesso2");
        ProcessoTrasformazione pt = trasformatore.getProcessoTrasformazione("Processo2");
        CreatorProdotto creatorProdotto1 = new CreatorProdotto("prodotto1", "descr1",
                25.1, pt, trasformatore);

        Prodotto p = (Prodotto) creatorProdotto1.createItem();
        //TODO trasformatore.creaProdotto();
        assertEquals("prodotto1", p.getNomeItem());
        assertEquals("descr1", p.getDescrizione());
        assertEquals(25.1, p.getPrezzo());
        assertEquals(pt, p.getInformazioneAggiuntiva());
        assertEquals( trasformatore, p.getAziendaProduttrice());
    }

    @Test
    void testCreaProcesso() {
        trasformatore.creaProcesso("Processo1", "DescProcesso1");
        assertEquals( "Processo1", trasformatore.getProcessoTrasformazione("Processo1").getNome());
        assertEquals( "DescProcesso1", trasformatore.getProcessoTrasformazione("Processo1").getDescrizione());
        assertTrue(trasformatore.getProcessoTrasformazione("Processo1").getFasiTrasformazione().isEmpty() );
    }

    @Test
    void testAggiungiStepAlProcesso() {
        trasformatore.creaProcesso("Processo2", "DescProcesso2");
        trasformatore.aggiungiStepAlProcesso("DescFase2", "Processo2" );

        assertEquals( "DescFase2", trasformatore.getProcessoTrasformazione("Processo2").getFasiTrasformazione().getFirst().getDescrizione());

    }
}