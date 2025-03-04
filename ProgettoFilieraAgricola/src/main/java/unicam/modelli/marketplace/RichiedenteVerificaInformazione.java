package unicam.modelli.marketplace;

import unicam.modelli.gestori.GestoreInformazioni;
import unicam.modelli.gestori.GestoreItemRifiutati;
import unicam.modelli.gestori.GestoreStock;

/**
 * Interfaccia che permette di richiedere la verifica di InformazioneDaApprovare
 */
public  interface RichiedenteVerificaInformazione {
    /**
     * Richiede la verifica di un'informazione al GestoreInformazioni
     * @param info
     */
    default void richiediVerificaInformazioni(InformazioneDaApprovare info){
        GestoreInformazioni.getInstance().aggiungiInformazioneDaApprovare(info, this);
    }
    GestoreStock getGestoreStock();
    GestoreItemRifiutati getGestoreItemRifiutati();
}