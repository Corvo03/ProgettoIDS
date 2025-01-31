package unicam;

import java.util.HashMap;
import java.util.Map;

public class Carrello {
    private Map<ElementoMarketplace, Integer> elementiCarrello;
    private float totalePrezzo;

    /**
     * istanzia la lista degli elementi nel carrello
     */
    public Carrello() {
        elementiCarrello = new HashMap<>();
    }

    /**
     * calcola totale del costo dei prodotti
     */
    public void calcolaTotalePrezzo() {
        for (ElementoMarketplace elemento : elementiCarrello.keySet()) {
            totalePrezzo += elemento.getStock().getItem().getPrezzo() * elementiCarrello.get(elemento);
        }
    }

    /**
     * svuota carrello e azzera totale
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
