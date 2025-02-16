package unicam.actors;

import unicam.actors.azienda.Azienda;
import unicam.gestori.GestoreSistema;
import unicam.gestori.certificato.Certificato;
import unicam.informazioniAggiuntive.Fase;
import unicam.informazioniAggiuntive.InformazioneAggiuntiva;
import unicam.informazioniAggiuntive.ProcessoTrasformazione;
import unicam.elements.Prodotto;
import unicam.creators.CreatorProdotto;
import unicam.creators.ItemFactory;

public class Trasformatore extends Azienda {

    public Trasformatore(String nome, String mail) {
        super(mail, nome);
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
     * @throws NullPointerException se il processo o la fase non esiste.
     */
    public void aggiungiStepAlProcesso(Fase fase, ProcessoTrasformazione processo){
        if(fase == null)
            throw new NullPointerException("Fase non esistente");
        if(processo == null)
            throw new NullPointerException("Processo non esistente");
        processo.AddFaseProduzione(fase);
    }

    /**
     * Permette di aggiungere un certificato al Prodotto creato da questa azienda.
     * @param certificato da aggiungere al prodotto.
     * @param prodotto a cui aggiungere un certificato.
     *
     * @throws NullPointerException se il certificato o il prodotto sono nulli.
     * @throws IllegalArgumentException se il certificato non è stato trovato.
     */
    public void aggiungiCertificatoProdotto(Certificato certificato, Prodotto prodotto) {
        if(prodotto == null)
            throw new NullPointerException("Prodotto null");
        if (certificato == null)
            throw new NullPointerException("Certificato null");
        if(!GestoreSistema.getInstance().containsCertificato(certificato))
            throw new IllegalArgumentException("Certificato non trovato");
        prodotto.addCertificato(certificato);
    }
}
