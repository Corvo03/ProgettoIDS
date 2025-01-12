package unicam;

public class ElementoMarketplace {
    private int id;
    private Item item;

    public ElementoMarketplace(int id, Item item) {
        this.id = id;
        this.item = item;
    }

    public int getId() {
        return id;
    }

    public Item getItem() {
        return item;
    }
}
