package unicam.modelli.gestori;

import unicam.modelli.elements.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Classe che permette la gestione degli Item rifiutati, questi possono essere modificati
 * e ripassati al curatore per essere verificati nuovamente.
 */
public class GestoreItemRifiutati {

    List<Item> itemRifiutati;
    public GestoreItemRifiutati() {
        this.itemRifiutati = new ArrayList<>();
    }


    public Item getItemByName(String nome){
        for(Item item : this.itemRifiutati){
            if(Objects.equals(item.getNomeItem(), nome))
                return item;
        }
        throw new IllegalArgumentException("Item non trovato");
    }

    /**
     * Modifica l'item rifiutato, in modo che possa essere poi approvato dal curatore.
     * @param item da modificare.
     * @param nome nuovo nome da dare all'item, se null rimane quello che c'è già.
     * @param descrizione nuova descrizione da dare all'item, se null rimane quella che c'è già.
     * @param prezzo nuovo prezzo da dare all'item, se minore di 0 rimane quello che c'è già.
     *
     * @throws NullPointerException se l'item passato è null
     * @throws IllegalArgumentException se l'item passato come parametro non è presente nella lista di item.
     */
    public void modificaItemRifiutato(Item item, String nome, String descrizione, float prezzo){
        if(item==null)
            throw new NullPointerException("Item non inserito");
        if(!this.itemRifiutati.contains(item))
            throw new IllegalArgumentException("Item non valido, non è presente nella lista di item rifiutati");
        if(!nome.isEmpty())
            item.setNomeItem(nome);
        if(!descrizione.isEmpty())
            item.setDescrizione(descrizione);
        if(prezzo>0)
            item.setPrezzo(prezzo);
    }

    /**
     * Aggiunge un item rifiutato alla lista di item rifiutati. Se già presente non viene aggiunto nuovamente.
     * @param item da inserire nella lista di item rifiutati.
     *
     * @throws NullPointerException se l'item inserito è null.
     */
    public void aggiungiItemRifiutato(Item item){
        if(item==null)
            throw new NullPointerException("Item non inserito");
        if(!this.itemRifiutati.contains(item))
            this.itemRifiutati.add(item);
    }
}
