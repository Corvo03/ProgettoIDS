package unicam;

import java.util.List;

/**
 * Si occupa di accettare o rifiutare gli inviti
 */

public class RiceventeInvito {
    private Mediator mediator;
    private List<Invito> invitiRicevuti;

    /**
     *
     */
    public RiceventeInvito() {}

    /**
     * Delega al mediator il rifiuto invito
     * @param invito
     */
    public void rifiutaInvito(Invito invito) {
        this.invitiRicevuti.remove(invito);
        this.mediator.inviaRisposta(invito,true);
    }

    /**
     * Delega al mediator l'accettazione invito
     * @param invito
     */
    public void accettaInvito(Invito invito){
        this.invitiRicevuti.remove(invito);
        this.mediator.inviaRisposta(invito,true);
    }

    public Mediator getMediator() {return mediator;}

    public List<Invito> getInvitiRicevuti() {
        return invitiRicevuti;
    }
}
