package unicam.modelli.elements;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Stock {
    @Id
    private String Id;
    @OneToOne
    private Item item;
    private int quantita;

    public Stock(Item item) {
        this.item = item;
        this.quantita = 0;
    }

    public Stock() {}

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

    public String getNomeItem() {
        return item.getNomeItem();
    }
}
