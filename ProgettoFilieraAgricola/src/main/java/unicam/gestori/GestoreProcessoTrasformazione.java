package unicam.gestori;

import unicam.informazioniAggiuntive.Fase;
import unicam.informazioniAggiuntive.ProcessoTrasformazione;

import java.util.ArrayList;
import java.util.List;

public class GestoreProcessoTrasformazione {
    private List<ProcessoTrasformazione> listaProcessiTrasformazione;

    public GestoreProcessoTrasformazione(List<ProcessoTrasformazione> listaProcessiTrasformazione) {
        this.listaProcessiTrasformazione = listaProcessiTrasformazione;
    }

    public GestoreProcessoTrasformazione(){
        this.listaProcessiTrasformazione = new ArrayList<>();
    }

    public List<ProcessoTrasformazione> getListaProcessiTrasformazione() {
        return listaProcessiTrasformazione;
    }

    /**
     * Restituisce un Processo di Trasformazione a partire dal nome, null se non viene trovato.
     * @param nome del Processo di Trasformazione da ricercare.
     * @return il Processo di Trasformazione, null se non è stato trovato.
     *
     * @throws NullPointerException se il nome del Processo di Trasformazione è vuoto
     */
    public ProcessoTrasformazione getProcessoTrasformazione(String nome) {
        if(listaProcessiTrasformazione.isEmpty())
            return null;
        if(nome.isEmpty())
            throw new NullPointerException("Nome del Processo di Trasformazione non valido");

        for(ProcessoTrasformazione processoTrasformazione : listaProcessiTrasformazione) {
            if(processoTrasformazione.getNome().equals(nome))
                return processoTrasformazione;
        }
        return null;
    }

    /**
     * Aggiunge un Processo di Trasformazione alla lista.
     * @param nome  del processo da aggiungere.
     * @param descrizione del processo da aggiungere.
     *
     * @throws NullPointerException se il Processo di Trasformazione da inserire è null
     * @throws IllegalArgumentException se il Processo di Trasformazione è già presente.
     */
    public void aggiungiProcessoTrasformazione(String nome, String descrizione) {
        if(nome.isEmpty() || descrizione.isEmpty())
            throw new NullPointerException("Processo di Trasformazione non valido");
        this.aggiungiProcessoTrasformazione(new ProcessoTrasformazione(nome, descrizione));
    }

    /**
     * Aggiunge un Processo di Trasformazione alla lista.
     * @param processoTrasformazione da aggiungere
     *
     * @throws NullPointerException se il Processo di Trasformazione da inserire è null
     * @throws IllegalArgumentException se il Processo di Trasformazione è già presente.
     */
    public void aggiungiProcessoTrasformazione(ProcessoTrasformazione processoTrasformazione) {
        if(processoTrasformazione == null)
            throw new NullPointerException("Processo di Trasformazione non valido");
        if(this.listaProcessiTrasformazione.contains(processoTrasformazione))
            throw new IllegalArgumentException("Processo di Trasformazione già esistente");
        this.listaProcessiTrasformazione.add(processoTrasformazione);
    }

    /**
     * Elimina un Processo di Trasformazione dalla lista di processi di produzione.
     * @param nome del Processo di Trasformazione da eliminare.
     *
     * @throws NullPointerException se il nome del Processo di Trasformazione è vuoto
     */
    public void eliminaMetodoTrasformazione(String nome) {
        if(nome.isEmpty())
            throw new NullPointerException("Non del metodo di trasformazione non valido");
        listaProcessiTrasformazione.removeIf(processoTrasformazione -> processoTrasformazione.getNome().equals(nome));
    }

    /**
     * Aggiunge una fase a un Processo di Trasformazione.
     * @param nomeProcesso del Processo in cui aggiungere la fase
     * @param fase da aggiungere
     *
     * @throws NullPointerException se la fase o il nome non sono validi
     */
    public void aggiungiFaseAlProcesso(String nomeProcesso, Fase fase){
        if(nomeProcesso.isEmpty())
            throw new NullPointerException("Non del processo non valido");
        if(fase == null)
            throw new NullPointerException("Fase non valida");
        this.getProcessoTrasformazione(nomeProcesso).AddFaseProduzione(fase);
    }

    /**
     * Crea una fase e l'aggiunge al Processo di Trasformazione.
     * @param nomeProcesso in cui aggiungere la fase.
     * @param descrizioneFase con cui creare la fase.
     *
     * @throws NullPointerException se la fase o il nome non sono validi
     */
    public void aggiungiFaseAlProcesso(String nomeProcesso, String descrizioneFase){
        if(nomeProcesso.isEmpty())
            throw new NullPointerException("Non del processo non valido");
        if(descrizioneFase.isEmpty())
            throw new NullPointerException("Fase non valida");
        this.getProcessoTrasformazione(nomeProcesso).AddFaseProduzione(new Fase(descrizioneFase));
    }
}