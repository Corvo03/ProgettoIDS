package unicam;

import java.util.ArrayList;
import java.util.List;

public class Pacchetto extends Item{
    private List<Prodotto> listaProdotti;

    public Pacchetto(float prezzo, String nomeItem, String descrizione, Azienda azienda, List<Prodotto> listaProdotti) {
        super(prezzo, nomeItem, descrizione);
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

    /**
     * Permette di aggiungere un Prodotto al pacchetto (già esistente)
     *
     * @param prodotto da aggiungere al pacchetto
     *
     * @throws NullPointerException se il prodotto è null
     * @throws IllegalArgumentException se il prodotto è già presente nel pacchetto
     */
    public void addProdotto(Prodotto prodotto){
        if(prodotto == null)
            throw new NullPointerException("Prodotto null");
        if(this.listaProdotti.contains(prodotto))
            throw new IllegalArgumentException("Prodotto già presente nel pacchetto");
        this.listaProdotti.add(prodotto);
    }
}