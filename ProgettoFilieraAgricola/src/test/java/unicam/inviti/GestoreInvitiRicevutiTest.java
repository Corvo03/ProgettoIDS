package unicam.inviti;

import org.junit.jupiter.api.Test;
import unicam.actors.AnimatoreFiliera;
import unicam.actors.Produttore;
import unicam.actors.azienda.Azienda;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class GestoreInvitiRicevutiTest {

    @Test
    void accettaInvito() {

        LocalDate data1 = LocalDate.of(2018, 1, 1);
        LocalDate data2 = LocalDate.of(2018, 1, 2);
        Evento evento = new Evento("nome", data1,"luogo","descrizione", 100);
        Azienda azienda = new Produttore("nomeProduttore","mailProduttore");
        AnimatoreFiliera animatoreFiliera = new AnimatoreFiliera("nomeAnimatore","mailAnimatore");
        Invito invito = new Invito(animatoreFiliera,evento,azienda,data1,data2,"messaggio");
        GestoreEsitoInvito gestore = new GestoreEsitoInvito();
        animatoreFiliera.invitaAzienda(invito);
        azienda.accettaInvito(invito);
        assertTrue(evento.getListaPartecipanti().contains(azienda));
    }

    @Test
    void rifiutaInvito() {
        LocalDate data1 = LocalDate.of(2018, 1, 1);
        LocalDate data2 = LocalDate.of(2018, 1, 2);
        Evento evento = new Evento("nome", data1,"luogo","descrizione", 100);
        Azienda azienda = new Produttore("nomeProduttore","mailProduttore");
        AnimatoreFiliera animatoreFiliera = new AnimatoreFiliera("nomeAnimatore","mailAnimatore");
        Invito invito = new Invito(animatoreFiliera,evento,azienda,data1,data2,"messaggio");
        GestoreEsitoInvito gestore = new GestoreEsitoInvito();
        animatoreFiliera.invitaAzienda(invito);
        azienda.rifiutaInvito(invito);

        assertFalse(animatoreFiliera.getGestoreInvitiInviati().getListaInvito().contains(invito));
        assertFalse(azienda.getGestoreInvitiRicevuti().getInvitiRicevuti().contains(invito));
        assertFalse(evento.getListaPartecipanti().contains(azienda));
        assertFalse(evento.getListaPartecipanti().contains(azienda));
    }

    @Test
    void addInvito() {
        LocalDate data1 = LocalDate.of(2018, 1, 1);
        LocalDate data2 = LocalDate.of(2018, 1, 2);
        Evento evento = new Evento("nome", data1,"luogo","descrizione", 100);
        Azienda azienda = new Produttore("nomeProduttore","mailProduttore");
        AnimatoreFiliera animatoreFiliera = new AnimatoreFiliera("nomeAnimatore","mailAnimatore");
        Invito invito = new Invito(animatoreFiliera,evento,azienda,data1,data2,"messaggio");
        GestoreEsitoInvito gestore = new GestoreEsitoInvito();
        azienda.getGestoreInvitiRicevuti().addInvito(invito);

        assertTrue(azienda.getGestoreInvitiRicevuti().getInvitiRicevuti().contains(invito));
    }

    @Test
    void eliminaInvito() {

        LocalDate data1 = LocalDate.of(2018, 1, 1);
        LocalDate data2 = LocalDate.of(2018, 1, 2);
        Evento evento = new Evento("nome", data1,"luogo","descrizione", 100);
        Azienda azienda = new Produttore("nomeProduttore","mailProduttore");
        AnimatoreFiliera animatoreFiliera = new AnimatoreFiliera("nomeAnimatore","mailAnimatore");
        Invito invito = new Invito(animatoreFiliera,evento,azienda,data1,data2,"messaggio");
        GestoreEsitoInvito gestore = new GestoreEsitoInvito();
        animatoreFiliera.invitaAzienda(invito);
        assertTrue(azienda.getGestoreInvitiRicevuti().getInvitiRicevuti().contains(invito));
        azienda.getGestoreInvitiRicevuti().eliminaInvito(invito);
        assertFalse(azienda.getGestoreInvitiRicevuti().getInvitiRicevuti().contains(invito));
    }

}