package unicam.springboot.dto;

import unicam.modelli.actors.AnimatoreFiliera;
import unicam.modelli.actors.azienda.Azienda;
import unicam.modelli.inviti.Evento;
import unicam.modelli.inviti.Invito;

import java.time.LocalDate;

public class InvitoDTO {
    private String idAnimatore;
    private String idEvento;
    private String idPartecipante;
    private String dataCreazione;
    private String dataScadenza;
    private boolean accettato;
    private String messaggio;

    public InvitoDTO(AnimatoreFiliera animatoreFiliera, Evento evento, Azienda partecipanteEvento, String messaggio) {
        this.idAnimatore = animatoreFiliera.getId() ;
        this.idEvento = evento.getId() ;
        this.idPartecipante = partecipanteEvento.getId();
        this.dataCreazione = LocalDate.now().toString() ;
        this.dataScadenza = LocalDate.now().plusDays(2).toString() ;
        this.messaggio = messaggio;
        this.accettato = false;
    }

    public String getIdAnimatore() {
        return idAnimatore;
    }

    public String getIdEvento() {
        return idEvento;
    }

    public String getIdPartecipante() {
        return idPartecipante;
    }

    public String getDataCreazione() {
        return dataCreazione;
    }

    public String getDataScadenza() {
        return dataScadenza;
    }

    public boolean isAccettato() {
        return accettato;
    }

    public String getMessaggio() {
        return messaggio;
    }
}