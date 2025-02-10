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
     */
    public MittenteInvito() {}

    /**
     * crea l'invito e lo manda al mediator
     * @param evento
     * @param partecipante
     * @param dataCreazione
     * @param dataScadenza
     */
    //todo qua ho messo tutta la roba che sta nel costruttore invito
    public void inviaInvito(AnimatoreFiliera animatoreFiliera,Evento evento, PartecipanteEvento partecipante, Date dataCreazione, Date dataScadenza) {
        Invito invito = new Invito(animatoreFiliera,evento,partecipante,dataCreazione,dataScadenza);
        mediator.inviaInvito(invito);
    }
    public Mediator getMediator() {
        return mediator;
    }
}