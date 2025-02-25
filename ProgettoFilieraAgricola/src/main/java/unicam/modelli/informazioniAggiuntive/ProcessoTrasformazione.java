package unicam.modelli.informazioniAggiuntive;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Rappresenta un processo di trasformazione che può essere associato ad un prodotto
 * creato da un trasformatore
 */
@Entity
public class ProcessoTrasformazione extends InformazioneAggiuntiva {

    private String nome;
    private String descrizione;
    @OneToMany
    private List<Fase> fasiTrasformazione;

    /**
     * Crea un processo di trasformazione con i dati passati
     * @param id
     * @param nome
     * @param descrizione
     */
    public ProcessoTrasformazione(String id,String nome, String descrizione) {
        super(id);
        this.nome = nome;
        this.descrizione = descrizione;
        fasiTrasformazione = new ArrayList<Fase>();
    }
    /**
     * Crea un processo di trasformazione con i dati passati e la fase
     * @param nome
     * @param descrizione
     */

    public ProcessoTrasformazione(String id,String nome, String descrizione, Fase fase) {
        super(id);
        this.nome = nome;
        this.descrizione = descrizione;
        fasiTrasformazione = new ArrayList<Fase>();
        fasiTrasformazione.add(fase);
    }

    public ProcessoTrasformazione() {
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
