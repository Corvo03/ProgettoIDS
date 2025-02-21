package unicam.modelli.gestori;

import unicam.modelli.elements.Certificato;

import java.util.ArrayList;
import java.util.List;

public class GestoreCertificato{
    protected final static List<Certificato> listaCertificati = new ArrayList<>();

    public List<Certificato> getListaCertificati(){
        return listaCertificati;
    }

    /**
     * Aggiunge un certificato alla lista dei certificati.
     * Facendo così solo chi ha i permessi di scrittura può aggiungere certificati.
     *
     * @param certificato da aggiungere alla lista.
     */
    public void creaCertificato(Certificato certificato){
        listaCertificati.add(certificato);
    }
}
