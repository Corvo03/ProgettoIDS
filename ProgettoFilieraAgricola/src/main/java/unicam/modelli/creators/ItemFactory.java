package unicam.modelli.creators;

import unicam.modelli.elements.Item;

/**
 * Classe astratta che rappresenta il Factory Method per la creazione di un Item.
 */
public abstract class ItemFactory {
    protected String nome;
    protected String descrizione;
    protected double prezzo;
    protected String id;

    /**
     * Costruttore del Factory dell'Item, permette di creare un Item a partire dagli elementi passati nel costruttore.
     * @param nome dell'Item
     * @param descrizione dell'Item
     * @param prezzo dell'Item
     *
     * @throws IllegalArgumentException se il prezzo, il nome o la descrizione non sono validi.
     */

    public ItemFactory(String id,String nome, String descrizione, double prezzo) {
        if (prezzo <= 0)
            throw new IllegalArgumentException("Prezzo non valido");
        if (nome == null || nome.isEmpty())
            throw new IllegalArgumentException("Nome prodotto non valido");
        if (descrizione == null || descrizione.isEmpty())
            throw new IllegalArgumentException("Descrizione non valida");
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.id = id;
    }
    /**
     * Permette di creare un Item a partire dagli elementi caricati nel costruttore.
     * @return l'Item creato.
     */
    public abstract Item createItem();
}
