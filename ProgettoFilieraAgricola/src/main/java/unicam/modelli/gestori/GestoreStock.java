package unicam.modelli.gestori;

import unicam.modelli.elements.Item;
import unicam.modelli.elements.Stock;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GestoreStock{
    private final List<Stock> listaStock;

    public GestoreStock() {
        listaStock = new ArrayList<Stock>();
    }

    /**
     * Ritorna la lista di Stock del gestore
     * @return la lista di stock.
     */
    public List<Stock> getListaStock() {
        return listaStock;
    }

    /**
     * Aggiunge uno stock alla lista degli Stock.
     * @param item item da aggiungere allo stock
     *
     * @throws NullPointerException se lo stock è nullo.
     * @throws IllegalArgumentException se lo stock non è presente nella lista.
     */
    public void aggiungiStock(Item item) {
        if(item == null)
            throw new NullPointerException("Stock nullo");
        Stock stock = new Stock(item);
        if (this.contains(stock))
            throw new IllegalArgumentException("Stock non presente");
        listaStock.add(stock);
        GestoreSistema.getInstance().creaElementoMarketPlace(stock);
        stock.setId(item.getId());
    }

    /**
     * Ricarica uno stock presente della quantità indicata.
     * @param stock da ricaricare.
     * @param quantita da aggiungere alla quantità attuale.
     */
    public void ricaricaProdotto(Stock stock, int quantita) {
        stock.addQuantita(quantita);
    }

    /**
     * Dato il nome dell'Item ritorna lo stock relativo. Se non è presente ritorna null.
     * @param id, id dell'Item dello Stock da ricercare.
     * @return Stock se trovato, null altrimenti.
     */
    public Stock getStock(String id){
        for (Stock stock : listaStock) {
            if(Objects.equals(stock.getId(), id))
                return stock;
        }
        return null;
    }

    /**
     * Ritorna true se lo stock passato come parametro è presente nella lista di stock del gestore.
     * False altrimenti.
     * @param stock da controllare se è presente nella lista.
     * @return true se lo stock è presente nella lista, false altrimenti.
     *
     * @throws NullPointerException se lo stock è nullo.
     */
    public boolean contains(Stock stock) {
        if (stock == null)
            throw new NullPointerException("Stock non valido");
        return listaStock.contains(stock);
    }

    /**
     * Elimina lo stock selezionato dalla lista degli stock.
     * Questo viene eliminato anche dal marketplace.
     * @param stock da eliminare.
     */
    public void eliminaStock(Stock stock) {
        GestoreSistema.getInstance().eliminaElementoMarketplace(stock);
        listaStock.remove(stock);
    }

    /**
     * ritorna la lista di tutti gli item nel gestore stock
     *
     * @return
     */
    public List<Item> toListaItem() {
        List<Item> listaItem = new ArrayList<>();
        for (Stock stock : listaStock) {
            listaItem.add(stock.getItem());
        }
        return listaItem;
    }

    public Item getItem(String nome){
        return getStock(nome).getItem();
    }
}