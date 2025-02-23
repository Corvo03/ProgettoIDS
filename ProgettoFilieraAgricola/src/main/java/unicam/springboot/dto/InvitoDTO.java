package unicam.springboot.dto;

import org.springframework.cglib.core.Local;
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
    private String id;

    public InvitoDTO(String id, AnimatoreFiliera animatoreFiliera, Evento evento, Azienda partecipanteEvento,
                     String messaggio, LocalDate dataCreazione, LocalDate dataScadenza, Boolean accettato) {
        this.id = id;
        this.idAnimatore = animatoreFiliera.getId() ;
        this.idEvento = evento.getId() ;
        this.idPartecipante = partecipanteEvento.getId();
        this.dataCreazione = dataCreazione.toString();
        this.dataScadenza = dataScadenza.toString() ;
        this.messaggio = messaggio;
        this.accettato = accettato;
    }

    public InvitoDTO(Invito invito){
        this.id = invito.getIdInvito();
        this.idAnimatore = invito.getAnimatoreFiliera().getId() ;
        this.idEvento = invito.getEvento().getId() ;
        this.idPartecipante = invito.getPartecipanteEvento().getId();
        this.dataCreazione = invito.getDataCreazione().toString();
        this.dataScadenza = invito.getDataScadenza().toString() ;
        this.messaggio = invito.getMessaggio();
        this.accettato = invito.isAccettato();
    }

    public String getId() {
        return id;
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