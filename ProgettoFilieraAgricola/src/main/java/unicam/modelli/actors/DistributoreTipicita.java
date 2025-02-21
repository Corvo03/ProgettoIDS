package unicam.modelli.actors;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import unicam.modelli.actors.azienda.Azienda;
import unicam.modelli.actors.azienda.InformazioniSensibili;
import unicam.modelli.creators.CreatorPacchetto;
import unicam.modelli.creators.CreatorProdotto;
import unicam.modelli.creators.ItemFactory;
import unicam.modelli.elements.Pacchetto;
import unicam.modelli.elements.Prodotto;
import unicam.modelli.gestori.GestoreSistema;
import unicam.modelli.elements.Certificato;

import java.util.List;
@Entity
public class DistributoreTipicita extends Azienda {
    @Id
    private String id;
    public DistributoreTipicita(String mail, String nomeUtente, List<String> indirizzoSediProduttive
            , InformazioniSensibili informazioniSensibili) {
        super(mail, nomeUtente, indirizzoSediProduttive, informazioniSensibili);

    }

    public DistributoreTipicita() {
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

    public Prodotto getProdottoMarkeplace(String id) {
        //TODO fare in modo che azienda possa accedere ai prodotti del marketplace.
        if(GestoreSistema.getInstance().getItemById(id) instanceof Prodotto p)
            return p;
        throw new IllegalArgumentException("L'elemento non trovato");

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