package unicam.modelli.marketplace;

public class PayPal extends MetodoPagamento {
    @Override
    public String pagamento(double totale) {
        return "Pagamento di " + totale + " effettuato con successo tramite PayPal";
    }

    @Override
    public String pagamentoErrato() {
        return "Pagamento tramite PayPal non riuscito";
    }
}
