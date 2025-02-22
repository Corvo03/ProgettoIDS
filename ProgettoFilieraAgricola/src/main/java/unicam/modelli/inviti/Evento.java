package unicam.modelli.inviti;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import unicam.modelli.actors.azienda.Azienda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * specifica cosa deve avere un evento
 */
@Entity
public class Evento {
    @Id
    private String id;
    private String nome;
    private LocalDate data;
    private String luogo;
    private String descrizione;
    private int capienzaMassima;
    /**
     * lista partecipanti che hanno accettato l'invito
     */
    @Transient
    private List<PartecipanteEvento> listaPartecipanti;

    /**
     * @param nome
     * @param data
     * @param luogo
     * @param descrizione
     * @param capienzaMassima
     */
    public Evento(String id,String nome, LocalDate data, String luogo, String descrizione, int capienzaMassima) {
        if(nome == null || data == null || luogo == null || descrizione == null || capienzaMassima < 1){
            throw new IllegalArgumentException();
        }
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.luogo = luogo;
        this.descrizione = descrizione;
        this.capienzaMassima = capienzaMassima;
        this.listaPartecipanti = new ArrayList<>();
    }

    public Evento() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<PartecipanteEvento> getListaPartecipanti() {
        return listaPartecipanti;
    }

    public void setListaPartecipanti(List<PartecipanteEvento> listaPartecipanti) {
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

    /**
     * Aggiunge un partecipente all'evento
     * @param partecipanteEvento, partecipante da aggiungere.
     */
    public void addPartecipante(PartecipanteEvento partecipanteEvento) {
        this.listaPartecipanti.add(partecipanteEvento);
    }

    public String getId() {
        return id;
    }
}
