package unicam;

public class Acquirente extends UtenteAutenticato{
    private Carrello carrello;
    public Acquirente() {
        carrello = new Carrello();
    }
    public Carrello getCarrello() {
        return carrello;
    }
    public void aggiungiItemAlCarrello(Item item) {

    }
}
