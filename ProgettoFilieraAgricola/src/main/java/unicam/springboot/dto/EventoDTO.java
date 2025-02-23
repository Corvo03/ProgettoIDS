package unicam.springboot.dto;

import unicam.modelli.inviti.Evento;
import unicam.modelli.inviti.PartecipanteEvento;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventoDTO {
    private String id;
    private String nome;
    private LocalDate data;
    private String luogo;
    private String descrizione;
    private int capienzaMassima;
    private List<PartecipanteEventoDTO> listaPartecipanti;

    public EventoDTO(Evento evento) {
        this.id = evento.getId();
        this.nome = evento.getNome();
        this.data = evento.getData();
        this.luogo = evento.getLuogo();
        this.descrizione = evento.getDescrizione();
        this.capienzaMassima = evento.getCapienzaMassima();
        this.listaPartecipanti = new ArrayList<PartecipanteEventoDTO>();
        this.caricaDatiPartecipanti(evento.getListaPartecipanti());
    }

    //Se nulla la lista deve essere anch'essa nulla
    private void caricaDatiPartecipanti(List<PartecipanteEvento> listaPartecipanti) {
        for(PartecipanteEvento p : listaPartecipanti) {
            this.listaPartecipanti.add(new PartecipanteEventoDTO(p));
        }
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getData() {
        return data;
    }

    public String getLuogo() {
        return luogo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public int getCapienzaMassima() {
        return capienzaMassima;
    }

    public List<PartecipanteEventoDTO> getListaPartecipanti() {
        return listaPartecipanti;
    }
}
