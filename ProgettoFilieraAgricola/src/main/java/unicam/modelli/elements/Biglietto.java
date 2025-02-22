package unicam.modelli.elements;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import unicam.modelli.inviti.Evento;
import unicam.modelli.actors.AnimatoreFiliera;

@Entity
public class Biglietto extends Item {
    @OneToOne
    private AnimatoreFiliera animatore;
    @OneToOne
    private Evento evento;

    public Biglietto(double prezzo, String nomeItem, String descrizione, AnimatoreFiliera animatore, Evento evento) {
        super(prezzo, nomeItem, descrizione);
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
