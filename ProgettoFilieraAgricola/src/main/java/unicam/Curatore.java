package unicam;

public class Curatore extends UtenteAutenticato {
    public Curatore(){}

    public void approvaInformazione(InformazioneDaApprovare informazione) {
        GestoreInformazioni.getInstance().informazioneApprovata(informazione);
    }

    public void rifiutaInformazione(InformazioneDaApprovare informazione) {
        GestoreInformazioni.getInstance().informazioneRifiutata(informazione);
    }
}
