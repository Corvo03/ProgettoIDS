package unicam;

import java.util.List;

public class Trasformatore extends Azienda {

    public Trasformatore() {

    }

    /**
     * Crea un prodotto utilizzando le seguenti informazioni:
     * @param prezzo del prodotto.
     * @param nome del prodotto.
     * @param descrizione del prodotto.
     * @param informazioneAggiuntiva riguarda il processo di Trasformazione utilizzato
     * @return il prodotto creato.
     */
    public Prodotto creaProdotto(Float prezzo, String nome, String descrizione, InformazioneAggiuntiva informazioneAggiuntiva) {
        ItemFactory fact = new CreatorProdotto(nome, descrizione, prezzo, informazioneAggiuntiva, this);
        Prodotto prodotto = (Prodotto) fact.createItem();
        this.richiediVerificaInformazioni(prodotto);
        return prodotto;
    }

    /**
     * Crea un prodotto utilizzando le seguenti informazioni:
     * @param prezzo del prodotto.
     * @param nome del prodotto.
     * @param descrizione del prodotto.
     * @param nomeProcesso riguarda il nome del processo di Trasformazione utilizzato
     * @param descrizioneProcesso riguarda la descrizione del processo di Trasformazione utilizzato
     * @return il prodotto creato.
     */
    public Prodotto creaProdotto(Float prezzo, String nome, String descrizione, String nomeProcesso, String descrizioneProcesso) {
        return creaProdotto(prezzo, nome, descrizione, new ProcessoTrasformazione(nomeProcesso, descrizioneProcesso));
    }

    /**
     * Permette di creare un Processo di trasformazione
     * @param nome del processo produttivo.
     * @param descrizione che si vuole dare al processo produttivo
     * @return un Processo di trasformazione
     */
    public ProcessoTrasformazione creaProcesso(String nome, String descrizione){
        return new ProcessoTrasformazione(nome, descrizione);
    }

    /**
     * Aggiunge una fase al processo di trasformazione esistente.
     * @param fase da aggiungere al processo.
     * @param processo esistente, nel quale deve essere aggiunta la fase.
     *
     * @throws NullPointerException se il processo non esiste, o la fase è vuota.
     */
    public void aggiungiStepAlProcesso(String fase, ProcessoTrasformazione processo){
        if(processo == null)
            throw new NullPointerException("Processo non esistente");
        processo.AddFaseProduzione(fase);
    }
}
