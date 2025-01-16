package unicam;

import java.util.ArrayList;
import java.util.List;

public class GestoreStock {
    private final List<Stock> listaStock;
    private GestoreMarketplace gestoreMarketplace;

    public GestoreStock() {
        listaStock = new ArrayList<Stock>();
        //todo fare in modo che il marketplace e il gestoreMarketplace siano Singleton
        gestoreMarketplace = new GestoreMarketplace();
    }

    public List<Stock> getListaStock() {
        return listaStock;
    }

    public void aggiungiStock(Stock stock) {
        listaStock.add(stock);
    }

    public void aggiungiNuovoItem(Item item) {
        //todo gestore informazioni da approvare curatore
    }

    public void ricaricaProdotto(Stock stock, int quantita) {
        stock.addQuantita(quantita);
        gestoreMarketplace.addElementoMarketplace(stock, quantita);
    }
}