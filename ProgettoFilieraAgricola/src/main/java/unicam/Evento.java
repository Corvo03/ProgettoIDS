package unicam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Evento {
    private String nome;
    private LocalDate data;
    private String luogo;
    private String descrizione;
    private int capienzaMassima;
    private List<Partecipazione> listaPartecipanti;
    private int prezzoBiglietto;

    /**
     * Evento settato
     * @param nome
     * @param data
     * @param luogo
     * @param descrizione
     * @param capienzaMassima
     */
    public Evento(String nome, LocalDate data, String luogo, String descrizione, int capienzaMassima) {
        this.nome = nome;
        this.data = data;
        this.luogo = luogo;
        this.descrizione = descrizione;
        this.capienzaMassima = capienzaMassima;
        this.listaPartecipanti = new ArrayList<Partecipazione>();
    }

    /**
     * evento vuoto
     */
    public Evento() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Partecipazione> getListaPartecipanti() {
        return listaPartecipanti;
    }

    public void setListaPartecipanti(List<Partecipazione> listaPartecipanti) {
        this.listaPartecipanti = listaPartecipanti;
    }

    public int getCapienzaMassima() {
        return capienzaMassima;
    }

    public void setCapienzaMassima(int capienzaMassima) {
        this.capienzaMassima = capienzaMassima;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getLuogo() {
        return luogo;
    }

    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setPrezzoBiglietto(int prezzoBiglietto) {
        this.prezzoBiglietto = prezzoBiglietto;
    }
}
