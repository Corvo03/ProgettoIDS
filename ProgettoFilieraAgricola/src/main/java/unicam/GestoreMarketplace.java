package unicam;


public class GestoreMarketplace {
    public Marketplace marketplace;
    public GestoreMarketplace() {
        this.marketplace = new Marketplace();
    }
    public Marketplace getMarketplace() {
        return marketplace;
    }
    private int getNextId (){
        return this.marketplace.getMaxId();
    }
    public void addElementoMarketplace(Stock stock, int quantitaDaAggiungere){
        int id = this.getNextId();
        for(int i = id+1; i<=id + quantitaDaAggiungere; i++) {
            marketplace.addElementoMarketplace(new ElementoMarketplace(i, stock));
        }
    }

    public void addElementoMarketplace(ElementoMarketplace elementoMarketplace) {
        this.marketplace.addElementoMarketplace(elementoMarketplace);
    }
}