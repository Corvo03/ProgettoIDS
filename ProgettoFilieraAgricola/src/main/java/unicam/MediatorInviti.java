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


    /**
     *
     * @param listaInviti
     * @param invitato
     * @param invitante
     */
    public MediatorInviti(List<Invito> listaInviti, AccettatoreInvito invitato, MittenteInvito invitante) {
        this.listaInviti = listaInviti;
        this.invitato = invitato;
        this.invitante = invitante;
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
     * Metodo chiamato da AccettatoreInvito per accettare invito
     * @param invito
     */
    public void accettaInvito(Invito invito) {
        invito.getEvento().addPartecipante(invito.getPartecipanteEvento());
    }

    /**
     * Mette l'invito nella lista degli inviti mandati
     * @param invito
     */
    private void addInvito(Invito invito) {
        this.listaInviti.add(invito);
    }

    /**
     * Ritorna la lista inviti dell'azienda specifica
     * @param azienda, azienda di cui si vuole ottenere la lista degli Inviti.
     * @return la lista degli inviti dell'Azienda.
     */
    public List<Invito> getListInviti(Azienda azienda) {
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