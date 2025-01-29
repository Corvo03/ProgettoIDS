package unicam;

import java.util.ArrayList;
import java.util.List;

public class Curatore extends UtenteAutenticato {
    private List<InformazioneDaApprovare> listaInformazioniDaApprovare;

    /**
     *
     * @param lista
     */
    public Curatore(List<InformazioneDaApprovare> lista) {
        this.listaInformazioniDaApprovare = new ArrayList<>();
    }

    /**
     * approva l'informazione data, la toglie dalla queue e setta il "da approvare" a false
     */
    private void approvaInformazione(InformazioneDaApprovare informazioniDaApprovare){
        
    }
    /**
     * boccia l'informazione data, la toglie dalla queue e setta il "da approvare" a true
     */
    private void bocciaInformazione(){
        getListaInformazioniDaApprovare().removeFirst();
    }

    private List<InformazioneDaApprovare> getListaInformazioniDaApprovare() {
        return listaInformazioniDaApprovare;
    }
}
