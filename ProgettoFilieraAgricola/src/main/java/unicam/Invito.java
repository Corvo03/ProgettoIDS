package unicam;
import java.util.Date;

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
    private Date dataCreazione;
    /**
     * data scadenza
     */
    private Date dataScadenza;

    /**
     *
     * @param organizzatoreEvento
     * @param evento
     * @param partecipanteEvento
     * @param dataCreazione
     * @param dataScadenza
     */
    public Invito(AnimatoreFiliera organizzatoreEvento, Evento evento, PartecipanteEvento partecipanteEvento,
                  Date dataCreazione, Date dataScadenza) {
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

    public Date getDataScadenza() {
        return dataScadenza;
    }

    public Date getDataCreazione() {
        return dataCreazione;
    }

    public AnimatoreFiliera getAnimatoreFiliera() {
        return animatoreFiliera;
    }
}
