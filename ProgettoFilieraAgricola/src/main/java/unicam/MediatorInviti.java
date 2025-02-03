package unicam;

import java.util.List;

/**
 * mediatore tra Mittente e Ricevente (AccettatoreInviti) e con
 */
public class MediatorInviti implements Mediator {
    /**
     * lista di tutti gli inviti creati dal Mittente
     */
    private List<Invito> listaInviti;
    private AccettatoreInvito invitato;
    private MittenteInvito invitante;
    private AggiungiPartecipanteEvento aggiungiPartecipanteEvento;

    /**
     *
     * @param listaInviti
     * @param invitato
     * @param invitante
     * @param aggiungiPartecipanteEvento
     */
    public MediatorInviti(List<Invito> listaInviti, AccettatoreInvito invitato, MittenteInvito invitante,
                          AggiungiPartecipanteEvento aggiungiPartecipanteEvento) {
        this.listaInviti = listaInviti;
        this.invitato = invitato;
        this.invitante = invitante;
        this.aggiungiPartecipanteEvento = aggiungiPartecipanteEvento;
    }

    @Override
    /**
     * invia l'invito all'AccettatoreInvito
     */
    public void inviaInvito(Invito invito) {
        addInvito(invito);
    }

    /**
     * metodo chiamato da AccettatoreInvito per rifiutare invito
     * @param invito
     */
    public void rifiutaInvito(Invito invito) {
        this.listaInviti.remove(invito);
    }

    /**
     * metodo chiamato da AccettatoreInvito per accettare invito
     * @param invito
     */
    public void accettaInvito(Invito invito) {
        //TODO aggiungiPartecipanteEvento.add(invito.getPartecipante());
    }

    private void addInvito(Invito invito) {
        this.listaInviti.add(invito);
    }


    @Override
    public List<Invito> getListInviti() {
        return this.listaInviti;
    }

    public AccettatoreInvito getInvitato() {
        return invitato;
    }

    public MittenteInvito getInvitante() {
        return invitante;
    }

}