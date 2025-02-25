package unicam.inviti;

import org.junit.jupiter.api.Test;
import unicam.modelli.actors.AnimatoreFiliera;
import unicam.modelli.actors.Produttore;
import unicam.modelli.actors.azienda.Azienda;
import unicam.modelli.inviti.Evento;
import unicam.modelli.inviti.GestoreEsitoInvito;
import unicam.modelli.inviti.Invito;
import unicam.modelli.inviti.MediatorInviti;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MediatorInvitiTest {

    @Test
    void inviaInvito() {

        LocalDate data1 = LocalDate.of(2018, 1, 1);
        LocalDate data2 = LocalDate.of(2018, 1, 2);
        Evento evento = new Evento("id1","nome", data1,"luogo","descrizione", 100);
        Azienda azienda = new Produttore("id2","nomeProduttore","mailProduttore",null,null);
        AnimatoreFiliera animatoreFiliera = new AnimatoreFiliera("id3","nomeAnimatore","mailAnimatore");
        Invito invito = new Invito(animatoreFiliera,evento,azienda,"messaggio");
        GestoreEsitoInvito gestore = new GestoreEsitoInvito();

        MediatorInviti.getInstance().inviaInvito(invito);
        assertTrue(invito.getPartecipanteEvento().getGestoreInvitiRicevuti().getInvitiRicevuti().contains(invito));
        //il gestore dell'animatore non avrà l'invito poichè il metodo parte direttamente dal mediator

    }

    @Test
    void accettaInvito() {
        LocalDate data1 = LocalDate.of(2018, 1, 1);
        LocalDate data2 = LocalDate.of(2018, 1, 2);
        Evento evento = new Evento("id1","nome", data1,"luogo","descrizione", 100);
        Azienda azienda = new Produttore("id2","nomeProduttore","mailProduttore",null,null);
        AnimatoreFiliera animatoreFiliera = new AnimatoreFiliera("id3","nomeAnimatore","mailAnimatore");
        Invito invito = new Invito(animatoreFiliera,evento,azienda,"messaggio");
        GestoreEsitoInvito gestore = new GestoreEsitoInvito();
        MediatorInviti.getInstance().inviaInvito(invito);
        MediatorInviti.getInstance().accettaInvito(invito);

        assertTrue(invito.getPartecipanteEvento().getGestoreInvitiRicevuti().getInvitiRicevuti().contains(invito));
        assertTrue(invito.isAccettato());
        assertTrue(evento.getListaPartecipanti().contains(invito.getPartecipanteEvento()));

    }

    @Test
    void rifiutaInvito() {
        LocalDate data1 = LocalDate.of(2018, 1, 1);
        LocalDate data2 = LocalDate.of(2018, 1, 2);
        Evento evento = new Evento("id1","nome", data1,"luogo","descrizione", 100);
        Azienda azienda = new Produttore("id2","nomeProduttore","mailProduttore",null,null);
        AnimatoreFiliera animatoreFiliera = new AnimatoreFiliera("id3","nomeAnimatore","mailAnimatore");
        Invito invito = new Invito(animatoreFiliera,evento,azienda,"messaggio");
        GestoreEsitoInvito gestore = new GestoreEsitoInvito();

        invito.getAnimatoreFiliera().invitaAzienda(invito);
        azienda.rifiutaInvito(invito);
        assertFalse(invito.getPartecipanteEvento().getGestoreInvitiRicevuti().getInvitiRicevuti().contains(invito));
        assertFalse(invito.isAccettato());
        assertFalse(evento.getListaPartecipanti().contains(invito.getPartecipanteEvento()));

    }

    @Test
    void testNotify() {
        LocalDate data1 = LocalDate.of(2018, 1, 1);
        LocalDate data2 = LocalDate.of(2018, 1, 2);
        Evento evento = new Evento("id1","nome", data1,"luogo","descrizione", 100);
        Azienda azienda = new Produttore("id2","nomeProduttore","mailProduttore",null,null);
        AnimatoreFiliera animatoreFiliera = new AnimatoreFiliera("id3","nomeAnimatore","mailAnimatore");
        Invito invito = new Invito("1",animatoreFiliera,evento,azienda,"messaggio");
        GestoreEsitoInvito gestore = new GestoreEsitoInvito();

        animatoreFiliera.getGestoreInvitiInviati().InviaInvito(invito);

        MediatorInviti.getInstance().notify(invito,azienda.getGestoreInvitiRicevuti());
        assertFalse(invito.isAccettato());
        assertFalse(azienda.getGestoreInvitiRicevuti().getInvitiRicevuti().contains(invito));
        assertFalse(animatoreFiliera.getGestoreInvitiInviati().getListaInvito().contains(invito));

    }
}