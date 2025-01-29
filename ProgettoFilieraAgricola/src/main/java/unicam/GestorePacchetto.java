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
     * Crea un pacchetto con le seguenti caratteristiche:
     * @param prezzo, prezzo del pacchetto
     * @param nomePacchetto, nome del pacchetto
     * @param descrizione, descrizione del pacchetto
     * @param listaItem, lista degli elementi del pacchetto
     * @return il pacchetto appena creato
     */
    public Pacchetto creaPacchetto(float prezzo, String nomePacchetto, String descrizione, List<Prodotto> listaItem) {
        if (prezzo <= 0)
            throw new IllegalArgumentException("prezzo non valido");
        if (nomePacchetto == null)
            throw new NullPointerException("nome pacchetto null");
        if (descrizione == null)
            throw new NullPointerException("descrizione null");
        if (listaItem == null)
            throw new NullPointerException("lista item null");

        this.pacchetto = new Pacchetto(prezzo, nomePacchetto, descrizione, listaItem);
        return this.pacchetto;
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
