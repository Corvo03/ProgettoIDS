package unicam.inviti;

import org.junit.jupiter.api.Test;
import unicam.actors.AnimatoreFiliera;
import unicam.actors.Produttore;
import unicam.actors.azienda.Azienda;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class GestoreInvitiInviatiTest {

    @Test
    void inviaInvito() {
        LocalDate data1 = LocalDate.of(2018, 1, 1);
        LocalDate data2 = LocalDate.of(2018, 1, 2);
        Evento evento = new Evento("nome", data1,"luogo","descrizione", 100);
        Azienda azienda = new Produttore("nomeProduttore","mailProduttore");
        AnimatoreFiliera animatoreFiliera = new AnimatoreFiliera("nomeAnimatore","mailAnimatore");
        Invito invito = new Invito(animatoreFiliera,evento,azienda,"messaggio");
        GestoreEsitoInvito gestore = new GestoreEsitoInvito();

        assertThrows(RuntimeException.class,() -> animatoreFiliera.getGestoreInvitiInviati().eliminaInvito(invito));
        assertThrows(RuntimeException.class, ()-> invito.getPartecipanteEvento().getGestoreInvitiRicevuti().eliminaInvito(invito));

        animatoreFiliera.getGestoreInvitiInviati().InviaInvito(invito);
        assertTrue(animatoreFiliera.getGestoreInvitiInviati().getListaInvito().contains(invito));
        assertTrue(azienda.getGestoreInvitiRicevuti().getInvitiRicevuti().contains(invito));




    }

    @Test
    void eliminaInvito() {
        LocalDate data1 = LocalDate.of(2018, 1, 1);
        LocalDate data2 = LocalDate.of(2018, 1, 2);
        Evento evento = new Evento("nome", data1,"luogo","descrizione", 100);
        Azienda azienda = new Produttore("nomeProduttore","mailProduttore");
        AnimatoreFiliera animatoreFiliera = new AnimatoreFiliera("nomeAnimatore","mailAnimatore");
        Invito invito = new Invito(animatoreFiliera,evento,azienda,"messaggio");
        GestoreEsitoInvito gestore = new GestoreEsitoInvito();
        animatoreFiliera.invitaAzienda(invito);
        assertTrue(animatoreFiliera.getGestoreInvitiInviati().getListaInvito().contains(invito));
        animatoreFiliera.getGestoreInvitiInviati().eliminaInvito(invito);
        assertFalse(animatoreFiliera.getGestoreInvitiInviati().getListaInvito().contains(invito));


    }
}