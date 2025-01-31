package unicam;

public class Invito {
    private AnimatoreFiliera animatoreFiliera;
    private Evento evento;
    private Azienda azienda;
    private boolean accettato;

    /**
     *
     * @param animatoreFiliera
     * @param evento
     * @param azienda
     */

    public Invito(AnimatoreFiliera animatoreFiliera, Evento evento, Azienda azienda) {
        this.animatoreFiliera = animatoreFiliera;
        this.evento = evento;
        this.azienda = azienda;
        this.accettato = false;
    }

    public AnimatoreFiliera getAnimatoreFiliera() {
        return animatoreFiliera;
    }

    public Evento getEvento() {
        return evento;
    }

    public Azienda getAzienda() {
        return azienda;
    }

    public boolean isAccettato() {
        return accettato;
    }

    public void setAccettato(boolean accettato) {
        this.accettato = accettato;
    }

    public void setAnimatoreFiliera(AnimatoreFiliera animatoreFiliera) {
        this.animatoreFiliera = animatoreFiliera;
    }

    public void setAzienda(Azienda azienda) {
        this.azienda = azienda;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}
