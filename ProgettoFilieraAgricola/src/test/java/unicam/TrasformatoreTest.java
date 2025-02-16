package unicam;

import org.junit.jupiter.api.Test;
import unicam.actors.Trasformatore;
import unicam.creators.CreatorProdotto;
import unicam.elements.Prodotto;
import unicam.informazioniAggiuntive.Fase;
import unicam.informazioniAggiuntive.ProcessoTrasformazione;

import static org.junit.jupiter.api.Assertions.*;

class TrasformatoreTest {

    Trasformatore trasformatore = new Trasformatore("T1", "T1@something.com");
    @Test
    void testCreaProdotto() {

        ProcessoTrasformazione info =  trasformatore.creaProcesso("Processo1", "DescProcesso1");
        CreatorProdotto creatorProdotto1 = new CreatorProdotto("prodotto1", "descr1",
                25.1, info, trasformatore);

        Prodotto p = (Prodotto) creatorProdotto1.createItem();
        //TODO trasformatore.creaProdotto();
        assertEquals("prodotto1", p.getNomeItem());
        assertEquals("descr1", p.getDescrizione());
        assertEquals(25.1, p.getPrezzo());
        assertEquals(info, p.getInformazioneAggiuntiva());
        assertEquals( trasformatore, p.getAziendaProduttrice());
    }

    @Test
    void testCreaProcesso() {
        ProcessoTrasformazione info =  trasformatore.creaProcesso("Processo1", "DescProcesso1");
        assertEquals( "Processo1", info.getNome());
        assertEquals( "DescProcesso1", info.getDescrizione());
        assertEquals( "", info.getFasiTrasformazione());

    }

    @Test
    void testAggiungiStepAlProcesso() {
        ProcessoTrasformazione info =  trasformatore.creaProcesso("Processo1", "DescProcesso1");
        info.AddFaseProduzione(new Fase("Fase1"));
        assertEquals( "Fase1", info.getFasiTrasformazione().getFirst().getDescrizione());

        info.AddFaseProduzione(new Fase("Fase2"));
        assertEquals( "Fase1 Fase2", info.getFasiTrasformazione().getFirst().getDescrizione() +
                " "+ info.getFasiTrasformazione().getLast().getDescrizione());
    }
}