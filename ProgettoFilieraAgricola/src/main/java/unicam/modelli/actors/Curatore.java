package unicam.modelli.actors;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import unicam.modelli.gestori.GestoreInformazioni;
import unicam.modelli.marketplace.InformazioneDaApprovare;
/**
 * Classe che rappresenta un curatore
 */
@Entity
public class Curatore extends UtenteAutenticato {
    @Id
    private String id;

    /**
     * Crea un curatore con una determinata mail e nomeUtente
     * @param id
     * @param nomeUtente
     * @param mail
     */
    public Curatore(String id, String nomeUtente, String mail){
        super(id,mail, nomeUtente);
        this.id = id;
    }

    public Curatore() {
    }

    /**
     * Approva un'informazione
     * @param informazione
     */
    public void approvaInformazione(InformazioneDaApprovare informazione) {
        GestoreInformazioni.getInstance().informazioneApprovata(informazione);
    }

    /**
     * Rifiuta un'informazione
     * @param informazione
     */
    public void rifiutaInformazione(InformazioneDaApprovare informazione) {
        GestoreInformazioni.getInstance().informazioneRifiutata(informazione);
    }

}
