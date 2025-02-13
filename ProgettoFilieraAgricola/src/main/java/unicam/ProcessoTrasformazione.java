package unicam;

public class ProcessoTrasformazione implements InformazioneAggiuntiva {
    private final String nome;
    private final String descrizione;
    private String fasiTrasformazione;

    public ProcessoTrasformazione(String nome, String descrizione) {
        this.nome = nome;
        this.descrizione = descrizione;
        fasiTrasformazione = "";
    }

    public ProcessoTrasformazione(String nome, String descrizione, String fasiTrasformazione) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.fasiTrasformazione = fasiTrasformazione;
    }

    //Possibilità di creare una classe Fase
    /**
     * Aggiunge una fase di trasformazione all'insieme di fasi attuali.
     * @param fase, fase da aggiungere
     * @throws IllegalArgumentException se la fase è vuota.
     */
    public void AddFaseProduzione(String fase){
        if(fase.isEmpty())
            throw new IllegalArgumentException("Fase non può essere vuoto");
        fasiTrasformazione += "\n" + fase;
    }

    public String getNome() {
        return nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getFasiTrasformazione() {
        return fasiTrasformazione;
    }
}
