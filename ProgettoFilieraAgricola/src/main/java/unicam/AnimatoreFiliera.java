package unicam;

import java.util.List;

/**
 * contiene la lista degli eventi
 * si occupa di delegare le operazioni per
 * creare gli eventi, mandare inviti e mettere biglietti sul Market
 */
public class AnimatoreFiliera extends UtenteAutenticato {
    /**
     * lista di tutti gli eventi creati dall'animatore
     */
    private List<Evento> listaEventi;
    /**
     * il mittente realtivo a questo animatore
     */
    private GestoreStock gestoreStock;
    /**
     * il mittente realtivo a questo animatore
     */
    private MittenteInvito mittenteInvito;


    /**
     *
     * @param email
     * @param password
     * @param nomeUtente
     */
    public AnimatoreFiliera(String email, String password, String nomeUtente) {
        super(email, password, nomeUtente);
        this.mittenteInvito = new MittenteInvito();
    }


    public GestoreStock getGestoreStock() {
        return gestoreStock;
    }

    //TODO crea biglietto passando come parametro l'evento, il biglietto deve essere verificato
    //     il gestore info inserirà nello stock dell'animatore se approvato.
}
