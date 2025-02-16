package unicam.actors.azienda;

/**
 * Profilo dell'azienda nella sezione profili
 */
public class Profilo {
    /**
     * nome
     */
    private String nomeProfilo;
    /**
     * descrizione
     */
    private String descrizione;
    /**
     * azienda
     */
    private Azienda azienda;

    /**
     * @param nomeProfilo
     * @param descrizione
     * @param azienda
     */
    public Profilo(String nomeProfilo, String descrizione, Azienda azienda) {
        this.nomeProfilo = nomeProfilo;
        this.descrizione = descrizione;
        this.azienda = azienda;
    }

    public String getDescrizione() {
        return descrizione;
    }
    public String getNomeProfilo() {
        return nomeProfilo;
    }
    public Azienda getAzienda() {return azienda;}

    //TODO vedere se i setter vanno su una parte apposita per la modifica profilo
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    public void setNomeProfilo(String nomeProfilo) {
        this.nomeProfilo = nomeProfilo;
    }
    public void setAzienda(Azienda azienda) {this.azienda = azienda;}
}
