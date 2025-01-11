package unicam;

import java.util.ArrayList;
import java.util.List;

public class Pacchetto extends Item{
    private List<Prodotto> listaProdotti;

    public Pacchetto(float prezzo, String nomeItem, String descrizione, List<Prodotto> listaProdotti) {
        super(prezzo, nomeItem, descrizione);
        this.listaProdotti = listaProdotti;
    }

    public Pacchetto(float prezzo, String nomeItem, String descrizione,List<Prodotto> listaProdotti,int quantita) {
        super(prezzo, nomeItem, descrizione, quantita);
        this.listaProdotti = listaProdotti;
    }


    public List<Prodotto> getListaProdotti() {
        return listaProdotti;
    }

    public void setListaProdotti(List<Prodotto> listaProdotti) {
        if(listaProdotti == null)
            throw new NullPointerException("Lista prodotti null");
        this.listaProdotti = listaProdotti;
    }

    public void addProdotto(Prodotto prodotto){
        if(prodotto == null)
            throw new NullPointerException("Prodotto null");
        if(this.listaProdotti.contains(prodotto))
            throw new IllegalArgumentException("Prodotto già presente nel pacchetto");
        this.listaProdotti.add(prodotto);
    }
}