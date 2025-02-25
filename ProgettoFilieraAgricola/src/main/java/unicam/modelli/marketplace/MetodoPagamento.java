package unicam.modelli.marketplace;

import unicam.modelli.elements.ElementoMarketplace;
/**
 * Classe astratta che rappresenta un metodo di pagamento.
 */
public abstract class MetodoPagamento {

    public abstract String pagamento(double totale);
    public abstract String pagamentoErrato();

    /**
     * Genera una ricevuta per il pagamento
     * @param carrello
     * @return la ricevuta
     */
    public final String generaRicevuta(Carrello carrello){
        StringBuilder ricevuta = new StringBuilder();
        ricevuta.append("Ricevuta pagamento" + this.getClass().getSimpleName() + "\n");
        ricevuta.append("Totale: ").append(carrello.getTotalePrezzo()).append("\n");
        ricevuta.append("Elementi acquistati:\n");
        for (ElementoMarketplace elemento : carrello.getElementiCarrello().keySet()) {
            ricevuta.append(elemento.getStock().getItem().getNomeItem()).append(" x")
                    .append(carrello.getElementiCarrello().get(elemento)).append("\n");
        }
        return ricevuta.toString();
    }
}
