package unicam.marketplace;

import unicam.elements.ElementoMarketplace;

public abstract class MetodoPagamento {
    public abstract String pagamento(float totale);

    public abstract String pagamentoErrato();

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
