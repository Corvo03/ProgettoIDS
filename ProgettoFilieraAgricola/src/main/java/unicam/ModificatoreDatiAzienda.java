package unicam;

public class ModificatoreDatiAzienda extends InformazioneDaApprovare {
    private String nomeAzienda;
    private String pIva;
    private String sedeLegale;
    private String pec;
    private String codiceFiscale;

    public ModificatoreDatiAzienda(String nomeAzienda, String pIva, String sedeLegale, String pec, String codiceFiscale) {
        this.nomeAzienda = nomeAzienda;
        this.pIva = pIva;
        this.sedeLegale = sedeLegale;
        this.pec = pec;
        this.codiceFiscale = codiceFiscale;
    }

    public String getNomeAzienda() {
        return nomeAzienda;
    }

    public String getpIva() {
        return pIva;
    }

    public String getSedeLegale() {
        return sedeLegale;
    }

    public String getPec() {
        return pec;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setNomeAzienda(String nomeAzienda) {
        this.nomeAzienda = nomeAzienda;
    }

    public void setpIva(String pIva) {
        this.pIva = pIva;
    }

    public void setSedeLegale(String sedeLegale) {
        this.sedeLegale = sedeLegale;
    }

    public void setPec(String pec) {
        this.pec = pec;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }
}
