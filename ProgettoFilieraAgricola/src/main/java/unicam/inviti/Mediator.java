package unicam.inviti;

/**
 * interfaccia del mediator per gli inviti
 */
public interface Mediator
{
    public void notify(Invito invito, UtilizzatoreInviti utilizzatore);
}
