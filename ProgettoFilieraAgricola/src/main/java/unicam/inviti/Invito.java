package unicam.inviti;
import unicam.actors.AnimatoreFiliera;

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
    private PartecipanteEvento partecipanteEvento;
    /**
     * data creazione
     */
    private LocalDate dataCreazione;
    /**
     * data scadenza
     */
    private LocalDate dataScadenza;

    /**
     *
     * @param organizzatoreEvento
     * @param evento
     * @param partecipanteEvento
     * @param dataCreazione
     * @param dataScadenza
     */
    public Invito(AnimatoreFiliera organizzatoreEvento, Evento evento, PartecipanteEvento partecipanteEvento,
                  LocalDate dataCreazione, LocalDate dataScadenza) {
        this.animatoreFiliera = organizzatoreEvento ;
        this.evento = evento ;
        this.partecipanteEvento = partecipanteEvento;
        this.dataCreazione = dataCreazione ;
        this.dataScadenza = dataScadenza ;
    }

    public Evento getEvento() {
        return evento;
    }

    public PartecipanteEvento getPartecipanteEvento() {
        return partecipanteEvento;
    }

    public AnimatoreFiliera getOrganizzatoreEvento() {
        return animatoreFiliera;
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
}
