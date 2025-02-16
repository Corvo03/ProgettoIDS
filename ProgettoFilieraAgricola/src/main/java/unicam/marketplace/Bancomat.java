package unicam.marketplace;

import unicam.elements.ElementoMarketplace;

public class Bancomat extends MetodoPagamento {
    @Override
    public String pagamento(float totale) {
        return "Pagamento di " + totale + " effettuato con successo tramite bancomat";
    }

    @Override
    public String pagamentoErrato() {
        return "Pagamento tramite bancomat non riuscito";
    }
}
