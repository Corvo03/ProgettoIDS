package unicam;

import java.util.ArrayList;
import java.util.List;

public class GestoreStock {
    private final List<Stock> listaStock;

    public GestoreStock() {
        listaStock = new ArrayList<Stock>();
        //todo fare in modo che il marketplace e il gestoreMarketplace siano Singleton
    }

    public List<Stock> getListaStock() {
        return listaStock;
    }

    public void aggiungiStock(Stock stock) {
        listaStock.add(stock);
        GestoreMarketplace.getInstance().creaElementoMarketPlace(stock);
    }

    public void ricaricaProdotto(Stock stock, int quantita) {
        stock.addQuantita(quantita);
    }
}