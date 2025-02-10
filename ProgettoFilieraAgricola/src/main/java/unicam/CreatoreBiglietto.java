package unicam;

public interface CreatoreBiglietto {
        //TODO la interfaccia dovrebbe chiedere anche prezzo, descrizione e nome, altrimenti bisogna fare un cosntructor incompleto ma mi sembra peggio
    public void creaBiglietto(float prezzo, String nomeItem, String descrizione, AnimatoreFiliera animatoreFiliera, Evento evento);
}
