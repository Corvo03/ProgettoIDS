package unicam.modelli.marketplace;

import jakarta.persistence.*;
import unicam.modelli.elements.ElementoMarketplace;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe che rappresenta il carrello dell'utente nel quale si possono inserire e rimuovere elementi del marketplace
 */

public class Carrello {
    private String id;
    private Map<ElementoMarketplace, Integer> elementiCarrello;
    private double totalePrezzo;

    public Carrello() {
        elementiCarrello = new HashMap<>();
    }

    /**
     * Calcola il totale del prezzo del carrello
     */
    public void calcolaTotalePrezzo() {
        for (ElementoMarketplace elemento : elementiCarrello.keySet()) {
            totalePrezzo += elemento.getStock().getItem().getPrezzo() * elementiCarrello.get(elemento);
        }
    }

    /**
     * Svuota il carrello
     */
    public void svuotaCarrello(){
        this.elementiCarrello.clear();
        this.totalePrezzo = 0;
    }

    /**
     * Aggiunge un elemento al carrello
     * @throws IllegalArgumentException se la quantità è maggiore di quella disponibile
     * @param elemento
     * @param quantita
     */
    public void aggiungiElementoAlCarrello(ElementoMarketplace elemento,int quantita){
        if (quantita > elemento.getStock().getQuantita() || quantita < 0)
            throw new IllegalArgumentException("Quantità non disponibile");
        elementiCarrello.put(elemento, quantita);
    }

    /**
     * Rimuove un elemento dal carrello
     * @throws IllegalArgumentException se la quantità è maggiore di quella disponibile
     * @throws IllegalArgumentException se l'elemento non è presente nel carrello
     * @param elemento
     * @param quantita
     */
    public void rimuoviElementoDalCarrello(ElementoMarketplace elemento, int quantita){
        if (!elementiCarrello.containsKey(elemento))
            throw new IllegalArgumentException("Elemento non presente nel carrello");
        if (quantita > elementiCarrello.get(elemento) || quantita < 0)
            throw new IllegalArgumentException("Quantità non disponibile");
        elementiCarrello.remove(elemento);
    }

    /**
     * Ritorna la mappa degli elementi presenti nel carrello
     *
     * @return mappa degli elementi presenti nel carrello
     */
    public Map<ElementoMarketplace, Integer> getElementiCarrello() {
        return elementiCarrello;
    }

    public double getTotalePrezzo() {
        return totalePrezzo;
    }
}
