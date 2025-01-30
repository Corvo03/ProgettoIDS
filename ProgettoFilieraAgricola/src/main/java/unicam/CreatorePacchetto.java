package unicam;

import java.util.List;

public interface CreatorePacchetto {
    Pacchetto creaPacchetto(Float prezzo, String nome, String descrizione, List<Prodotto> listaProdotti);
}
