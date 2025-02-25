package unicam.modelli.creators;

import unicam.modelli.elements.Item;
import unicam.modelli.elements.Pacchetto;
import unicam.modelli.elements.Prodotto;
import unicam.modelli.actors.azienda.Azienda;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe che rappresenta la logica di creazione di un pacchetto.
 */

public class CreatorPacchetto extends ItemFactory {
    private List<Prodotto> listaProdotti;
    private Azienda aziendaProduttrice;

    /**
     * Permette di creare la classe che contiene la logica di creazione del Pacchetto.
     * I parametri necessari per al pacchetto devono essere passati nel costruttore.
     * Questo metodo crea un pacchetto con una lista di prodotti già definita.
     * @param nome del pacchetto.
     * @param descrizione del pacchetto.
     * @param prezzo del pacchetto.
     * @param listaProdotti che contenuti nel pacchetto.
     * @param azienda che crea il pacchetto.
     *
     * @throws NullPointerException se la lista è nulla
     */
    public CreatorPacchetto(String id, String nome, String descrizione, double prezzo, List<Prodotto> listaProdotti, Azienda azienda) {
        super(id, nome, descrizione, prezzo);
        if (listaProdotti == null)
            throw new NullPointerException("lista item null");
        this.id = id;
        this.listaProdotti = listaProdotti;
        this.aziendaProduttrice = azienda;
    }

    /**
     * Permette di creare la classe che contiene la logica di creazione del Pacchetto.
     * I parametri necessari per al pacchetto devono essere passati nel costruttore.
     * Questo metodo crea un pacchetto con una lista vuota.
     * @param nome del pacchetto.
     * @param descrizione del pacchetto.
     * @param prezzo del pacchetto.
     * @param azienda che crea il pacchetto.
     *
     * @throws NullPointerException se la lista è nulla
     */
    public CreatorPacchetto(String id, String nome, String descrizione, double prezzo, Azienda azienda) {
        super(id, nome, descrizione, prezzo);
        this.aziendaProduttrice = azienda;
        this.listaProdotti = new ArrayList<Prodotto>();
    }

    /**
     * Crea un Pacchetto a partire dalle informazioni ricevute nel costruttore
     * @return il Pacchetto creato.
     */
    @Override
    public Item createItem() {
        return new Pacchetto(id, prezzo, nome, descrizione, aziendaProduttrice, listaProdotti);
    }
}