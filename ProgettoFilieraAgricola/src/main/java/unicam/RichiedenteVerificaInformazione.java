package unicam;

//TODO sia azienda che animatore
//TODO diagramma di sequenza crea biglietto sbagliato, animatore non chiama aggiungi metodo ma usa questo metodo di questa interfaccia

public sealed interface RichiedenteVerificaInformazione permits Azienda,AnimatoreFiliera {
    default void richiediVerificaInformazioni(InformazioneDaApprovare info){
        GestoreInformazioni.getInstance().aggiungiInformazioneDaApprovare(info, this);
    }
}