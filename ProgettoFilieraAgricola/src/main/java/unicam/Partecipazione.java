package unicam;

import java.util.ArrayList;
public class Partecipazione {

    private Azienda aziendaChePartecipa;

    /**
     * setta l'azienda che ha accettato l'invito e che parteciperà all'evento
     * @param aziendaChePartecipa
     */
    public Partecipazione(Azienda aziendaChePartecipa) {
        this.aziendaChePartecipa = aziendaChePartecipa;
    }

    public Azienda getAziendaChePartecipa() {
        return aziendaChePartecipa;
    }
}
