package unicam.modelli.actors.azienda;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import unicam.modelli.marketplace.InformazioneDaApprovare;

/**
 * Informazione sensibile dell'azienda, è una informazione che va approvata
 */
@Entity
public class InformazioniSensibili implements InformazioneDaApprovare {
    @Id
    private String id;
    private String sedeLegale;
    private String pec;
    private String nomeAzienda;
    private String pIva;
    private String codiceFiscale;

    /**
     * Crea un'informazione sensibile
     * @param sedeLegale
     * @param pec
     * @param nomeAzienda
     * @param pIva
     * @param codiceFiscale
     */
    public InformazioniSensibili(String sedeLegale, String pec, String nomeAzienda, String pIva, String codiceFiscale) {
        this.sedeLegale = sedeLegale;
        this.pec = pec;
        this.nomeAzienda = nomeAzienda;
        this.pIva = pIva;
        this.codiceFiscale = codiceFiscale;
    }

    public InformazioniSensibili() {

    }

    public String getId() {
        return id;
    }

    public String getSedeLegale() {
        return sedeLegale;
    }

    public String getPec() {
        return pec;
    }

    public String getNomeAzienda() {
        return nomeAzienda;
    }

    public String getpIva() {
        return pIva;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

}
