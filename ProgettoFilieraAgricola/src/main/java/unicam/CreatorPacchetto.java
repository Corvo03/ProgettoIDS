package unicam;

import java.util.ArrayList;
import java.util.List;

public class CreatorPacchetto extends ItemFactory{
    private List<Prodotto> listaProdotti;
    private Azienda aziendaProduttrice;


    /**
     * Permette di creare la classe che contiene la logica di creazione del Pacchetto.
     * I parametri necessari per al pacchetto devono essere passati nel costruttore.
     * @param nome del pacchetto.
     * @param descrizione del pacchetto.
     * @param prezzo del pacchetto.
     * @param listaProdotti che contenuti nel pacchetto.
     * @param azienda che crea il pacchetto.
     *
     * @throws NullPointerException se la lista è nulla
     */
    public CreatorPacchetto(String nome, String descrizione, double prezzo, List<Prodotto> listaProdotti, Azienda azienda) {
        super(nome, descrizione, prezzo);
        if (listaProdotti == null)
            throw new NullPointerException("lista item null");

        this.listaProdotti = listaProdotti;
        this.aziendaProduttrice = azienda;
    }

    public CreatorPacchetto(String nome, String descrizione, double prezzo, Azienda azienda) {
        super(nome, descrizione, prezzo);
        this.aziendaProduttrice = azienda;
        this.listaProdotti = new ArrayList<Prodotto>();
    }

    /**
     * Crea un Pacchetto a partire dalle informazioni ricevute nel costruttore
     * @return il Pacchetto creato.
     */
    @Override
    public Item createItem() {
        return new Pacchetto(prezzo, nome, descrizione, aziendaProduttrice, listaProdotti);
    }
}
