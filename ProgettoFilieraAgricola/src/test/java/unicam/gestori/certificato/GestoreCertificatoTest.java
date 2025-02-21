package unicam.gestori.certificato;

import org.junit.jupiter.api.Test;
import unicam.modelli.actors.Produttore;
import unicam.modelli.elements.Certificato;
import unicam.modelli.gestori.GestoreCertificato;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GestoreCertificatoTest {

    Produttore p = new Produttore("abc", "abc@de.f",null, null);
    GestoreCertificato gestoreCertificato = new GestoreCertificato();
    @Test
    void creaCertificato() {
        gestoreCertificato.getListaCertificati().clear();
        assertTrue(gestoreCertificato.getListaCertificati().isEmpty());

        gestoreCertificato.creaCertificato(new Certificato("Cert1", "Cert1"));
        gestoreCertificato.creaCertificato(new Certificato("Cert2", "Cert2"));

        assertEquals(2, gestoreCertificato.getListaCertificati().size());
        assertEquals("Cert1", gestoreCertificato.getListaCertificati().getFirst().getNome());
        assertEquals("Cert2", gestoreCertificato.getListaCertificati().getLast().getNome());

        gestoreCertificato.creaCertificato(new Certificato("Cert3", "Cert3"));
        assertEquals("Cert3", gestoreCertificato.getListaCertificati().getLast().getNome());
        assertEquals(3, gestoreCertificato.getListaCertificati().size());


    }
}