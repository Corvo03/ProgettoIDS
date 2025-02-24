package unicam.modelli.gestori;

import unicam.modelli.informazioniAggiuntive.MetodoProduzione;

import java.util.ArrayList;
import java.util.List;

/**
 * Gestore dei metodi di produzioni di un produttore.
 * Contiene i metodi di produzione, ne permette l'aggiunta di nuovi
 * e dell'eliminazione di metodi già presenti
 */
public class GestoreMetodoProduzione {
    private List<MetodoProduzione> listMetodiProduzione;

    public GestoreMetodoProduzione(List<MetodoProduzione> listMetodiProduzione) {
        this.listMetodiProduzione = listMetodiProduzione;
    }

    public GestoreMetodoProduzione() {
        this.listMetodiProduzione = new ArrayList<MetodoProduzione>();
    }

    /**
     * Aggiunge un metodo di produzione alla lista.
     * @param metodoProduzione da aggiungere
     *
     * @throws NullPointerException se il metodo da inserire è null
     * @throws IllegalArgumentException se il metodo è già presente.
     */
    public void aggiungiMetodoProduzione(MetodoProduzione metodoProduzione) {
        if(metodoProduzione == null)
            throw new NullPointerException("Metodo di produzione non valido");
        if(this.listMetodiProduzione.contains(metodoProduzione))
            throw new IllegalArgumentException("Metodo di produzione già esistente");
        this.listMetodiProduzione.add(metodoProduzione);

    }

    /**
     * Aggiunge un metodo di produzione alla lista.
     * @param nomeMetodo del metodo di produzione da aggiungere.
     * @param descrizioneMetodo  del metodo di produzione da aggiungere.
     *
     * @throws NullPointerException se il nome o la descrizione sono nulli.
     */
    public void aggiungiMetodoProduzione(String nomeMetodo, String descrizioneMetodo) {
        if(nomeMetodo.isEmpty())
            throw new NullPointerException("Nome del metodo non valido");
        if(descrizioneMetodo.isEmpty())
            throw new NullPointerException("Descrizione non valida");
        this.aggiungiMetodoProduzione(new MetodoProduzione(nomeMetodo, descrizioneMetodo));
    }

    /**
     * Elimina un metodo di produzione dalla lista di metodi di produzione.
     * @param nome del metodo di produzione da eliminare.
     *
     * @throws NullPointerException se il nome del metodo di produzione è vuoto
     */
    public void eliminaMetodoProduzione(String nome) {
        if(nome.isEmpty())
            throw new NullPointerException("Non del metodo di produzione non valido");

        listMetodiProduzione.removeIf(metodoProduzione -> metodoProduzione.getNome().equals(nome));
    }

    /**
     * Restituisce un Metodo di produzione a partire dal nome, null se non viene trovato.
     * @param nome del Metodo di produzione da ricercare.
     * @return il metodo di produzione, null se non è stato trovato.
     *
     * @throws NullPointerException se il nome del metodo di produzione è vuoto
     */
    public MetodoProduzione getMetodoProduzione(String nome) {
        if(listMetodiProduzione.isEmpty())
            return null;
        if(nome.isEmpty())
            throw new NullPointerException("Nome del metodo di produzione non valido");

        for(MetodoProduzione metodoProduzione : listMetodiProduzione) {
            if(metodoProduzione.getNome().equals(nome))
                return metodoProduzione;
        }
        return null;
    }

    public List<MetodoProduzione> getListMetodiProduzione() {
        return listMetodiProduzione;
    }
}
