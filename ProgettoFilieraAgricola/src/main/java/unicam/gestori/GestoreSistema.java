package unicam.gestori;

import unicam.elements.Item;
import unicam.gestori.certificato.Certificato;
import unicam.actors.azienda.Profilo;
import unicam.elements.ElementoMarketplace;
import unicam.elements.Stock;
import unicam.gestori.certificato.GestoreCertificatoLettura;

import java.util.List;
import java.util.Map;

/**
 * Classe che fa da tramite tra le sezioni del sistema disponibili a tutti gli utenti.
 */
public class GestoreSistema {
    private static GestoreSistema istanza;
    private GestoreCertificatoLettura gestoreCertificatoLettura;
    private final SezioneProfili sezioneProfili;
    private final GestoreMarketplace gestoreMarketplace;

    private GestoreSistema() {
        gestoreMarketplace = new GestoreMarketplace();
        sezioneProfili = new SezioneProfili();
        gestoreCertificatoLettura = new GestoreCertificatoLettura();
    }

    /**
     * Ritorna il puntatore all'istanza dell'oggetto (se esiste), altrimenti ne crea uno.
     *
     * @return
     */
    public static GestoreSistema getInstance() {
        if (istanza == null)
            istanza = new GestoreSistema();
        return istanza;
    }

    /**
     * Delega a gestoreMarketplace la creazione di un elemento del marketplace.
     *
     * @param stock
     */
    public void creaElementoMarketPlace(Stock stock) {
        gestoreMarketplace.creaElementoMarketPlace(stock);
    }

    /**
     * Delega a sezioneProfili di ottenere la lista di tutti i profili.
     *
     * @return lista di tutti i profili
     */
    public List<Profilo> getListaProfili() {
        return sezioneProfili.getListaProfili();
    }

    /**
     * Delega a gestoreCertificatoLettura di ottenere la lista di tutti i certificati.
     *
     * @return lista di tutti i certificati disponibili
     */
    public List<Certificato> getListaCertificati(){
        return gestoreCertificatoLettura.getListaCertificati();
    }

    /**
     * Delega a gestoreMarketplace di ottenere la lista di tutti gli elementi disponibili nel marketplace.
     *
     * @return lista di tutti gli elementi disponibili nel marketplace
     */
    public List<ElementoMarketplace> getElementiDisponibiliMarketplace() {
        return gestoreMarketplace.getElementiDisponibiliMarketplace();
    }

    /**
     * Delega a gestoreMarketplace di aggiornare la quantità degli elementi del marketplace.
     *
     * @param elementiCarrello mappa degli elementi del carrello
     */
    public void aggiornaQuantitaElementi(Map<ElementoMarketplace, Integer> elementiCarrello) {
        gestoreMarketplace.aggiornaQuantitaElementi(elementiCarrello);
    }

    /**
     * Aggiunge un profilo aziendale alla sezione profili
     * @param profilo da aggiungere alla lista.
     */
    public void aggiungiProfilo(Profilo profilo) {
        sezioneProfili.addProfilo(profilo);
    }

    /**
     * Ritorna true se un certificato è contenuto nella lista di certificati presenti nel sistema.
     * @param certificato da cercare nella lista
     * @return true se il certificato è presente, false altrimenti.
     */
    public boolean containsCertificato(Certificato certificato) {
        return getListaCertificati().contains(certificato);
    }

    /**
     * Metodo per ottenere la scheda dell'item di uno speciale elemento marketplace a partire dall'id.
     * @param id da ricercare.
     * @return l'Item relativo all'elemento marketplace con quell'id, null se non lo trova.
     *
     * @throws IllegalArgumentException se l'id è minore di 0.
     */
    public Item getItemById(int id) {
        if(id<0)
            throw new IllegalArgumentException("Id non valido");
        return this.gestoreMarketplace.getItemById(id);
    }
}
