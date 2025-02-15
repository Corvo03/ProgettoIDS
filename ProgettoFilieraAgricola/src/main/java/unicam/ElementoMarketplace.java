package unicam;

public class ElementoMarketplace {

    private final int id;
    private final Stock stock;

    public ElementoMarketplace(int id, Stock stock) {
        this.id = id;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public Stock getStock() {
        return this.stock;
    }

    /**
     * @return la quantità disponibile dell'elemento.
     */
    public int getQuantitaDisponibile(){
        return this.getStock().getQuantita();
    }

    /**
     * Decrementa la quantità disponibile dell'elemento di una Quantita inserita.
     * @param quantita, indica di quanto deve essere decrementata la quantita disponibile.
     *
     * @throws IllegalArgumentException se la quantita inserita o la nuova quantità calcolata è minore di 0.
     */
    public void DecrementaQuantita(Integer quantita) {
        if(quantita < 0)
            throw new IllegalArgumentException("Quantita negativo");
        int newQuantita = this.getQuantitaDisponibile() - quantita;
        if(newQuantita < 0)
            throw new IllegalArgumentException("Si cerca di decrementare più di quanto è disponibile");
        this.stock.setQuantita(newQuantita);
    }
}
