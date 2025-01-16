package unicam;

import java.util.ArrayList;
import java.util.List;

public abstract class Azienda extends UtenteAutenticato {
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
    private GestoreStock gestoreStock;
    private InformazioniDaApprovare informazioniDaApprovare;

    public Azienda() {
        this.gestoreStock = new GestoreStock();
        this.inviti = new ArrayList<>();
        this.partecipazioni = new ArrayList<>();
        this.certificati = new ArrayList<>();
    }

    public void creaItem(Item item) {
        if (item == null)
            throw new NullPointerException("item null");

        this.gestoreStock.aggiungiNuovoItem(item);
    }

    public void creaProfilo(String nomeProfilo, String descrizione) {
        if (nomeProfilo == null)
            throw new NullPointerException("nome profilo null");
        if (descrizione == null)
            throw new NullPointerException("descrizione null");
        profilo = new Profilo(nomeProfilo, descrizione);
    }

    public void modificaInformazioniAzienda(String sedeLegale, List<String> indirizzoSediProduttive, String pec, String codiceFiscale, Profilo profilo) {
    /*
            String codiceFiscale) {
        if (sedeLegale != null)
            this.sedeLegale = sedeLegale;
        if (indirizzoSediProduttive != null)
            this.indirizzoSediProduttive = indirizzoSediProduttive;
        if (pec != null)
            this.pec = pec;
        if (codiceFiscale != null)
            this.codiceFiscale = codiceFiscale;
     */
        //gestore informazioni da approvare


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
