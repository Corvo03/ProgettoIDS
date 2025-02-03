package unicam;

/**
 * si occupa di accettare o rifiutare gli inviti
 */

public class AccettatoreInvito {
    private Mediator mediator;

    /**
     *
     */
    public AccettatoreInvito() {}

    /**
     * delega al mediator il rifiuto invito
     * @param invito
     */
    public void rifiutaInvito(Invito invito) {
        this.mediator.rifiutaInvito(invito);
    }

    /**
     * delega al mediator l'accettazione invito
     * @param invito
     */
    public void accettaInvito(Invito invito){
        this.mediator.accettaInvito(invito);
    }

    public Mediator getMediator() {return mediator;}
}
