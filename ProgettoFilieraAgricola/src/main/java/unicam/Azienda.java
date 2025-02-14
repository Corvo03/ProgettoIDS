package unicam;

import java.util.ArrayList;
import java.util.List;

public abstract non-sealed class Azienda extends UtenteAutenticato implements RichiedenteVerificaInformazione,PartecipanteEvento {
    private List<String> indirizzoSediProduttive;
    private List<Certificato> certificati;
    private final GestoreStock gestoreStock;
    private InformazioniSensibili informazioniSensibili;
    private AccettatoreInvito accettatoreInvito;

    public Azienda() {
        //TODO mettere altro costruttore di Autenticato
        super();
        this.gestoreStock = new GestoreStock();
        this.certificati = new ArrayList<>();
    }

    /**
     *
     *
     * @param nomeProfilo
     * @param descrizione
     */
    public void creaProfilo(String nomeProfilo, String descrizione) {
        if (nomeProfilo == null)
            throw new NullPointerException("nome profilo null");
        if (descrizione == null)
            throw new NullPointerException("descrizione null");
        GestoreSistema.getInstance().aggiungiProfilo(new Profilo(nomeProfilo, descrizione, this));
    }

    public void setIndirizzoSediProduttive(List<String> indirizzoSediProduttive) {
        this.indirizzoSediProduttive = indirizzoSediProduttive;
    }

    /**
     * Delega l'accettazione all'accettatore
     * @param invitoDaAccettare
     */
    public void accettaInvito(Invito invitoDaAccettare) {
        this.accettatoreInvito.accettaInvito(invitoDaAccettare);
    }

    /**
     * Delega il rifiuto invito all'accettatore
     * @param invitoDaRifiutare
     */
    public void rifiutaInvito(Invito invitoDaRifiutare) {
            this.accettatoreInvito.rifiutaInvito(invitoDaRifiutare);
    }

    /**
     * Richiede la verifica delle informazioni sensibili al curatore.
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

    public void aggiungiCertificatoProdotto(Certificato certificato, Prodotto prodotto) {
        prodotto.addCertificato(certificato);
    }
}
