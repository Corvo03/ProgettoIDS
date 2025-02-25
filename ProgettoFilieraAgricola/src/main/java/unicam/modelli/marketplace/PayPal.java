package unicam.modelli.marketplace;

/**
 * Classe che rappresenta il metodo di pagamento PayPal.
 */
public class PayPal extends MetodoPagamento {
    /**
     * Effettua il pagamento tramite PayPal
     * @param totale
     * @return
     */
    @Override
    public String pagamento(double totale) {
        return "Pagamento di " + totale + " effettuato con successo tramite PayPal";
    }

    /**
     * Notifica che il pagamento tramite PayPal non è riuscito
     * @return
     */
    @Override
    public String pagamentoErrato() {
        return "Pagamento tramite PayPal non riuscito";
    }
}
