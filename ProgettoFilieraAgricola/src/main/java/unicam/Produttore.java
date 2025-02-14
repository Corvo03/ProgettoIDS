package unicam;

import java.util.List;

public class Produttore extends Azienda   {

    public Produttore() {
    }

    /**
     * Crea un prodotto utilizzando le seguenti informazioni:
     * @param prezzo del prodotto.
     * @param nome del prodotto.
     * @param descrizione del prodotto.
     * @param nomeMetodo riguarda il nome del metodo di Produzione utilizzato
     * @param descrizioneMetodo riguarda la descrizione del metodo di Produzione utilizzato
     * @return il prodotto creato.
     */
    public Prodotto creaProdotto(Float prezzo, String nome, String descrizione, String nomeMetodo, String descrizioneMetodo) {
        ItemFactory fact = new CreatorProdotto(nome, descrizione, prezzo, this.creaMetodoProduzione(nomeMetodo,descrizioneMetodo), this);
        Prodotto prodotto = (Prodotto) fact.createItem();
        this.richiediVerificaInformazioni(prodotto);
        return prodotto;
    }

    /**
     * Crea un prodotto utilizzando le seguenti informazioni:
     * @param prezzo del prodotto.
     * @param nome del prodotto.
     * @param descrizione del prodotto.
     * @param metodo riguarda il metodo di Produzione utilizzato
     * @return il prodotto creato.
     */
    public Prodotto creaProdotto(Float prezzo, String nome, String descrizione, MetodoProduzione metodo) {
        ItemFactory fact = new CreatorProdotto(nome, descrizione, prezzo, metodo, this);
        Prodotto prodotto = (Prodotto) fact.createItem();
        this.richiediVerificaInformazioni(prodotto);
        return prodotto;
    }

    /**
     * Crea un Metodo di Produzione con le seguenti caratteristiche
     * @param nomeMetodo, rappresenta il nome del metodo di produzione. Permette di distinguerlo dagli altri.
     * @param descrizioneMetodo, rappresenta una descrizione del metodo di produzione utilizzato.
     *
     * @return il Metodo di Produzione creato
     * @throws IllegalArgumentException se il nome o la descrizione sono vuote.
     */
    public MetodoProduzione creaMetodoProduzione(String nomeMetodo, String descrizioneMetodo) {
        if(nomeMetodo.isEmpty() || descrizioneMetodo.isEmpty())
            throw new IllegalArgumentException("Nome o Descrizione ddel processo non validi");
        return new MetodoProduzione(nomeMetodo, descrizioneMetodo);
    }
}
