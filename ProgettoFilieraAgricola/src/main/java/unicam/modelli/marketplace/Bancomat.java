package unicam.modelli.marketplace;

public class Bancomat extends MetodoPagamento {
    @Override
    public String pagamento(double totale) {
        return "Pagamento di " + totale + " effettuato con successo tramite bancomat";
    }

    @Override
    public String pagamentoErrato() {
        return "Pagamento tramite bancomat non riuscito";
    }
}
