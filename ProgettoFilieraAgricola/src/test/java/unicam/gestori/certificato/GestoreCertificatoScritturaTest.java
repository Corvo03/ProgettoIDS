package unicam.gestori.certificato;

import org.junit.jupiter.api.Test;
import unicam.actors.Produttore;

import static org.junit.jupiter.api.Assertions.*;

class GestoreCertificatoScritturaTest {

    Produttore p = new Produttore("abc", "abc@de.f");
    GestoreCertificatoScrittura gcs = new GestoreCertificatoScrittura();
    GestoreCertificatoLettura gcl = new GestoreCertificatoLettura();
    @Test
    void aggiungiCertificato() {
        gcs.getListaCertificati().clear();
        assertTrue(gcl.getListaCertificati().isEmpty());

        gcs.aggiungiCertificato(new Certificato("Cert1", "Cert1"));
        gcs.aggiungiCertificato(new Certificato("Cert2", "Cert2"));

        assertEquals(2, gcl.getListaCertificati().size());
        assertEquals("Cert1", gcl.getListaCertificati().getFirst().getNome());
        assertEquals("Cert2", gcl.getListaCertificati().getLast().getNome());

        gcs.aggiungiCertificato(new Certificato("Cert3", "Cert3"));
        assertEquals("Cert3", gcl.getListaCertificati().getLast().getNome());
        assertEquals(3, gcl.getListaCertificati().size());


    }
}