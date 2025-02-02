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
}
