package unicam.modelli.marketplace;

import unicam.modelli.elements.ElementoMarketplace;
import unicam.modelli.elements.Stock;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe che rappresenta il marketplace del sistema
 */
public class Marketplace {
    private final List<ElementoMarketplace> listaElementiMarketplace;

    public Marketplace() {
        this.listaElementiMarketplace = new ArrayList<>();
    }

    /**
     * Aggiunge un elemento al marketplace
     * @param elementoMarketplace
     */
    public void addElementoMarketplace(ElementoMarketplace elementoMarketplace) {
        this.listaElementiMarketplace.add(elementoMarketplace);
    }

    /**
     * Aggiunge una lista di elementi al marketplace
     * @param listaElementoMarketplace
     */
    public void addElementoMarketplace(List<ElementoMarketplace> listaElementoMarketplace) {
        this.listaElementiMarketplace.addAll(listaElementoMarketplace);
    }

    /**
     * Rimuove un elemento dal marketplace
     * @param elementoMarketplace
     */
    public void removeElementoMarketplace(ElementoMarketplace elementoMarketplace) {
        if (!this.listaElementiMarketplace.contains(elementoMarketplace)) {
            throw new IllegalArgumentException("Elemento non presente nel marketplace");
        }
        this.listaElementiMarketplace.remove(elementoMarketplace);
    }

    /**
     * Rimuove una lista di elementi dal marketplace
     * @param listaElementoMarketplace
     */
    public void removeElementoMarketplace(List<ElementoMarketplace> listaElementoMarketplace) {
        this.listaElementiMarketplace.removeAll(listaElementoMarketplace);
    }


    /**
     * Rimuove l'elemento dal marketplace che ha quel determinato stock.
     * @param stock contenuto dall'elementoMarketplace da eliminare.
     */
    public void eliminaElementoMarketplace(Stock stock) {
        listaElementiMarketplace.removeIf(e -> e.getStock().equals(stock));
    }

    public ElementoMarketplace getElementoMarketplaceDaId(String idElemento) {
        for (ElementoMarketplace elemento : listaElementiMarketplace) {
            if (elemento.getId().equals(idElemento))
                return elemento;
        }
        return null;
    }
    /**
     * Ritorna l'id massimo degli elementi del marketplace
     * @return id massimo degli elementi del marketplace
     */
    public int getMaxId() {
        return listaElementiMarketplace.size();
    }


    public List<ElementoMarketplace> getListaElementi() {
        return listaElementiMarketplace;
    }
    public List<ElementoMarketplace> getListaElementiMarketplace() {
        return listaElementiMarketplace;
    }

    /**
     * Ritorna la lista di tutti gli elementi disponibili nel marketplace, ovvero quelli con stock > 0
     *
     * @return lista di tutti gli elementi del marketplace
     */
    public List<ElementoMarketplace> getElementiDisponibiliMarketplace() {
        List<ElementoMarketplace> elementiDisponibili = new ArrayList<>();
        for (ElementoMarketplace e : listaElementiMarketplace) {
            if (e.getStock().getQuantita() != 0) {
                elementiDisponibili.add(e);
            }
        }
        return elementiDisponibili;
    }
}