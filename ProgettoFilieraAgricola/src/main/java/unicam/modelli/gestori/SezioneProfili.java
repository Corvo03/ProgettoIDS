package unicam.modelli.gestori;

import unicam.modelli.actors.azienda.Profilo;

import java.util.ArrayList;
import java.util.List;

/**
 * contiene tutti i profili della piattaforma
 */
public class SezioneProfili {
    private List<Profilo> listaProfili;

    /**
     * costruttore, crea lsta profili vuota
     */
    public SezioneProfili() {
        listaProfili = new ArrayList<Profilo>();
    }

    public List<Profilo> getListaProfili() {
        return listaProfili;
    }

    /**
     * aggiunge un profilo alla lista
     * @param profilo
     */
    public void addProfilo(Profilo profilo) {
        if(!listaProfili.contains(profilo))
            listaProfili.add(profilo);
    }
    public Profilo getProfilo(String id){
        for(Profilo profilo : listaProfili){
            if(profilo.getId().equals(id))
                return profilo;
        }
        return null;
    }
}
