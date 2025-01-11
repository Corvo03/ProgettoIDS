package unicam;

import java.util.List;

public class DistributoreTipicita extends Azienda {
    public DistributoreTipicita() {
    }

    public Pacchetto creaPacchetto(float prezzo, String nomePacchetto, String descrizione, List<Prodotto> listaItem) {
        if (prezzo < 0)
            throw new IllegalArgumentException("prezzo non valido");
        if (nomePacchetto == null)
            throw new NullPointerException("nome pacchetto null");
        if (descrizione == null)
            throw new NullPointerException("descrizione null");
        if (listaItem == null)
            throw new NullPointerException("lista item null");

        Pacchetto pacchetto = new Pacchetto(prezzo, nomePacchetto, descrizione, listaItem);
        creaItem(pacchetto);
        return pacchetto;
    }

    public void aggiungiItemAPacchetto(Pacchetto pacchetto, Prodotto prodotto) {
        if (pacchetto == null)
            throw new NullPointerException("pacchetto null");
        if (prodotto == null)
            throw new NullPointerException("prodotto null");
        pacchetto.addProdotto(prodotto);
    }
}
