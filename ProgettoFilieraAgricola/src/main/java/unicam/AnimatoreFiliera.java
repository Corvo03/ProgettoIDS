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
}
