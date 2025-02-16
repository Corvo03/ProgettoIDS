package unicam.actors.azienda;

import unicam.actors.UtenteAutenticato;
import unicam.elements.Prodotto;
import unicam.gestori.GestoreSistema;
import unicam.gestori.GestoreStock;
import unicam.gestori.certificato.Certificato;
import unicam.inviti.Invito;
import unicam.inviti.PartecipanteEvento;
import unicam.inviti.RiceventeInvito;
import unicam.marketplace.RichiedenteVerificaInformazione;

import java.util.ArrayList;
import java.util.List;

public abstract non-sealed class Azienda extends UtenteAutenticato implements RichiedenteVerificaInformazione, PartecipanteEvento {
    private List<String> indirizzoSediProduttive;
    private List<Certificato> certificati;
    private final GestoreStock gestoreStock;
    private InformazioniSensibili informazioniSensibili;
    private RiceventeInvito riceventeInvito;
    private Profilo profilo;


    /**
     * Crea un azienda con una determinata mail e nomeUtente
     * @param email
     * @param nomeUtente
     */
    public Azienda(String email, String nomeUtente) {
        super(email, nomeUtente);
        this.gestoreStock = new GestoreStock();
        this.certificati = new ArrayList<>();
    }

    /**
     * Crea un profilo per l'azienda, visualizzabile nella sezione profili.
     * @param nomeProfilo del profilo relativo all'azienda.
     * @param descrizione del profilo aziendale.
     */
    public void creaProfilo(String nomeProfilo, String descrizione) {
        if (nomeProfilo == null)
            throw new NullPointerException("nome profilo null");
        if (descrizione == null)
            throw new NullPointerException("descrizione null");
        this.profilo = new Profilo(nomeProfilo, descrizione, this);
        GestoreSistema.getInstance().aggiungiProfilo(this.profilo);
    }

    /**
     * Imposta l'elenco di sedi produttive
     * @param indirizzoSediProduttive la lista delle sedi da inserire
     *
     * @throws NullPointerException se la lista è nulla o vuota.
     */
    public void setIndirizzoSediProduttive(List<String> indirizzoSediProduttive) {
        if (indirizzoSediProduttive == null || indirizzoSediProduttive.isEmpty())
            throw new NullPointerException("Indirizzi Sedi Produttive non validi");
        this.indirizzoSediProduttive = indirizzoSediProduttive;
    }

    /**
     * Delega l'accettazione all'accettatore
     * @param invitoDaAccettare
     */
    public void accettaInvito(Invito invitoDaAccettare) {
        this.riceventeInvito.accettaInvito(invitoDaAccettare);
    }

    /**
     * Delega il rifiuto invito all'accettatore
     * @param invitoDaRifiutare
     */
    public void rifiutaInvito(Invito invitoDaRifiutare) {
            this.riceventeInvito.rifiutaInvito(invitoDaRifiutare);
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
        richiediVerificaInformazioni(new InformazioniSensibili(sedeLegale, pec, nomeAzienda, pIva, codiceFiscale));
    }

    public GestoreStock getGestoreStock() {
        return gestoreStock;
    }

    public RiceventeInvito getRiceventeInvito() {
        return riceventeInvito;
    }

    public void setInformazioniSensibili(InformazioniSensibili informazioniSensibili){
        this.informazioniSensibili = informazioniSensibili;
    }
}
