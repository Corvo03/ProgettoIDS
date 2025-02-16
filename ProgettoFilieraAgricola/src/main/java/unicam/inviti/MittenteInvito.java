package unicam.inviti;

import unicam.actors.AnimatoreFiliera;

import java.time.LocalDate;

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
    public void inviaInvito(AnimatoreFiliera animatoreFiliera, Evento evento, PartecipanteEvento partecipante, LocalDate dataCreazione, LocalDate dataScadenza) {
        Invito invito = new Invito(animatoreFiliera,evento,partecipante,dataCreazione,dataScadenza);
        mediator.inviaInvito(invito);
    }
    public void riceviRisposta(Invito invito, boolean risposta) {
        if(risposta) {
            aggiungiPartecpante(invito.getPartecipanteEvento(), invito.getEvento());
        }else {

        }
    }
    private void aggiungiPartecpante(PartecipanteEvento partecipante, Evento evento) {
        evento.addPartecipante(partecipante);
    }

    public Mediator getMediator() {
        return mediator;
    }
}