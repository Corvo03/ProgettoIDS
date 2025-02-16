package unicam.informazioniAggiuntive;

import java.util.ArrayList;
import java.util.List;

public class ProcessoTrasformazione implements InformazioneAggiuntiva {
    private final String nome;
    private final String descrizione;
    private List<Fase> fasiTrasformazione;

    public ProcessoTrasformazione(String nome, String descrizione) {
        this.nome = nome;
        this.descrizione = descrizione;
        fasiTrasformazione = new ArrayList<Fase>();
    }

    public ProcessoTrasformazione(String nome, String descrizione, Fase fase) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.fasiTrasformazione = new ArrayList<>();
    }

    /**
     * Aggiunge una fase di trasformazione all'insieme di fasi attuali.
     * @param fase, fase da aggiungere
     * @throws NullPointerException se la fase è vuota.
     */
    public void AddFaseProduzione(Fase fase){
        if(fase == null)
            throw new NullPointerException("Fase non può essere vuoto");
        fasiTrasformazione.add(fase);
    }

    public String getNome() {
        return nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public List<Fase> getFasiTrasformazione() {
        return fasiTrasformazione;
    }
}
