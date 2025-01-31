package unicam;

import java.util.ArrayList;
import java.util.List;

public abstract non-sealed class Azienda extends UtenteAutenticato implements RichiedenteVerificaInformazione {
    private List<String> indirizzoSediProduttive;
    private List<Certificato> certificati;
    private final GestoreStock gestoreStock;
    private InformazioniSensibili informazioniSensibili;
    private AccettatoreInvito accettatoreInvito;

    public Azienda() {
        //todo mettere altro costruttore di Autenticato
        super();
        this.gestoreStock = new GestoreStock();
        this.certificati = new ArrayList<>();
    }

    public void creaProfilo(String nomeProfilo, String descrizione) {
        if (nomeProfilo == null)
            throw new NullPointerException("nome profilo null");
        if (descrizione == null)
            throw new NullPointerException("descrizione null");
        //TODO: Claudio
    }

    public void setIndirizzoSediProduttive(List<String> indirizzoSediProduttive) {
        this.indirizzoSediProduttive = indirizzoSediProduttive;
    }

    public void accettaInvito(Invito invito) {
        //todo: claudio
    }

    public void rifiutaInvito(Invito invito) {
        //todo: claudio
    }

    /**
     * Richiede la verifica delle informazioni sensibili.
     *
     *
     * @param sedeLegale la sede legale dell'azienda
     * @param pec l'indirizzo di posta elettronica certificata
     * @param nomeAzienda il nome dell'azienda
     * @param pIva la partita iva dell'azienda
     * @param codiceFiscale il codice fiscale dell'azienda
     */
    public void modificaDatiSensibili(String sedeLegale, String pec, String nomeAzienda,
                                      String pIva, String codiceFiscale) {
        //TODO: fare in modo che si possano cambiare solo alcune informazioni
        richiediVerificaInformazioni(new InformazioniSensibili(sedeLegale, pec,nomeAzienda, pIva, codiceFiscale));
    }

    public GestoreStock getGestoreStock() {
        return gestoreStock;
    }

    public void setInformazioniSensibili(InformazioniSensibili informazioniSensibili) {
        this.informazioniSensibili = informazioniSensibili;
    }
}
