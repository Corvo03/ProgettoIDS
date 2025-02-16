package unicam.actors.azienda;


import unicam.marketplace.InformazioneDaApprovare;

public class InformazioniSensibili implements InformazioneDaApprovare {
    private String sedeLegale;
    private String pec;
    private String nomeAzienda;
    private String pIva;
    private String codiceFiscale;

    public InformazioniSensibili(String sedeLegale, String pec, String nomeAzienda, String pIva, String codiceFiscale) {
        this.sedeLegale = sedeLegale;
        this.pec = pec;
        this.nomeAzienda = nomeAzienda;
        this.pIva = pIva;
        this.codiceFiscale = codiceFiscale;
    }
}
