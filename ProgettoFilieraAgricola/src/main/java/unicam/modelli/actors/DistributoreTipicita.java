package unicam.modelli.actors;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import unicam.modelli.actors.azienda.Azienda;
import unicam.modelli.actors.azienda.InformazioniSensibili;
import unicam.modelli.creators.CreatorPacchetto;
import unicam.modelli.creators.CreatorProdotto;
import unicam.modelli.creators.ItemFactory;
import unicam.modelli.elements.Item;
import unicam.modelli.elements.Pacchetto;
import unicam.modelli.elements.Prodotto;
import unicam.modelli.gestori.GestoreSistema;
import unicam.modelli.elements.Certificato;

import java.util.List;

/**
 * Un distributore tipicita è un'azienda che si occupa di distribuire prodotti tipici
 * puo creare pacchetti e prodotti
 */
@Entity
public class DistributoreTipicita extends Azienda {

    /**
     * Crea un distrbutore tipicita con i dati passati
     * @param id
     * @param mail
     * @param nomeUtente
     * @param indirizzoSediProduttive
     * @param informazioniSensibili
     * @param nomeProfilo
     * @param descrProfilo
     */
    public DistributoreTipicita(String id,String mail, String nomeUtente, List<String> indirizzoSediProduttive
            , InformazioniSensibili informazioniSensibili, String nomeProfilo, String descrProfilo) {
        super(id,mail, nomeUtente, indirizzoSediProduttive, informazioniSensibili,nomeProfilo, descrProfilo);

    }

    public DistributoreTipicita(String id, String mail, String nomeUtente, List<String> indirizzoSediProduttive
            , InformazioniSensibili informazioniSensibili) {
        super(id, mail, nomeUtente, indirizzoSediProduttive, informazioniSensibili);
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
    public Pacchetto creaPacchetto(String id, Double prezzo, String nome, String descrizione, List<Prodotto> listaProdotti) {

        CreatorPacchetto fact = new CreatorPacchetto(id, nome, descrizione, prezzo, listaProdotti, this);

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
    public Prodotto creaProdotto(String id, double prezzo, String nome, String descrizione) {
        ItemFactory fact = new CreatorProdotto(id, nome, descrizione, prezzo, null, this);
        Prodotto prodotto = (Prodotto) fact.createItem();
        this.richiediVerificaInformazioni(prodotto);
        return prodotto;
    }

    public Prodotto getProdottoMarkeplace(String id) {
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

    public List<Item> getPacchettiStock() {
        return getGestoreStock().toListaItem();
    }
    public Pacchetto getPacchettoStock(String nome) {
        return (Pacchetto) getGestoreStock().getItem(nome);
    }
}