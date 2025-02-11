package unicam;

import java.util.List;

/**
 * Si occupa di accettare o rifiutare gli inviti
 */

public class AccettatoreInvito {
    private Mediator mediator;

    /**
     *
     */
    public AccettatoreInvito() {}

    /**
     * Delega al mediator il rifiuto invito
     * @param invito
     */
    public void rifiutaInvito(Invito invito) {
        this.mediator.rifiutaInvito(invito);
    }

    /**
     * Delega al mediator l'accettazione invito
     * @param invito
     */
    public void accettaInvito(Invito invito){
        this.mediator.accettaInvito(invito);
    }

    public Mediator getMediator() {return mediator;}

    public List<Invito> getListInvitiAzienda(Azienda azienda){
        return mediator.getListInviti(azienda);
    }
}
