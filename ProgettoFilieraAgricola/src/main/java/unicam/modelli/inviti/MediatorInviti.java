package unicam.modelli.inviti;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * SINGLETON
 * mediatore tra gestore invitiInviati, GestoreInvitiRicevuti e GestoreEsitoInvito
 * (AnimatoreFiliera, Azienda ed Evento)
 */
public class MediatorInviti implements Mediator {
    private GestoreEsitoInvito gestoreEsitoInvito;
    private static MediatorInviti instance;
    private MediatorInviti() {
        gestoreEsitoInvito = new GestoreEsitoInvito();
    }


    public static MediatorInviti getInstance() {
        if (instance == null) {
            instance = new MediatorInviti();
        }
        return instance;
    }

    /**
     * invita il partecipante specificato dall'invito
     * @param invito
     */
    public void inviaInvito(Invito invito){
        invito.getPartecipanteEvento().getGestoreInvitiRicevuti().addInvito(invito);
    }
    public void accettaInvito(Invito invito){
        invito.getPartecipanteEvento().getGestoreInvitiRicevuti().accettaInvito(invito);
    }
    public void rifiutaInvito(Invito invito){
        invito.getPartecipanteEvento().getGestoreInvitiRicevuti().rifiutaInvito(invito);
    }

    /**
     * notifica il componente del mediator che deve ricevere la risposta in base al constesto
     * @param invito
     * @param sender
     */
    public void notify(Invito invito, UtilizzatoreInviti sender){
        if(invito.isAccettato() && sender instanceof GestoreInvitiRicevuti){
            this.gestoreEsitoInvito.gestisciInvitoAccettato(invito);
        }
        if(!invito.isAccettato() && sender instanceof GestoreInvitiRicevuti){
            this.gestoreEsitoInvito.gestisciInvitoRifiutato(invito);
        }
        if(sender instanceof GestoreInvitiInviati){
            inviaInvito(invito);
        }

    }
}
