package unicam;

import java.util.Date;

    public class Biglietto extends Item{
    private AnimatoreFiliera animatore;
    private Evento evento;

        /**
         *
         * @param prezzo
         * @param nomeItem
         * @param descrizione
         * @param animatore
         * @param evento
         */
        public Biglietto(float prezzo, String nomeItem, String descrizione, AnimatoreFiliera animatore, Evento evento) {
            super(prezzo, nomeItem, descrizione);
            this.animatore = animatore;
            this.evento = evento;
        }

        public AnimatoreFiliera getAnimatore() {
            return animatore;
        }

        public Evento getEvento() {
            return evento;
        }
    }
