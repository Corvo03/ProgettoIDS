package unicam.modelli.marketplace;

/**
 * Classe che rappresenta il metodo di pagamento tramite bancomat
 */
public class Bancomat extends MetodoPagamento {
    /**
     * Effettua il pagamento tramite bancomat
     * @param totale
     */
    @Override
    public String pagamento(double totale) {
        return "Pagamento di " + totale + " effettuato con successo tramite bancomat";
    }

    /**
     * notifica errore nel pagamento
     * @return
     */
    @Override
    public String pagamentoErrato() {
        return "Pagamento tramite bancomat non riuscito";
    }
}
