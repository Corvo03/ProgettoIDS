package unicam.modelli.elements;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

/**
 * Rappresenta un elemento del marketplace,
 * con all'interno uno stock di un tipo di item
 */
@Entity
public class ElementoMarketplace {
    @Id
    private String id;
    @OneToOne
    private Stock stock;

    /**
     * Crea un elementoMarketplace partendo dallo Stock passato
     * @param stock
     */
    public ElementoMarketplace(Stock stock) {
        this.stock = stock;
        this.id = stock.getId();
    }

    public ElementoMarketplace() {
    }

    public String getId() {
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
     * Decrementa la quantità disponibile dell'elemento di una Quantità inserita.
     * @param quantita, indica di quanto deve essere decrementata la quantità disponibile.
     *
     * @throws IllegalArgumentException se la quantità inserita o la nuova quantità calcolata è minore di 0.
     */
    public void decrementaQuantita(Integer quantita) {
        if(quantita < 0)
            throw new IllegalArgumentException("Quantità negativo");
        int newQuantita = this.getQuantitaDisponibile() - quantita;
        if(newQuantita < 0)
            throw new IllegalArgumentException("Si cerca di decrementare più di quanto è disponibile");
        this.stock.setQuantita(newQuantita);
    }

    public Item getItem() {
        return this.stock.getItem();
    }
}
