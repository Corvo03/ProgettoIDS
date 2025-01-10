package unicam;

import java.util.Date;

public class Biglietto extends Item{
    private AnimatoreFiliera animatore;
    private Date dataEvento;
    private String luogo;
    private String descrizione;
    private int capienzaMassima;


    public Biglietto(float prezzo, String nomeItem, String descrizione) {
        super(prezzo, nomeItem, descrizione);
    }
}
