package unicam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * mediatore tra Mittente e Ricevente (AccettatoreInviti) e con
 */
public class GestoreInviti implements Mediator {
    /**
     * lista di tutti gli inviti creati dal Mittente
     */
    private List<RiceventeInvito> riceventi;
    private List<MittenteInvito> mittenti;
    private HashMap<ChiaveTabellaInviti,MittenteInvito> invitiPendenti;

    /**
     * classe privata per creare una chiave univoca per la tabella di inviti Mittente-Ricevente
     */
    private class ChiaveTabellaInviti {
        private MittenteInvito mittente;
        private RiceventeInvito ricevente;
        public ChiaveTabellaInviti(MittenteInvito mittente, RiceventeInvito ricevente) {
            this.mittente = mittente;
            this.ricevente = ricevente;
        }

        public MittenteInvito getMittente() {
            return mittente;
        }

        public RiceventeInvito getRicevente() {
            return ricevente;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            ChiaveTabellaInviti that = (ChiaveTabellaInviti) o;
            return Objects.equals(mittente, that.mittente) && Objects.equals(ricevente, that.ricevente);
        }

        @Override
        public int hashCode() {
            return Objects.hash(mittente, ricevente);
        }
    }

    /**
     *
     *
     */
    public GestoreInviti(List<RiceventeInvito> riceventi, List<MittenteInvito> mittenti) {
        this.riceventi = riceventi;
        this.mittenti = mittenti;
    }


    @Override
    /**
     * invia l'invito al RiceventeInvito
     */
    public void inviaInvito(Invito invito) {
        invito.getPartecipanteEvento().getRiceventeInvito().getInvitiRicevuti().add(invito);
    }

    /**
     * il ricevente invia la risposta al mittente che la riceve
     * @param invito
     * @param risposta
     * @return
     */
    public boolean inviaRisposta(Invito invito, boolean risposta) {
        ChiaveTabellaInviti chiave = new ChiaveTabellaInviti (invito.getAnimatoreFiliera().getMittenteInvito(), invito.getPartecipanteEvento().getRiceventeInvito());
        if(invitiPendenti.containsKey(chiave)) {
            invitiPendenti.get(chiave).riceviRisposta(invito,risposta); //risposta all'invito valida: avviso il mittente
            invitiPendenti.remove(chiave);
            return risposta;
        }else throw new IllegalCallerException("La risposta non è stata mandata dal ricevente");
    }

    /**
     * permette di aggiungere al mediator un nuovo componente Mittente
     * @param mittente
     */
    public void Subscribe(MittenteInvito mittente) {
        this.mittenti.add(mittente);
    }
    /**
     * permette di aggiungere al mediator un nuovo componente RiceventeInvito
     * @param ricevente
     */
    public void Subscribe(RiceventeInvito ricevente) {
        this.riceventi.add(ricevente);
    }

    public List<MittenteInvito> getMittenti() {
        return mittenti;
    }

    public List<RiceventeInvito> getRiceventi() {
        return riceventi;
    }
}