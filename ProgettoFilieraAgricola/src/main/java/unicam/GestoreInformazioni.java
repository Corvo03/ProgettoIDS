package unicam;

import java.util.ArrayList;
import java.util.List;

public class GestoreInformazioni {
    private static GestoreInformazioni istanza;
    private final List<InformazioneDaApprovare> listaInformazioniDaApprovare;

    private GestoreInformazioni() {
        listaInformazioniDaApprovare = new ArrayList<InformazioneDaApprovare>();
    }

    /**
     * Ritorna il puntatore all'istanza dell'oggetto (se esiste), altrimenti ne crea una nuova.
     * La classe è un Singleton, ne esiste una sola istanza.
     *
     * @return l'unica istanza della classe
     */
    public static GestoreInformazioni getInstance() {
        if(istanza == null)
            istanza = new GestoreInformazioni();
        return istanza;
    }


    /**
     * Metodo getter per la lista delle informazioni da approvare.
     * //TODO chi può/deve chiamare il metodo, come gestirlo?
     * @return la lista delle informazioni da approvare
     */
    public List<InformazioneDaApprovare> getListaInformazioniDaApprovare() {
        return listaInformazioniDaApprovare;
    }

    /**
     * Aggiungi un Informazione da Approvare alla lista degli elementi del gestore Informazioni
     * @param informazione di tipo InformazioneDaApprovare, rappresenta l'elemento (Item o Azienda) da
     *                     aggiungere alla lista del GestoreInformazioni.
     * @return //TODO
     *
     * @throws NullPointerException se l'elemento inserito è nullo
     * @throws IllegalArgumentException se l'informazione è già stata inserita //TODO maniera ottimale per gestirla?
     */
    public void aggiungiInformazioneDaApprovare(InformazioneDaApprovare informazione) {
        if(informazione == null)
            throw new NullPointerException("informazione null");
        if(listaInformazioniDaApprovare.contains(informazione))
            //TODO cosa succede se l'elemento è già presente? un return secco?
            throw new IllegalArgumentException("informazione duplicate");
        listaInformazioniDaApprovare.add(informazione);
    }
}
