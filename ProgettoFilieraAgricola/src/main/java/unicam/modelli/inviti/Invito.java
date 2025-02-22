package unicam.modelli.inviti;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import unicam.modelli.actors.AnimatoreFiliera;
import unicam.modelli.actors.azienda.Azienda;

import java.time.LocalDate;

/**
 * L'invito concreto, con tutte le info necessarie non modificabili (occorre fare un invito nuovo)
 */

public class Invito {

    /**
     * animatore che ha creato invito
     */

    private AnimatoreFiliera animatoreFiliera;
    /**
     * evento a cui si riferisce
     */

    private Evento evento;
    /**
     * invitato
     */
    private Azienda partecipanteEvento;
    /**
     * data creazione
     */
    private LocalDate dataCreazione;
    /**
     * data scadenza
     */
    private LocalDate dataScadenza;
    private boolean accettato;
    private String messaggio;

    /**
     * Crea un nuovo invito. L'invito ha scadenza dopo due giorni della data della sua creazione.
     * @param organizzatoreEvento che crea l'invito.
     * @param evento a cui è rivolto l'invito.
     * @param partecipanteEvento invitato all'evento.
     * @param messaggio di invito all'evento.
     */
    public Invito(AnimatoreFiliera organizzatoreEvento, Evento evento, Azienda partecipanteEvento, String messaggio) {
        this.animatoreFiliera = organizzatoreEvento ;
        this.evento = evento ;
        this.partecipanteEvento = partecipanteEvento;
        this.dataCreazione = LocalDate.now() ;
        this.dataScadenza = LocalDate.now().plusDays(2) ;
        this.messaggio = messaggio ;
        this.accettato = false;
    }

    public Invito() {
    }

    public Evento getEvento() {
        return evento;
    }

    public Azienda getPartecipanteEvento() {
        return partecipanteEvento;
    }

    public LocalDate getDataScadenza() {
        return dataScadenza;
    }

    public LocalDate getDataCreazione() {
        return dataCreazione;
    }

    public AnimatoreFiliera getAnimatoreFiliera() {
        return animatoreFiliera;
    }

    public boolean isAccettato() {
        return accettato;
    }

    public String getMessaggio() {
        return messaggio;
    }

    public void setAccettato(boolean accettato) {
        this.accettato = accettato;
    }
}
