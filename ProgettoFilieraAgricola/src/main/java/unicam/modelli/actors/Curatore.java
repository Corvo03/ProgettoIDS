package unicam.modelli.actors;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import unicam.modelli.gestori.GestoreInformazioni;
import unicam.modelli.marketplace.InformazioneDaApprovare;
@Entity
public class Curatore extends UtenteAutenticato {
    @Id
    private String id;
    public Curatore(String id, String nomeUtente, String mail){
        super(mail, nomeUtente);
        this.id = id;
    }

    public Curatore() {
    }

    public void approvaInformazione(InformazioneDaApprovare informazione) {
        GestoreInformazioni.getInstance().informazioneApprovata(informazione);
    }

    public void rifiutaInformazione(InformazioneDaApprovare informazione) {
        GestoreInformazioni.getInstance().informazioneRifiutata(informazione);
    }

    public Object getId() {
        return id;
    }
}
