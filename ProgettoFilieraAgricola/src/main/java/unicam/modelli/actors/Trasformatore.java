package unicam.modelli.actors;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import unicam.modelli.actors.azienda.Azienda;
import unicam.modelli.actors.azienda.InformazioniSensibili;
import unicam.modelli.gestori.GestoreProcessoTrasformazione;
import unicam.modelli.gestori.GestoreSistema;
import unicam.modelli.elements.Certificato;
import unicam.modelli.informazioniAggiuntive.Fase;
import unicam.modelli.informazioniAggiuntive.ProcessoTrasformazione;
import unicam.modelli.elements.Prodotto;
import unicam.modelli.creators.CreatorProdotto;
import unicam.modelli.creators.ItemFactory;

import java.util.List;

@Entity
public class Trasformatore extends Azienda {
    @Id
    private String id;
    @Transient
    private GestoreProcessoTrasformazione gestoreProcessoTrasformazione;

    public Trasformatore(String nome, String mail, List<String> indirizzoSediProduttive
            , InformazioniSensibili informazioniSensibili, String nomeProfilo, String descrProfilo) {
        super(mail, nome, indirizzoSediProduttive, informazioniSensibili, nomeProfilo, descrProfilo);
        gestoreProcessoTrasformazione = new GestoreProcessoTrasformazione();
    }

    public Trasformatore(String nome, String mail, List<String> indirizzoSediProduttive
            , InformazioniSensibili informazioniSensibili) {
        super(mail, nome, indirizzoSediProduttive, informazioniSensibili);
        gestoreProcessoTrasformazione = new GestoreProcessoTrasformazione();
    }

    public Trasformatore() {
    }

    /**
     * Crea un prodotto utilizzando le seguenti informazioni:
     *
     * @param prezzo      del prodotto.
     * @param nome        del prodotto.
     * @param descrizione del prodotto.
     * @param processo    riguarda il processo di Trasformazione utilizzato
     * @return il prodotto creato.
     */
    public Prodotto creaProdotto(Float prezzo, String nome, String descrizione, ProcessoTrasformazione processo) {
        ItemFactory fact = new CreatorProdotto(nome, descrizione, prezzo, processo, this, "bbb");
        Prodotto prodotto = (Prodotto) fact.createItem();
        this.richiediVerificaInformazioni(prodotto);
        return prodotto;
    }

    /**
     * Permette di creare un Processo di trasformazione
     *
     * @param nome        del processo produttivo.
     * @param descrizione che si vuole dare al processo produttivo
     */
    public void creaProcesso(String nome, String descrizione) {
        this.gestoreProcessoTrasformazione.aggiungiProcessoTrasformazione(nome, descrizione);
    }

    /**
     * Aggiunge una fase al processo di trasformazione esistente.
     *
     * @param fase         da aggiungere al processo.
     * @param nomeProcesso esistente, nel quale deve essere aggiunta la fase.
     * @throws NullPointerException se il processo o la fase non esiste.
     */
    public void aggiungiStepAlProcesso(Fase fase, String nomeProcesso) {
        if (fase == null)
            throw new NullPointerException("Fase non valida");
        if (nomeProcesso.isEmpty())
            throw new NullPointerException("Processo non valido");
        this.gestoreProcessoTrasformazione.aggiungiFaseAlProcesso(nomeProcesso, fase);
    }

    /**
     * Aggiunge una fase al processo di trasformazione esistente.
     *
     * @param descrizioneFase da aggiungere al processo.
     * @param nomeProcesso    esistente, nel quale deve essere aggiunta la fase.
     * @throws NullPointerException se il processo o la fase non esiste.
     */
    public void aggiungiStepAlProcesso(String descrizioneFase, String nomeProcesso) {
        if (descrizioneFase == null)
            throw new NullPointerException("Fase non valida");
        if (nomeProcesso.isEmpty())
            throw new NullPointerException("Processo non valido");
        this.gestoreProcessoTrasformazione.aggiungiFaseAlProcesso(nomeProcesso, descrizioneFase);
    }

    /**
     * Restituisce un processo di trasformazione a partire dal nome inserito
     *
     * @param nomeProcesso del processo da cercare.
     * @return il processo di produzione trovato.
     */
    public ProcessoTrasformazione getProcessoTrasformazione(String nomeProcesso) {
        return this.gestoreProcessoTrasformazione.getProcessoTrasformazione(nomeProcesso);
    }

    /**
     * Permette di aggiungere un certificato al Prodotto creato da questa azienda.
     *
     * @param certificato da aggiungere al prodotto.
     * @param prodotto    a cui aggiungere un certificato.
     * @throws NullPointerException     se il certificato o il prodotto sono nulli.
     * @throws IllegalArgumentException se il certificato non Ã¨ stato trovato.
     */
    public void aggiungiCertificatoProdotto(Certificato certificato, Prodotto prodotto) {
        if (prodotto == null)
            throw new NullPointerException("Prodotto null");
        if (certificato == null)
            throw new NullPointerException("Certificato null");
        if (!GestoreSistema.getInstance().containsCertificato(certificato))
            throw new IllegalArgumentException("Certificato non trovato");
        prodotto.addCertificato(certificato);
    }
    public List<ProcessoTrasformazione> getListaProcessiTrasformazione(){
        return gestoreProcessoTrasformazione.getListaProcessiTrasformazione();
    }

    public GestoreProcessoTrasformazione getGestoreProcessoTrasformazione() {
        return gestoreProcessoTrasformazione;
    }
}
