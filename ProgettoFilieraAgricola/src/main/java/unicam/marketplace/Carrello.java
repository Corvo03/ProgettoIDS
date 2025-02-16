package unicam.marketplace;

import unicam.elements.ElementoMarketplace;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe che rappresenta il carrello dell'utente nel quale si possono inserire e rimuoere elementi del marketplace
 */
public class Carrello {
    private Map<ElementoMarketplace, Integer> elementiCarrello;
    private float totalePrezzo;

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

    public void aggiungiElementoAlCarrello(ElementoMarketplace elemento,int quantita){
        if (quantita > elemento.getStock().getQuantita() || quantita < 0)
            throw new IllegalArgumentException("Quantità non disponibile");
        elementiCarrello.put(elemento, quantita);
    }

    public void rimuoviElementoDalCarrello(ElementoMarketplace elemento, int quantita){
        if (quantita > elementiCarrello.get(elemento) || quantita < 0)
            throw new IllegalArgumentException("Quantità non disponibile");
        elementiCarrello.remove(elemento);
    }

    public Map<ElementoMarketplace, Integer> getElementiCarrello() {
        return elementiCarrello;
    }

    public float getTotalePrezzo() {
        return totalePrezzo;
    }
}
