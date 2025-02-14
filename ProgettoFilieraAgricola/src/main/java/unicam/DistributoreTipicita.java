package unicam;

import java.util.List;

public class DistributoreTipicita extends Azienda  {

    public DistributoreTipicita() {

    }

    /**
     * Crea un pacchetto con le seguenti caratteristiche:
     *
     * @param prezzo,        prezzo del pacchetto
     * @param nome,          nome del pacchetto
     * @param descrizione,   descrizione del pacchetto
     * @param listaProdotti, lista degli elementi del pacchetto
     * @return il pacchetto appena creato
     */

    public Pacchetto creaPacchetto(Float prezzo, String nome, String descrizione, List<Prodotto> listaProdotti) {


        Pacchetto pacchetto = new Pacchetto(prezzo, nome, descrizione, this, listaProdotti);
        //TODO farlo come metodo a parte? così che il distributore lo chiama quando vuole

        this.richiediVerificaInformazioni(pacchetto);
        return pacchetto;
    }

    public Prodotto creaProdotto(Float prezzo, String nome, String descrizione) {
        ItemFactory fact = new CreatorProdotto(nome, descrizione, prezzo, null, this);
        Prodotto prodotto = (Prodotto) fact.createItem();
        return prodotto;
    }

    public void aggiungiItemAPacchetto(Pacchetto pacchetto, Prodotto prodotto) {
        if (pacchetto == null)
            throw new NullPointerException("pacchetto null");
        if (prodotto == null)
            throw new NullPointerException("prodotto null");
        pacchetto.addProdotto(prodotto);
    }

    // TODO metodo per ottenere i propri pacchetti dal marketplace
    //TODO metodo per ottenere i propri prodotti dal marketplace

    public ElementoMarketplace getProdottoMarkeplace() {
        //TODO gestione responsabilità e gestione marketplace
        return null;
    }
}
