package unicam;

import java.util.ArrayList;
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

    /**
     * mette l'invito nella lista degli inviti mandati
     * @param invito
     */
    private void addInvito(Invito invito) {
        this.listaInviti.add(invito);
    }

    //TODO prendere tutti gli inviti forse non dovremmo lasciarlo
    @Override
    public List<Invito> getListInviti() {
        return this.listaInviti;
    }

    //TODO lo facciamo metodo statico? perche azienda delega all'accettatore e passa già l' invito da rifiutare/accettare nei parametri
    /**
     * ricevo la lista inviti dell'azienda specifica
     * @param azienda
     * @return
     */
    public List<Invito> getListInvitiAzienda(Azienda azienda) {
        List<Invito> listaInviti = new ArrayList<Invito>();
        for(Invito invito : this.listaInviti) {
            if(invito.getPartecipanteEvento().equals(azienda)) {
                listaInviti.add(invito);
            }
        }
        return listaInviti;
    }

    public AccettatoreInvito getInvitato() {
        return invitato;
    }

    public MittenteInvito getInvitante() {
        return invitante;
    }

}