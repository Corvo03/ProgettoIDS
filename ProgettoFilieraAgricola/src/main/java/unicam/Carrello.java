package unicam;

import java.util.ArrayList;
import java.util.List;

public class Carrello {
    private List<ElementoMarketplace> listaElementiMarketplace;
    private float totalePrezzo;
    private MetodoPagamento metodoPagamento;

    /**
     * istanzia la lista degli elementi nel carrello
     */
    public Carrello() {
        listaElementiMarketplace = new ArrayList<ElementoMarketplace>();
    }

    /**
     * calcola totale del costo dei prodotti
     */
    public void calcolaTotalePrezzo() {
        for (ElementoMarketplace elem : listaElementiMarketplace) {
            this.totalePrezzo += elem.getStock().getItem().getPrezzo();
        }
    }

    /**
     * paga il costo dei prodotti
     * notifica poi le aziende per comunicargli che hanno venduto dei prodotti
     * svuota il carrello e azzera il totale
     * @param metodoScelto
     */
    public void paga(MetodoPagamento metodoScelto){
        calcolaTotalePrezzo();
        setMetodoPagamento(metodoScelto);
        svuotaCarrello();
        notificaAziende();
    }

    /**
     * svuota carrello e azzera totale
     */
    public void svuotaCarrello(){
        this.listaElementiMarketplace.clear();
        this.totalePrezzo = 0;
    }

    /**
     * in base agli oggetti venduti nell'ultimo pagamento di comunicano alle aziende
     * i guadagni e quanti item hanno venduto
     */
    private void notificaAziende(){
        //todo
    }
    public List<ElementoMarketplace> getListaElementiMarketplace() {
        return listaElementiMarketplace;
    }

    public float getTotalePrezzo() {
        return totalePrezzo;
    }

    public MetodoPagamento getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }
}
