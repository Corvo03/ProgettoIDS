package unicam;

public class Stock {
    private int quantita;

    public Stock(int quantita) {
        this.quantita = quantita;
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
     * @return la quantità aggiunta.
     */
    public int addQuantita(int quantita) {
        setQuantita(getQuantita() + quantita);
        return quantita;
    }
}
