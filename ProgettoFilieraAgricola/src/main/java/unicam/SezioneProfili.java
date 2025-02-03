package unicam;

import java.util.ArrayList;
import java.util.List;

/**
 * SINGLETON
 * contiene tutti i profili della piattaforma
 */
public class SezioneProfili {
    private static SezioneProfili istanzaSezioneProfili;
    private List<Profilo> listaProfili;


    private SezioneProfili() {
        listaProfili = new ArrayList<Profilo>();
    }

    public static SezioneProfili getInstance() {
        if(istanzaSezioneProfili == null) istanzaSezioneProfili = new SezioneProfili();
        return istanzaSezioneProfili;
    }

    public List<Profilo> getListaProfili() {
        return listaProfili;
    }
}
