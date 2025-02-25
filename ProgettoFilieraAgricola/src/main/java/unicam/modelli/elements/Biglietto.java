package unicam.modelli.elements;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import unicam.modelli.inviti.Evento;
import unicam.modelli.actors.AnimatoreFiliera;

/**
 * Biglietto per un evento
 */
@Entity
public class Biglietto extends Item {
    @OneToOne
    private AnimatoreFiliera animatore;
    @OneToOne
    private Evento evento;

    /**
     * Crea un biglietto
     * @param id
     * @param prezzo
     * @param nomeItem
     * @param descrizione
     * @param animatore
     * @param evento
     */
    public Biglietto(String id, double prezzo, String nomeItem, String descrizione, AnimatoreFiliera animatore, Evento evento) {
        super(id, prezzo, nomeItem, descrizione);
        this.animatore = animatore;
        this.evento = evento;
    }

    public Biglietto() {
        super();
    }

    public AnimatoreFiliera getAnimatore() {
        return animatore;
    }

    public Evento getEvento() {
        return evento;
    }
}
