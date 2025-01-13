package unicam;

import java.util.ArrayList;
import java.util.List;

public class Curatore extends UtenteAutenticato {
    private List<InformazioniDaApprovare> listaInformazioniDaApprovare;

    /**
     *
     * @param lista
     */
    public Curatore(List<InformazioniDaApprovare> lista) {
        this.listaInformazioniDaApprovare = new ArrayList<>();
    }

    /**
     * approva l'informazione data, la toglie dalla queue e setta il "da approvare" a false
     */
    private void approvaInformazione(){
        getListaInformazioniDaApprovare().getFirst().setDaApprovare(false);
        getListaInformazioniDaApprovare().getFirst().setApprovata(true);
        getListaInformazioniDaApprovare().removeFirst();
    }
    /**
     * boccia l'informazione data, la toglie dalla queue e setta il "da approvare" a true
     */
    private void bocciaInformazione(){
        getListaInformazioniDaApprovare().getFirst().setDaApprovare(true);
        getListaInformazioniDaApprovare().getFirst().setApprovata(false);
        getListaInformazioniDaApprovare().removeFirst();
    }

    private List<InformazioniDaApprovare> getListaInformazioniDaApprovare() {
        return listaInformazioniDaApprovare;
    }
}
