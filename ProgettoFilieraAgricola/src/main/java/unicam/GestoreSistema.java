package unicam;

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

    public void aggiungiProfilo(Profilo profilo) {
        sezioneProfili.addProfilo(profilo);
    }
}
