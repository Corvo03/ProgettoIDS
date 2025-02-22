package unicam.modelli.actors;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import unicam.modelli.actors.azienda.Azienda;
import unicam.modelli.actors.azienda.InformazioniSensibili;
import unicam.modelli.gestori.GestoreMetodoProduzione;
import unicam.modelli.gestori.GestoreSistema;
import unicam.modelli.elements.Certificato;
import unicam.modelli.informazioniAggiuntive.MetodoProduzione;
import unicam.modelli.elements.Prodotto;
import unicam.modelli.creators.CreatorProdotto;
import unicam.modelli.creators.ItemFactory;

import java.util.List;
@Entity
public class Produttore extends Azienda {

    @Id
    private String id;
    @Transient
    private GestoreMetodoProduzione gestoreMetodoProduzione;

    public Produttore(String nome, String mail, List<String> indirizzoSediProduttive
            , InformazioniSensibili informazioniSensibili, String nomeProfilo, String descrProfilo) {
        super(mail, nome, indirizzoSediProduttive, informazioniSensibili, nomeProfilo, descrProfilo);
        gestoreMetodoProduzione = new GestoreMetodoProduzione();
    }

    public Produttore(String nome, String mail, List<String> indirizzoSediProduttive
            , InformazioniSensibili informazioniSensibili) {
        super(mail, nome, indirizzoSediProduttive, informazioniSensibili);
        gestoreMetodoProduzione = new GestoreMetodoProduzione();
    }

    public Produttore() {
    }

    /**
     * Crea un prodotto utilizzando le seguenti informazioni:
     * @param prezzo del prodotto.
     * @param nome del prodotto.
     * @param descrizione del prodotto.
     * @param metodo riguarda il metodo di Produzione utilizzato
     * @return il prodotto creato.
     */
    public Prodotto creaProdotto(double prezzo, String nome, String descrizione, MetodoProduzione metodo, String id) {
        ItemFactory fact = new CreatorProdotto(nome, descrizione, prezzo, metodo, this, id);
        Prodotto prodotto = (Prodotto) fact.createItem();
        this.richiediVerificaInformazioni(prodotto);
        return prodotto;
    }

    /**
     * Restituisce un metodo di produzione
     * @param nome del metodo di produzione da restituire
     * @return il metodo di produzione trovato
     */
    public MetodoProduzione getMetodoProduzione(String nome) {
        return this.gestoreMetodoProduzione.getMetodoProduzione(nome);
    }

    /**
     * Crea un Metodo di Produzione con le seguenti caratteristiche
     * @param nomeMetodo, rappresenta il nome del metodo di produzione. Permette di distinguerlo dagli altri.
     * @param descrizioneMetodo, rappresenta una descrizione del metodo di produzione utilizzato.
     *
     * @throws IllegalArgumentException se il nome o la descrizione sono vuote.
     */
    public void creaMetodoProduzione(String nomeMetodo, String descrizioneMetodo) {
        if(nomeMetodo.isEmpty() || descrizioneMetodo.isEmpty())
            throw new IllegalArgumentException("Nome o Descrizione del processo non validi");
        this.gestoreMetodoProduzione.aggiungiMetodoProduzione(nomeMetodo, descrizioneMetodo);
    }

    /**
     * Crea un Metodo di Produzione con le seguenti caratteristiche
     *
     * @param metodoProduzione, rappresenta il metodo di produzione da aggiungere.
     * @throws IllegalArgumentException se il nome o la descrizione sono vuote.
     */
    public void creaMetodoProduzione(MetodoProduzione metodoProduzione) {
        if(metodoProduzione == null)
            throw new IllegalArgumentException("Nome o Descrizione del processo non validi");
        this.gestoreMetodoProduzione.aggiungiMetodoProduzione(metodoProduzione);
    }


    /**
     * Permette di aggiungere un certificato al Prodotto creato da questa azienda.
     * @param certificato da aggiungere al prodotto.
     * @param prodotto a cui aggiungere un certificato.
     *
     * @throws NullPointerException se il certificato o il prodotto sono nulli.
     * @throws IllegalArgumentException se il certificato non Ã¨ stato trovato.
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

    public GestoreMetodoProduzione getGestoreMetodoProduzione() {
        return gestoreMetodoProduzione;
    }
}
