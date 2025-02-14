package unicam;
import java.util.ArrayList;
import java.util.List;

public class CreatorProdotto extends ItemFactory{
    private InformazioneAggiuntiva informazioneAggiuntiva;
    private List<Certificato> certificati;
    private Azienda aziendaProduttrice;

    /**
     * Permette di creare la classe che contiene la logica di creazione del Prodotto.
     * I parametri necessari per al Prodotto devono essere passati nel costruttore.
     * @param nome del prodotto da creare.
     * @param descrizione del prodotto da creare.
     * @param prezzo del prodotto da creare.
     * @param informazioneAggiuntiva del prodotto Rappresenta un Metodo di Produzione o un Processo di Trasformazione.
     * @param certificazioni relative al prodotto.
     * @param aziendaProduttrice del prodotto.
     */
    public CreatorProdotto(String nome, String descrizione, Float prezzo,
                           InformazioneAggiuntiva informazioneAggiuntiva, List<Certificato> certificazioni,
                           Azienda aziendaProduttrice) {
        super(nome, descrizione, prezzo);
        this.informazioneAggiuntiva = informazioneAggiuntiva;
        this.certificati = certificazioni;
        this.aziendaProduttrice = aziendaProduttrice;
    }

    /**
     * Permette di creare la classe che contiene la logica di creazione del Prodotto.
     * I parametri necessari per al Prodotto devono essere passati nel costruttore.
     * @param nome del prodotto da creare.
     * @param descrizione del prodotto da creare.
     * @param prezzo del prodotto da creare.
     * @param informazioneAggiuntiva del prodotto Rappresenta un Metodo di Produzione o un Processo di Trasformazione.
     * @param aziendaProduttrice del prodotto.
     */
    public CreatorProdotto(String nome, String descrizione, double prezzo,
                           InformazioneAggiuntiva informazioneAggiuntiva, Azienda aziendaProduttrice) {
        super(nome, descrizione, prezzo);
        this.informazioneAggiuntiva = informazioneAggiuntiva;
        this.aziendaProduttrice = aziendaProduttrice;
        this.certificati = new ArrayList<Certificato>();
    }

    public CreatorProdotto(String nome, String descrizione, double prezzo, Azienda aziendaProduttrice) {
        super(nome, descrizione, prezzo);
        this.informazioneAggiuntiva = null;
        this.aziendaProduttrice = aziendaProduttrice;
        this.certificati = new ArrayList<Certificato>();
    }

    /**
     * Crea un Prodotto a partire dalle informazioni ricevute nel costruttore
     * @return il Prodotto creato.
     */
    @Override
    public Item createItem() {
        if(informazioneAggiuntiva != null)
            return new Prodotto(prezzo, nome, descrizione, aziendaProduttrice, informazioneAggiuntiva);
        return new Prodotto(prezzo, nome, descrizione, aziendaProduttrice);
    }
}
