package unicam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Marketplace {
    private final List<ElementoMarketplace> listaElementiMarketplace;

    public Marketplace() {
        this.listaElementiMarketplace = new ArrayList<ElementoMarketplace>();
    }

    public List<ElementoMarketplace> getListaElementiMarketplace() {
        return listaElementiMarketplace;
    }

    public int getMaxId(){
        int maxId = 0;
        for (ElementoMarketplace elementoMarketplace : this.listaElementiMarketplace) {
            if (elementoMarketplace.getId()>maxId)
                maxId = elementoMarketplace.getId();
        }
        return maxId;
    }

    public void addElementoMarketplace(ElementoMarketplace elementoMarketplace) {
        this.listaElementiMarketplace.add(elementoMarketplace);
    }


    public void addElementoMarketplace(List<ElementoMarketplace> listaElementoMarketplace) {
        this.listaElementiMarketplace.addAll(listaElementoMarketplace);
    }

    public void removeElementoMarketplace(ElementoMarketplace elementoMarketplace) {
        this.listaElementiMarketplace.remove(elementoMarketplace);
    }

    public void removeElementoMarketplace(List<ElementoMarketplace> listaElementoMarketplace) {
        this.listaElementiMarketplace.removeAll(listaElementoMarketplace);
    }

    public List<ElementoMarketplace> getListaElementi() {
        return listaElementiMarketplace;
    }
}