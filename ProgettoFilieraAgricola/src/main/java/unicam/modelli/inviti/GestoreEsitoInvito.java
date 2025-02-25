package unicam.modelli.inviti;

import unicam.modelli.actors.azienda.Azienda;

/**
 * Gestore degli esiti degli inviti accettati e rifiutati
 */
public class GestoreEsitoInvito {
    /**
     * gestisce un invito accettato
     * @param invito
     */
    public void gestisciInvitoAccettato(Invito invito){
        if(!invito.isAccettato()) throw new IllegalArgumentException("L'invito è rifiutato");
        addPartecipante(invito.getPartecipanteEvento(), invito.getEvento());
    }

    /**
     * gestisce un invito rifiutato e lo elimina dalle liste dei gestori
     * @param invito
     */
    public void gestisciInvitoRifiutato(Invito invito){
        if(invito.isAccettato()) throw new IllegalArgumentException("L'invito è accettato");
        invito.getAnimatoreFiliera().getGestoreInvitiInviati().eliminaInvito(invito);
        invito.getPartecipanteEvento().getGestoreInvitiRicevuti().eliminaInvito(invito);
    }

    /**
     * prende partecipante ed evento e lo aggiunge a quest'ultimo
     * @param partecipanteEvento
     * @param evento
     */
    public void addPartecipante(PartecipanteEvento partecipanteEvento, Evento evento){
        evento.addPartecipante(partecipanteEvento);
    }
}
