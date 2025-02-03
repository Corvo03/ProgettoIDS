package unicam;

import java.util.List;

public interface Mediator
{
    //TODO i parametri vanno modifcati così secondo me
    public void inviaInvito(Invito invito);
    public void accettaInvito(Invito invito);
    public void rifiutaInvito(Invito invito);
    public List<Invito> getListInviti();

}
