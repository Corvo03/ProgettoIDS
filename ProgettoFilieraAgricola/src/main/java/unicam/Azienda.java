package unicam;

import java.util.ArrayList;
import java.util.List;

public abstract non-sealed class Azienda extends UtenteAutenticato implements  RichiedenteVerificaInformazione{
    private String nomeAzienda;
    private String partitaIva;
    private String sedeLegale;
    private List<String> indirizzoSediProduttive;
    private String pec;
    private String codiceFiscale;
    private Profilo profilo;
    private List<Invito> inviti;
    private List<Partecipazione> partecipazioni;
    private List<Certificato> certificati;
    private final GestoreStock gestoreStock;
    private InformazioneDaApprovare informazioniDaApprovare;
    private final GestoreInformazioni gestoreInformazioni;

    public Azienda() {
        this.gestoreStock = new GestoreStock();
        this.inviti = new ArrayList<>();
        this.partecipazioni = new ArrayList<>();
        this.certificati = new ArrayList<>();
        this.gestoreInformazioni = GestoreInformazioni.getInstance();
    }

    public void creaProfilo(String nomeProfilo, String descrizione) {
        if (nomeProfilo == null)
            throw new NullPointerException("nome profilo null");
        if (descrizione == null)
            throw new NullPointerException("descrizione null");
        profilo = new Profilo(nomeProfilo, descrizione);
    }

    /**
     * Permette di modificare le informazioni sensibili dell'azienda, queste devono essere approvate dal curatore.
     * @param sedeLegale dell'azienda da modificare
     * @param pec dell'azienda da modificare
     * @param nomeAzienda dell'azienda da modificare
     * @param pIva dell'azienda da modificare
     * @param codiceFiscale  dell'azienda da modificare
     *
     * @throws NullPointerException se una delle informazioni è nulla
     */
    public void modificaInformazioniAzienda(String sedeLegale, String pec, String nomeAzienda, String pIva, String codiceFiscale){
        if (sedeLegale == null || nomeAzienda == null ||
                pec == null || codiceFiscale==null || pIva == null)
            throw new NullPointerException("informazioni null");

        gestoreInformazioni.aggiungiInformazioneDaApprovare(
                new InformazioniSensibili(sedeLegale, pec, nomeAzienda, pIva, codiceFiscale));
    }

    public void ricaricaProdotto(Stock stock, int quantita) {
        if (stock == null)
            throw new NullPointerException("prodotto null");
        this.gestoreStock.ricaricaProdotto(stock, quantita);
    }

    public void accettaInvito(Invito invito) {
        if (invito == null)
            throw new NullPointerException("invito null");
        if (!inviti.contains(invito))
            throw new IllegalArgumentException("invito non presente");
        invito.setAccettato(true);
        inviti.remove(invito);
        partecipazioni.add(new Partecipazione(this)); //todo: passare i parametri
    }

    public void rifiutaInvito(Invito invito) {
        if (invito == null)
            throw new NullPointerException("invito null");
        if (!inviti.contains(invito))
            throw new IllegalArgumentException("invito non presente");
        inviti.remove(invito);
    }
}
