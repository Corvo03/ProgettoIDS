package unicam.modelli.inviti;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * gestore di inviti inviati dall'animatore
 */
public class GestoreInvitiInviati implements UtilizzatoreInviti {
    private Mediator mediator;
    private List<Invito> listaInvito;

    /**
     * costruttore del gestore di inviti inviati
     * @param mediator
     */
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

    /**
     *
     * @return la lista di inviti inviati, togliendo gli inviti scaduti.
     */
    public List<Invito> getListaInvito() {
        listaInvito.removeIf(invito -> !invito.getDataScadenza().isAfter(LocalDate.now()));
        return listaInvito;
    }

    public Mediator getMediator() {
        return mediator;
    }
}
