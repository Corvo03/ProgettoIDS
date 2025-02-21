package unicam.inviti;

import org.junit.jupiter.api.Test;
import unicam.modelli.actors.AnimatoreFiliera;
import unicam.modelli.actors.Produttore;
import unicam.modelli.actors.azienda.Azienda;
import unicam.modelli.inviti.Evento;
import unicam.modelli.inviti.GestoreEsitoInvito;
import unicam.modelli.inviti.Invito;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class GestoreEsitoInvitoTest {


    @Test
    void gestisciInvitoAccettato() {
        LocalDate data1 = LocalDate.of(2018, 1, 1);
        LocalDate data2 = LocalDate.of(2018, 1, 2);
        Evento evento = new Evento("nome", data1,"luogo","descrizione", 100);
        Azienda azienda = new Produttore("nomeProduttore","mailProduttore",null,null);
        AnimatoreFiliera animatoreFiliera = new AnimatoreFiliera("nomeAnimatore","mailAnimatore");
        Invito invito = new Invito(animatoreFiliera,evento,azienda,"messaggio");
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
        Azienda azienda = new Produttore("nomeProduttore","mailProduttore",null,null);
        AnimatoreFiliera animatoreFiliera = new AnimatoreFiliera("nomeAnimatore","mailAnimatore");
        Invito invito = new Invito(animatoreFiliera,evento,azienda,"messaggio");
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
        Azienda azienda = new Produttore("nomeProduttore","mailProduttore",null,null);
        AnimatoreFiliera animatoreFiliera = new AnimatoreFiliera("nomeAnimatore","mailAnimatore");
        Invito invito = new Invito(animatoreFiliera,evento,azienda,"messaggio");
        GestoreEsitoInvito gestore = new GestoreEsitoInvito();
        invito.setAccettato(true);
        gestore.gestisciInvitoAccettato(invito);
        assertTrue(invito.getEvento().getListaPartecipanti().contains(invito.getPartecipanteEvento()));
    }
}