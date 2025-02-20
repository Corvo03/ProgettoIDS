package unicam.marketplace;
//TODO sia azienda che animatore
//TODO diagramma di sequenza crea biglietto sbagliato, animatore non chiama aggiungi metodo ma usa questo metodo di questa interfaccia

import unicam.actors.AnimatoreFiliera;
import unicam.actors.azienda.Azienda;
import unicam.elements.Stock;
import unicam.gestori.GestoreInformazioni;
import unicam.gestori.GestoreItemRifiutati;
import unicam.gestori.GestoreStock;

public  interface RichiedenteVerificaInformazione {
    default void richiediVerificaInformazioni(InformazioneDaApprovare info){
        GestoreInformazioni.getInstance().aggiungiInformazioneDaApprovare(info, this);
    }
    GestoreStock getGestoreStock();
    GestoreItemRifiutati getGestoreItemRifiutati();
}