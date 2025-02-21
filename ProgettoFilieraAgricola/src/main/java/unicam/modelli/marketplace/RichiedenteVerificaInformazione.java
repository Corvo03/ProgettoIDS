package unicam.modelli.marketplace;
//TODO sia azienda che animatore
//TODO diagramma di sequenza crea biglietto sbagliato, animatore non chiama aggiungi metodo ma usa questo metodo di questa interfaccia

import unicam.modelli.gestori.GestoreInformazioni;
import unicam.modelli.gestori.GestoreItemRifiutati;
import unicam.modelli.gestori.GestoreStock;

public  interface RichiedenteVerificaInformazione {
    default void richiediVerificaInformazioni(InformazioneDaApprovare info){
        GestoreInformazioni.getInstance().aggiungiInformazioneDaApprovare(info, this);
    }
    GestoreStock getGestoreStock();
    GestoreItemRifiutati getGestoreItemRifiutati();
}