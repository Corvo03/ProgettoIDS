package unicam;

import java.util.ArrayList;
import java.util.List;

/**
 * SINGLETON
 * contiene tutti i profili della piattaforma
 */
public class SezioneProfili {
    private SezioneProfili istanzaSezioneProfili;
    private List<Profilo> listaProfili;


    public SezioneProfili() {
        listaProfili = new ArrayList<Profilo>();
    }

    public List<Profilo> getListaProfili() {
        return listaProfili;
    }

    public void addProfilo(Profilo profilo) {
        listaProfili.add(profilo);
    }
}
