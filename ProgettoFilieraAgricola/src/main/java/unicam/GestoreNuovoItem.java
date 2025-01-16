package unicam;

public class GestoreNuovoItem extends InformazioniDaApprovare{
    private Item nuovoItem;
    public GestoreNuovoItem(Item nuovoItem) {
        this.nuovoItem = nuovoItem;
    }
    public Item getNuovoItem() {
        return nuovoItem;
    }
}
