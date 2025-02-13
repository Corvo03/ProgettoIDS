package unicam;

public class CreatorBiglietto extends ItemFactory {
    private AnimatoreFiliera animatoreFiliera;
    private Evento evento;

    /**
     * Permette di creare la classe che contiene la logica di creazione del biglietto.
     * I parametri necessari per il biglietto gli devono essere passati al costruttore.
     * @param nome del biglietto.
     * @param descrizione del biglietto.
     * @param prezzo del biglietto.
     * @param animatoreFiliera che crea il biglietto.
     * @param evento relativo al biglietto.
     *
     * @throws NullPointerException se l'Evento o l'Animatore non sono validi (cioè se sono null).
     */
    public CreatorBiglietto(String nome, String descrizione, Float prezzo, AnimatoreFiliera animatoreFiliera, Evento evento) {
        super(nome, descrizione, prezzo);
        if (animatoreFiliera == null) {
            throw new NullPointerException("animatoreFiliera");
        }
        this.animatoreFiliera = animatoreFiliera;
        if (evento == null) {
            throw new NullPointerException("evento");
        }
        this.evento = evento;

    }

    /**
     * Crea un Biglietto a partire dalle informazioni ricevute nel costruttore
     * @return il Biglietto creato.
     */
    @Override
    public Item createItem() {
        return new Biglietto(prezzo, nome, descrizione, animatoreFiliera, evento);
    }
}