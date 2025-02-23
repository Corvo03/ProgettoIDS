package unicam.modelli.gestori;

import unicam.modelli.marketplace.Carrello;
import unicam.modelli.marketplace.MetodoPagamento;
import unicam.modelli.elements.ElementoMarketplace;

public class GestoreCarrello {
    Carrello carrello;

    public GestoreCarrello() {
        this.carrello = new Carrello();
    }

    public void aggiungiElementoAlCarrello(ElementoMarketplace elemento, int quantita) {
        carrello.aggiungiElementoAlCarrello(elemento, quantita);
    }

    public Carrello getCarrello() {
        return carrello;
    }

    public String completaAcquisto(MetodoPagamento metodoPagamento) {
        carrello.calcolaTotalePrezzo();
        metodoPagamento.pagamento(carrello.getTotalePrezzo());
        String ricevuta = metodoPagamento.generaRicevuta(carrello);
        GestoreSistema.getInstance().aggiornaQuantitaElementi(carrello.getElementiCarrello());
        carrello.svuotaCarrello();
        return ricevuta;
    }
}
