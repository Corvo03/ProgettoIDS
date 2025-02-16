package unicam.inviti;

import org.junit.jupiter.api.Test;
import unicam.actors.Produttore;
import unicam.actors.azienda.Azienda;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class EventoTest {
    LocalDate data1 = LocalDate.of(2018, 1, 1);
    Evento evento = new Evento("nome", data1,"luogo","descrizione", 100);
    Azienda azienda = new Produttore("nomeProduttore","mailProduttore");
    @Test
    void addPartecipante() {
        assertTrue(evento.getNome().equals("nome"));
        assertTrue(evento.getCapienzaMassima() == 100);
        assertTrue(evento.getLuogo().equals("luogo"));
        assertTrue(evento.getDescrizione().equals("descrizione"));
        assertTrue(evento.getData().equals(data1));
        evento.addPartecipante(azienda);
        assertTrue(evento.getListaPartecipanti().contains(azienda));
    }
}