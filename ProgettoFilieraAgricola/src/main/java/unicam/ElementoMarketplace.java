package unicam;

public class ElementoMarketplace {

    private int id;
    private Stock stock;

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
