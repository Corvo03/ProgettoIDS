package unicam;

import java.util.List;

public interface Mediator
{

    public void inviaInvito(Invito invito);
    public void accettaInvito(Invito invito);
    public void rifiutaInvito(Invito invito);
    //todo specifichiamo questo get che è importante o no?
    public List<Invito> getListInviti(Azienda azienda);

}
