package unicam.modelli.elements;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import unicam.modelli.actors.azienda.Azienda;

import java.util.ArrayList;
import java.util.List;

public class Pacchetto extends Item {
    private Azienda aziendaProduttrice;
    private List<Prodotto> listaProdotti;


    /**
     * Crea un pacchetto con un una lista di prodotti già al suo interno.
     *
     * @param id
     * @param prezzo        complessivo del pacchetto.
     * @param nomePacchetto nome dato al pacchetto.
     * @param descrizione   del pacchetto.
     * @param azienda       che ha composto il pacchetto.
     * @param listaProdotti da inserire nel pacchetto.
     * @throws NullPointerException se la lista di prodotti è vuota.
     */
    public Pacchetto(String id, double prezzo, String nomePacchetto, String descrizione, Azienda azienda, List<Prodotto> listaProdotti) {
        super(id, prezzo, nomePacchetto, descrizione);
        if(listaProdotti.isEmpty())
            throw new NullPointerException("La lista dei prodotti è vuota");
        this.listaProdotti = listaProdotti;
        this.aziendaProduttrice = azienda;
    }

    /**
     * Crea un pacchetto con Lista di prodotti vuota.
     * @param prezzo complessivo del pacchetto.
     * @param nomePacchetto nome dato al pacchetto.
     * @param descrizione del pacchetto.
     * @param azienda che ha composto il pacchetto.
     */
    public Pacchetto(String id, double prezzo, String nomePacchetto, String descrizione, Azienda azienda) {
        super(id, prezzo, nomePacchetto, descrizione);
        this.listaProdotti = new ArrayList<>();
        this.aziendaProduttrice = azienda;
    }

    public Pacchetto() {}

    /**
     * Ritorna la lista di prodotti del pacchetto.
     * @return la lista di prodotti del pacchetto.
     */
    public List<Prodotto> getListaProdotti() {
        return listaProdotti;
    }

    /**
     * Permette di aggiungere una lista di prodotti al pacchetto.
     * @param listaProdotti da aggiungere.
     */
    public void addListaProdotti(List<Prodotto> listaProdotti) {
        if(listaProdotti == null)
            throw new NullPointerException("Lista prodotti null");
        this.listaProdotti.addAll(listaProdotti);
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

    public Azienda getAziendaProduttrice() {
        return aziendaProduttrice;
    }
}