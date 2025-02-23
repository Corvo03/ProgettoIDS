package unicam.modelli.gestori;

import unicam.modelli.actors.azienda.Profilo;

import java.util.ArrayList;
import java.util.List;

/**
 * contiene tutti i profili della piattaforma
 */
public class SezioneProfili {
    private List<Profilo> listaProfili;

    public SezioneProfili() {
        listaProfili = new ArrayList<Profilo>();
    }

    public List<Profilo> getListaProfili() {
        return listaProfili;
    }

    public Profilo getProfilo(String id){
        for(Profilo profilo : listaProfili){
            if(profilo.getId().equals(id))
                return profilo;
        }
        return null;
    }

    public void addProfilo(Profilo profilo) {
        if(!listaProfili.contains(profilo))
            listaProfili.add(profilo);
    }
}
