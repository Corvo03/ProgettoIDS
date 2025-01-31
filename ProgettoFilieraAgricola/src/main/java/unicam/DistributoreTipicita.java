package unicam;

import java.util.List;

public class DistributoreTipicita extends Azienda implements CreatoreProdotto, CreatorePacchetto {

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
    @Override
    public Pacchetto creaPacchetto(Float prezzo, String nome, String descrizione, List<Prodotto> listaProdotti) {
        if (prezzo <= 0)
            throw new IllegalArgumentException("prezzo non valido");
        if (nome == null)
            throw new NullPointerException("nome pacchetto null");
        if (descrizione == null)
            throw new NullPointerException("descrizione null");
        if (listaProdotti == null)
            throw new NullPointerException("lista item null");

        Pacchetto pacchetto = new Pacchetto(prezzo, nome, descrizione, this, listaProdotti);

        /*
         * //TODO farlo come metodo a parte? così che il distributore lo chiama quando vuole
         */
        this.richiediVerificaInformazioni(pacchetto);
        return pacchetto;
    }

    @Override
    public Prodotto creaProdotto(Float prezzo, String nome, String descrizione, List<Certificato> listaCertificati) {
        if (prezzo <= 0)
            throw new IllegalArgumentException("Prezzo non valido");
        if (nome == null || nome.isEmpty())
            throw new IllegalArgumentException("Nome prodotto non valido");
        if (descrizione == null || descrizione.isEmpty())
            throw new IllegalArgumentException("Descrizione non valida");
        Prodotto prodotto = new Prodotto(prezzo, nome, descrizione, this);
        if (listaCertificati != null)
            prodotto.setListaCertificati(listaCertificati);
        this.richiediVerificaInformazioni(prodotto);
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
