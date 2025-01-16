package unicam;

import static unicam.Main.marketplace;

public class Stock {
    private int quantita;
    private final Item item;

    public Stock(int quantita, Item item) {
        this.quantita = quantita;
        this.item = item;
    }

    public Stock(Item item) {
        this.quantita = 0;
        this.item = item;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        if (quantita < 0)
            quantita = 0;
        this.quantita = quantita;
    }

    /**
     * Permette di aggiungere quantità dell'item
     * @param quantita, intero che rappresenta la quantità da aggiungere
     *
     * @throws IllegalArgumentException se quantità è minore di 0
     * @return la quantità aggiunta.
     *
     */
    public int addQuantita(int quantita) {
        if (quantita < 0)
            throw new IllegalArgumentException("Quantita negativo");
        setQuantita(getQuantita() + quantita);
        return quantita;
    }

    public Item getItem() {
        return item;
    }
}
