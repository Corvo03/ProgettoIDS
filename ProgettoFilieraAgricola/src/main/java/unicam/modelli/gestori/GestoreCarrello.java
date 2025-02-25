package unicam.modelli.gestori;

import unicam.modelli.marketplace.Carrello;
import unicam.modelli.marketplace.MetodoPagamento;
import unicam.modelli.elements.ElementoMarketplace;

/**
 * Classe che rappresenta il gestore del carrello
 * con operazioni di acquisto e aggiunta prodotti
 */
public class GestoreCarrello {
    Carrello carrello;

    public GestoreCarrello() {
        this.carrello = new Carrello();
    }

    /**
     * aggiunge elemento al carrello
     * @param elemento
     * @param quantita
     */
    public void aggiungiElementoAlCarrello(ElementoMarketplace elemento, int quantita) {
        carrello.aggiungiElementoAlCarrello(elemento, quantita);
    }

    public Carrello getCarrello() {
        return carrello;
    }

    /**
     * completa l'acquisto con il metodo di pagamento passato
     * e svuota il carrello aggiornando le quantità nel marketplace
     * e generando una ricevuta da ritornare
     * @param metodoPagamento
     * @return
     */
    public String completaAcquisto(MetodoPagamento metodoPagamento) {
        carrello.calcolaTotalePrezzo();
        metodoPagamento.pagamento(carrello.getTotalePrezzo());
        String ricevuta = metodoPagamento.generaRicevuta(carrello);
        GestoreSistema.getInstance().aggiornaQuantitaElementi(carrello.getElementiCarrello());
        carrello.svuotaCarrello();
        return ricevuta;
    }
}
