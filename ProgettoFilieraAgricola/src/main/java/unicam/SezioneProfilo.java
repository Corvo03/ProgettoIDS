package unicam;

import java.util.ArrayList;
import java.util.List;

public class SezioneProfilo {
    private List<Profilo> listaProfili = new ArrayList<>();

    public void aggiungiProfilo(Profilo profilo) {
        if (profilo == null) {
            throw new NullPointerException("profilo null");
        }
        listaProfili.add(profilo);
    }

    public List<Profilo> getListaProfili() {
        return listaProfili;
    }
}
