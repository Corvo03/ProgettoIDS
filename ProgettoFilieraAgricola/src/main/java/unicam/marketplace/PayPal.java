package unicam.marketplace;

import unicam.elements.ElementoMarketplace;

public class PayPal extends MetodoPagamento {
    @Override
    public String pagamento(float totale) {
        return "Pagamento di " + totale + " effettuato con successo tramite PayPal";
    }

    @Override
    public String pagamentoErrato() {
        return "Pagamento tramite PayPal non riuscito";
    }
}
