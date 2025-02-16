package unicam.inviti;

import org.junit.jupiter.api.Test;
import unicam.actors.AnimatoreFiliera;
import unicam.actors.Produttore;
import unicam.actors.azienda.Azienda;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class GestoreEsitoInvitoTest {


    @Test
    void gestisciInvitoAccettato() {
        LocalDate data1 = LocalDate.of(2018, 1, 1);
        LocalDate data2 = LocalDate.of(2018, 1, 2);
        Evento evento = new Evento("nome", data1,"luogo","descrizione", 100);
        Azienda azienda = new Produttore("nomeProduttore","mailProduttore");
        AnimatoreFiliera animatoreFiliera = new AnimatoreFiliera("nomeAnimatore","mailAnimatore");
        Invito invito = new Invito(animatoreFiliera,evento,azienda,data1,data2,"messaggio");
        GestoreEsitoInvito gestore = new GestoreEsitoInvito();
        invito.setAccettato(true);
        gestore.gestisciInvitoAccettato(invito);
        assertTrue(invito.getEvento().getListaPartecipanti().contains(invito.getPartecipanteEvento()));

    }

    @Test
    void gestisciInvitoRifiutato() {
        LocalDate data1 = LocalDate.of(2018, 1, 1);
        LocalDate data2 = LocalDate.of(2018, 1, 2);
        Evento evento = new Evento("nome", data1,"luogo","descrizione", 100);
        Azienda azienda = new Produttore("nomeProduttore","mailProduttore");
        AnimatoreFiliera animatoreFiliera = new AnimatoreFiliera("nomeAnimatore","mailAnimatore");
        Invito invito = new Invito(animatoreFiliera,evento,azienda,data1,data2,"messaggio");
        GestoreEsitoInvito gestore = new GestoreEsitoInvito();

        animatoreFiliera.getGestoreInvitiInviati().InviaInvito(invito);
        azienda.getGestoreInvitiRicevuti().addInvito(invito);
        animatoreFiliera.getGestoreInvitiInviati().InviaInvito(invito);
        invito.setAccettato(false);

        gestore.gestisciInvitoRifiutato(invito);
        assertFalse(invito.getEvento().getListaPartecipanti().contains(invito.getPartecipanteEvento()));
    }

    @Test
    void addPartecipante() {

        LocalDate data1 = LocalDate.of(2018, 1, 1);
        LocalDate data2 = LocalDate.of(2018, 1, 2);
        Evento evento = new Evento("nome", data1,"luogo","descrizione", 100);
        Azienda azienda = new Produttore("nomeProduttore","mailProduttore");
        AnimatoreFiliera animatoreFiliera = new AnimatoreFiliera("nomeAnimatore","mailAnimatore");
        Invito invito = new Invito(animatoreFiliera,evento,azienda,data1,data2,"messaggio");
        GestoreEsitoInvito gestore = new GestoreEsitoInvito();
        invito.setAccettato(true);
        gestore.gestisciInvitoAccettato(invito);
        assertTrue(invito.getEvento().getListaPartecipanti().contains(invito.getPartecipanteEvento()));
    }
}