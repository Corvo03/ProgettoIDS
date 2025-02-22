package unicam.modelli.actors.azienda;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import unicam.modelli.marketplace.InformazioneDaApprovare;
@Entity
public class InformazioniSensibili implements InformazioneDaApprovare {
    @Id
    private String id;
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
