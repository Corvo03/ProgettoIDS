package unicam.inviti;

import org.junit.jupiter.api.Test;
import unicam.modelli.actors.Produttore;
import unicam.modelli.actors.azienda.Azienda;
import unicam.modelli.inviti.Evento;

import java.time.LocalDate;


import static org.junit.jupiter.api.Assertions.*;

class EventoTest {
    LocalDate data1 = LocalDate.of(2018, 1, 1);
    Evento evento = new Evento("1", "nome", data1,"luogo","descrizione", 100);
    Azienda azienda = new Produttore("id1","nomeProduttore","mailProduttore",null,null);
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