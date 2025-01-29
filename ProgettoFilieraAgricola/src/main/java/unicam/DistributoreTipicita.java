package unicam;

import java.util.List;

public class DistributoreTipicita extends Azienda {
    private GestorePacchetto gestorePacchetto;
    public DistributoreTipicita() {
        this.gestorePacchetto = new GestorePacchetto();
    }

    /**
     * Crea un nuovo pacchetto che deve essere approvato dal curatore
     * @param prezzo, prezzo relativo al pacchetto
     * @param nomePacchetto, nome rappresentativo del pacchetto
     * @param descrizione, una descrizione associata al pacchetto,
     *                     che ne descriva le caratteristiche di tali abbinamenti.
     * @param listaItem, elementi interni al pacchetto
     * @return il pacchetto da approvare
     */
    public Pacchetto creaPacchetto(float prezzo, String nomePacchetto, String descrizione, List<Prodotto> listaItem) {
        Pacchetto pacchetto = this.gestorePacchetto.creaPacchetto(prezzo, nomePacchetto, descrizione, listaItem);
        creaItem(pacchetto);
        return pacchetto;
    }

    public Prodotto creaProdotto(float prezzo, String nomeProdotto, String descrizione ) {
        if (prezzo <= 0)
            throw new IllegalArgumentException("Prezzo non valido");
        if(nomeProdotto == null || nomeProdotto.isEmpty())
            throw new IllegalArgumentException("Nome prodotto non valido");
        if(descrizione == null || descrizione.isEmpty())
            throw new IllegalArgumentException("Descrizione non valida");
        Prodotto prodotto = new Prodotto(prezzo, nomeProdotto,descrizione, this );
        creaItem(prodotto);
        return prodotto;
    }

    public void aggiungiItemAPacchetto(Pacchetto pacchetto, Prodotto prodotto) {
        if (pacchetto == null)
            throw new NullPointerException("pacchetto null");
        if (prodotto == null)
            throw new NullPointerException("prodotto null");
        pacchetto.addProdotto(prodotto);
    }

    public void aggiungiItemAPacchetto(Prodotto prodotto) {
        if (prodotto == null)
            throw new NullPointerException("prodotto null");
        this.gestorePacchetto.addProdotto(prodotto);
    }

    public ElementoMarketplace getProdottoMarkeplace(){
        //TODO gestione responsabilità e gestione marketplace
        return null;
    }
}
