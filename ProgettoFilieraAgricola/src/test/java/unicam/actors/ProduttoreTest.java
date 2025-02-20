package unicam.actors;

import unicam.creators.CreatorProdotto;
import unicam.gestori.GestoreSistema;
import unicam.gestori.certificato.Certificato;
import unicam.gestori.certificato.GestoreCertificatoScrittura;
import unicam.informazioniAggiuntive.MetodoProduzione;
import unicam.elements.Prodotto;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class ProduttoreTest {

    GestoreCertificatoScrittura gcs = new GestoreCertificatoScrittura();
    Produttore produttore = new Produttore("produttore", "Prod@prod.te");
    @org.junit.jupiter.api.Test
    void creaProdotto() {
        this.produttore.creaMetodoProduzione("MetProd1", "descrMetodo1");
        MetodoProduzione mp = this.produttore.getMetodoProduzione("MetProd1");
        CreatorProdotto creatorProdotto1 = new CreatorProdotto("prodotto1", "descr1",
                23.5, mp, produttore);

        Prodotto p = (Prodotto) creatorProdotto1.createItem();

        assertEquals(p.getNomeItem(), "prodotto1");
        assertEquals(p.getDescrizione(), "descr1");
        assertEquals(p.getPrezzo(), 23.5);
        assertEquals(p.getInformazioneAggiuntiva(), mp);
        assertEquals(p.getAziendaProduttrice(), produttore);

        //aggiungi certificati
        aggiungiCertificati();
        List<Certificato> cert = GestoreSistema.getInstance().getListaCertificati();
        produttore.aggiungiCertificatoProdotto(cert.getFirst(), p);
        produttore.aggiungiCertificatoProdotto(cert.getLast(), p);

        assertEquals(2, p.getListaCertificati().size());
        assertEquals("Cert1", p.getListaCertificati().getFirst().getNome());
    }

    private void aggiungiCertificati(){
        for(int i=1; i<=15; i++){
            gcs.aggiungiCertificato(new Certificato( "Cert"+i, "Descr"+i));
        }
    }

    @org.junit.jupiter.api.Test
    void testCreaMetodoProduzione() {
        this.produttore.creaMetodoProduzione("MetProd2", "descrMetodo2");
        assertEquals(this.produttore.getMetodoProduzione("MetProd2").getNome(), "MetProd2");
        assertEquals(this.produttore.getMetodoProduzione("MetProd2").getDescrizione(), "descrMetodo2");
    }
}