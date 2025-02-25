package unicam.modelli.inviti;

/**
 * interfaccia del mediator per gli inviti
 */
public interface Mediator
{
    /**
     * il chimante notifica al mediator lo stato dell'invito dopo un'operazione
     * @param invito
     * @param sender
     */
    public void notify(Invito invito, UtilizzatoreInviti sender);
}
