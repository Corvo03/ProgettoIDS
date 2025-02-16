package unicam.actors;

import unicam.gestori.GestoreInformazioni;
import unicam.marketplace.InformazioneDaApprovare;

public class Curatore extends UtenteAutenticato {
    public Curatore(String nomeUtente, String mail){
        super(mail, nomeUtente);
    }

    public void approvaInformazione(InformazioneDaApprovare informazione) {
        GestoreInformazioni.getInstance().informazioneApprovata(informazione);
    }

    public void rifiutaInformazione(InformazioneDaApprovare informazione) {
        GestoreInformazioni.getInstance().informazioneRifiutata(informazione);
    }
}
