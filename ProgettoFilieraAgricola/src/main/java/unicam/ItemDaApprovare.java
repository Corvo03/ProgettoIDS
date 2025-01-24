package unicam;

public class ItemDaApprovare extends InformazioniDaApprovare{
    private final Item item;

    public ItemDaApprovare(Item item) {
        this.item = item;
    }
    public Item getItem() {
        return item;
    }
}
