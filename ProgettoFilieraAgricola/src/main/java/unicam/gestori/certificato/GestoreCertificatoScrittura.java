package unicam.gestori.certificato;

public class GestoreCertificatoScrittura extends GestoreCertificatoLettura{

    /**
     * Aggiunge un certificato alla lista dei certificati.
     * Facendo così solo chi ha i permessi di scrittura può aggiungere certificati.
     *
     * @param certificato da aggiungere alla lista.
     */
    public void aggiungiCertificato(Certificato certificato){
        listaCertificati.add(certificato);
    }
}
