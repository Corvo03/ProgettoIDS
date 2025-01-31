package unicam;

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

    public void completaAcquisto(MetodoPagamento metodoPagamento) {
        carrello.calcolaTotalePrezzo();
        metodoPagamento.pagamento(carrello.getTotalePrezzo());
        GestoreMarketplace.getInstance().aggiornaQuantitaElementi(carrello.getElementiCarrello());
        carrello.svuotaCarrello();
        notificaAziende();
    }

    /**
     * in base agli oggetti venduti nell'ultimo pagamento di comunicano alle aziende
     * i guadagni e quanti item hanno venduto
     */
    private void notificaAziende() {
        //todo
    }
}
