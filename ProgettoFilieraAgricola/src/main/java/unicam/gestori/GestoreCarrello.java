package unicam.gestori;

import unicam.marketplace.Carrello;
import unicam.marketplace.MetodoPagamento;
import unicam.elements.ElementoMarketplace;

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
        notificaAziende();
        return ricevuta;
    }

    /**
     * in base agli oggetti venduti nell'ultimo pagamento di comunicano alle aziende
     * i guadagni e quanti item hanno venduto
     */
    private void notificaAziende() {
        //todo, anche no
    }
}
