package unicam.inviti;

import java.util.ArrayList;
import java.util.List;

/**
 * gestore di inviti inviati dall'animatore
 */
public class GestoreInvitiInviati implements UtilizzatoreInviti {
    private Mediator mediator;
    private List<Invito> listaInvito;

    public GestoreInvitiInviati(Mediator mediator) {
        this.mediator = mediator;
        this.listaInvito = new ArrayList<Invito>();
    }

    /**
     * invia l'invito notificando il mediator e aggiungendolo alla lista di inviti inviati
     * @param invito
     */
    public void InviaInvito(Invito invito){
        this.listaInvito.add(invito);
        this.mediator.notify(invito, this);
    }

    /**
     * elimina un invito dalla lista di inviti mandati
     * @param invito
     */
    public void eliminaInvito(Invito invito) {
        if(!listaInvito.contains(invito)) throw new RuntimeException("Invito non trovato");
        this.listaInvito.remove(invito);
    }

    public List<Invito> getListaInvito() {
        return listaInvito;
    }
    public Mediator getMediator() {
        return mediator;
    }
}
