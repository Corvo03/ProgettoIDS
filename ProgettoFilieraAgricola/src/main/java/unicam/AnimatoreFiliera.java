package unicam;

import java.util.List;

public class AnimatoreFiliera extends UtenteAutenticato {
    private List<Evento> listaEventi;
    private GestoreStock gestoreStock;

    public AnimatoreFiliera(String email, String password, String nomeUtente) {
        super(email, password, nomeUtente);
    }

    public GestoreStock getGestoreStock() {
        return gestoreStock;
    }

    //TODO crea biglietto passando come parametro l'evento, il biglietto deve essere verificato
    //     il gestore info inserirà nello stock dell'animatore se approvato.
}
