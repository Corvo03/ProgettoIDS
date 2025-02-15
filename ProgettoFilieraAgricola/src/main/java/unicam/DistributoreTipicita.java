package unicam;

import java.util.List;

public class DistributoreTipicita extends Azienda  {

    public DistributoreTipicita(String mail, String nomeUtente) {
        super(mail, nomeUtente);

    }

    /**
     * Crea un pacchetto con le seguenti caratteristiche:
     * @param prezzo,        prezzo del pacchetto.
     * @param nome,          nome del pacchetto.
     * @param descrizione,   descrizione del pacchetto.
     * @param listaProdotti, lista degli elementi del pacchetto.
     * @return il pacchetto appena creato.
     */
    public Pacchetto creaPacchetto(Float prezzo, String nome, String descrizione, List<Prodotto> listaProdotti) {

        CreatorPacchetto fact = new CreatorPacchetto(nome, descrizione, prezzo, listaProdotti, this);

        Pacchetto pacchetto = (Pacchetto) fact.createItem();

        this.richiediVerificaInformazioni(pacchetto);
        return pacchetto;
    }

    /**
     * Crea un pacchetto con le seguenti caratteristiche e una lista di prodotti vuota:
     * @param prezzo prezzo del pacchetto.
     * @param nome nome del pacchetto.
     * @param descrizione descrizione del pacchetto.
     * @return il pacchetto appena creato.
     */
    public Pacchetto creaPacchetto(Float prezzo, String nome, String descrizione) {
        CreatorPacchetto fact = new CreatorPacchetto(nome, descrizione, prezzo, this);
        Pacchetto pacchetto = (Pacchetto) fact.createItem();
        this.richiediVerificaInformazioni(pacchetto);
        return pacchetto;
    }

    /**
     * Crea un Prodotto con le seguenti caratteristiche:
     * @param prezzo del prodotto.
     * @param nome del prodotto.
     * @param descrizione del prodotto
     * @return il Prodotto creato.
     */
    public Prodotto creaProdotto(Float prezzo, String nome, String descrizione) {
        ItemFactory fact = new CreatorProdotto(nome, descrizione, prezzo, null, this);
        Prodotto prodotto = (Prodotto) fact.createItem();
        this.richiediVerificaInformazioni(prodotto);
        return prodotto;
    }

    /**
     * Permette di aggiungere un prodotto a un pacchetto già esistente.
     * @param pacchetto a cui si vuole aggiungere un prodotto.
     * @param prodotto prodotto da aggiungere al pacchetto.
     */
    public void aggiungiItemAPacchetto(Pacchetto pacchetto, Prodotto prodotto) {
        if (pacchetto == null)
            throw new NullPointerException("pacchetto null");
        if (prodotto == null)
            throw new NullPointerException("prodotto null");
        pacchetto.addProdotto(prodotto);
    }

    public ElementoMarketplace getProdottoMarkeplace(int id) {
        //todo aggiungere metodi per ottenere elementi dal marcketplace
        return null;
    }
}
