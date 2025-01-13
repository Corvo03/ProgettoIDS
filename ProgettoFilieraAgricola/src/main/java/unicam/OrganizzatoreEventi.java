package unicam;

import java.util.ArrayList;
import java.util.List;

public class OrganizzatoreEventi extends UtenteAutenticato{
    private List<Evento> listaEventi;
    public OrganizzatoreEventi() {
        listaEventi = new ArrayList<Evento>();
    }

    /**
     * crea un evento
     */
    public void CreaEvento(){
        listaEventi.addLast(new Evento());
    }

    /**
     * aggiunge altri biglietti all'evento
     * @param evento
     */
    public void aggiungBiglietti(Evento evento){

    }

    /**
     * invita l'azienda passata ad un evento specifico e crea l'invito
     * @param azienda
     * @param evento
     * @return
     */
    public Invito invitaAzienda(Azienda azienda, Evento evento) {
        return new Invito(this,evento,azienda);
    }
}
