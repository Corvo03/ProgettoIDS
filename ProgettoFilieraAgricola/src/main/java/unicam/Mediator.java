package unicam;

import java.util.List;

public interface Mediator
{

    /**
     * invia uno specifico invito
     * @param invito
     */
    public void inviaInvito(Invito invito);
    /**
     * accetta uno specifico invito
     * @param invito
     * @param risposta
     */
   public boolean inviaRisposta(Invito invito, boolean risposta);


}
