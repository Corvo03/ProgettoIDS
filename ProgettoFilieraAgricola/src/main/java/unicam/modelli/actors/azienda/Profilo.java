package unicam.modelli.actors.azienda;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

/**
 * Profilo dell'azienda nella sezione profili
 */
@Entity
public class Profilo {
    @Id
    private String id;
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
    @OneToOne
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
        this.id = azienda.getId();
    }

    public Profilo() {

    }

    public String getDescrizione() {
        return descrizione;
    }
    public String getNomeProfilo() {
        return nomeProfilo;
    }
    public Azienda getAzienda() {return azienda;}

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    public void setNomeProfilo(String nomeProfilo) {
        this.nomeProfilo = nomeProfilo;
    }
    public void setAzienda(Azienda azienda) {this.azienda = azienda;}

    public String getId() {
        return id;
    }
}
