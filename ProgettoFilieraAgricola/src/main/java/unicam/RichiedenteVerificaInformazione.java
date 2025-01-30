package unicam;

public sealed interface RichiedenteVerificaInformazione permits Azienda {
    default void richiediVerificaInformazioni(InformazioneDaApprovare info){
        GestoreInformazioni.getInstance().aggiungiInformazioneDaApprovare(info);
    }
}