package unicam.inviti;

import java.util.ArrayList;
import java.util.List;

/**
 * gestisce gli inviti ricevuti dall'azienda
 */
public class GestoreInvitiRicevuti implements UtilizzatoreInviti{
    private Mediator mediator;
    private List<Invito> invitiRicevuti;
    public GestoreInvitiRicevuti(Mediator mediator) {
        this.mediator = mediator;
        this.invitiRicevuti = new ArrayList<Invito>();
    }


    /**
     * accetta invito e notifica
     * @param invito
     */
    public void accettaInvito(Invito invito){
        if(!invitiRicevuti.contains(invito)) throw new RuntimeException("Invito non trovato");
        invito.setAccettato(true);
        mediator.notify(invito,this);

    }

    /**
     * rifiuta invito e notifica
     * @param invito
     */
    public void rifiutaInvito(Invito invito){
        if(!invitiRicevuti.contains(invito)) throw new RuntimeException("Invito non trovato");
        invito.setAccettato(false);
        mediator.notify(invito,this);

    }

    /**
     * mette in lista l'invito ricevuto
     * @param invito
     */
    public void addInvito(Invito invito){
        this.invitiRicevuti.add(invito);
    }

    public Mediator getMediator() {
        return mediator;
    }
    public void eliminaInvito(Invito invito){
        if(!this.invitiRicevuti.contains(invito)) throw new RuntimeException("Invito non trovato");
        this.invitiRicevuti.remove(invito);
    }

    public List<Invito> getInvitiRicevuti() {
        return invitiRicevuti;
    }
}
