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

class GestoreInvitiInviatiTest {

    @Test
    void inviaInvito() {
        LocalDate data1 = LocalDate.of(2018, 1, 1);
        LocalDate data2 = LocalDate.of(2018, 1, 2);
        Evento evento = new Evento("nome", data1,"luogo","descrizione", 100);
        Azienda azienda = new Produttore("nomeProduttore","mailProduttore",null,null);
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
        Azienda azienda = new Produttore("nomeProduttore","mailProduttore",null,null);
        AnimatoreFiliera animatoreFiliera = new AnimatoreFiliera("nomeAnimatore","mailAnimatore");
        Invito invito = new Invito(animatoreFiliera,evento,azienda,"messaggio");
        GestoreEsitoInvito gestore = new GestoreEsitoInvito();
        animatoreFiliera.invitaAzienda(invito);
        assertTrue(animatoreFiliera.getGestoreInvitiInviati().getListaInvito().contains(invito));
        animatoreFiliera.getGestoreInvitiInviati().eliminaInvito(invito);
        assertFalse(animatoreFiliera.getGestoreInvitiInviati().getListaInvito().contains(invito));


    }
}