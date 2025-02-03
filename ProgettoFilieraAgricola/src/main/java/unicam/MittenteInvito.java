package unicam;

import java.util.Date;

/**
 * classe che si occupa di invitare i partecipanti
 */
public class MittenteInvito {
    /**
     * usa il Mediator
     */
    Mediator mediator;

    /**
     *
     * @param mediator
     */
    public MittenteInvito(Mediator mediator) {
        this.mediator = mediator;
    }

    /**
     * crea l'invito e lo manda al mediator
     * @param evento
     * @param partecipante
     * @param dataCreazione
     * @param dataScadenza
     */
    public void inviaInvito(AnimatoreFiliera animatoreFiliera,Evento evento, PartecipanteEvento partecipante, Date dataCreazione, Date dataScadenza) {
        Invito invito = new Invito(animatoreFiliera,evento,partecipante,dataCreazione,dataScadenza);
        mediator.inviaInvito(invito);
    }
    public Mediator getMediator() {
        return mediator;
    }
}