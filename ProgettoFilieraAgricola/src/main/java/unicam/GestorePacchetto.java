package unicam;

import java.util.List;

public class GestorePacchetto {
    private Pacchetto pacchetto;
    private GestoreMarketplace gestoreMarketplace;

    //TODO gestoreMarketplace come singleton? cambiare il costruttore
    public GestorePacchetto(){
        GestoreMarketplace gestoreMarketplace = new GestoreMarketplace();
    }

    public GestorePacchetto(Pacchetto pacchetto) {
        this.pacchetto = pacchetto;
        GestoreMarketplace gestoreMarketplace = new GestoreMarketplace();
    }

    public Pacchetto getPacchetto() {
        return pacchetto;
    }

    public void setPacchetto(Pacchetto pacchetto) {
        this.pacchetto = pacchetto;
    }

    public GestoreMarketplace getGestoreMarketplace() {
        return gestoreMarketplace;
    }



    /**
     * Aggiunge il prodotto al pacchetto
     * @param prodotto, prodotto da aggiungere al pacchetto
     *
     * @throws NullPointerException se il prodotto inserito è null
     */
    public void addProdotto(Prodotto prodotto) {
        if(pacchetto == null)
            throw new NullPointerException("pacchetto null");
        this.pacchetto.addProdotto(prodotto);
    }
}
