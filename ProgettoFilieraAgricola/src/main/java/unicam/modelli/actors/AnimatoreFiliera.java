package unicam.modelli.actors;

import jakarta.persistence.*;
import unicam.modelli.actors.azienda.Azienda;
import unicam.modelli.creators.CreatorBiglietto;
import unicam.modelli.creators.ItemFactory;
import unicam.modelli.elements.Biglietto;
import unicam.modelli.elements.Stock;
import unicam.modelli.gestori.GestoreItemRifiutati;
import unicam.modelli.gestori.GestoreStock;
import unicam.modelli.inviti.*;
import unicam.modelli.marketplace.RichiedenteVerificaInformazione;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Contiene la lista degli eventi.
 * Si occupa di delegare le operazioni per
 * creare gli eventi, mandare inviti e mettere biglietti sul Market
 */
@Entity
public class AnimatoreFiliera extends UtenteAutenticato implements RichiedenteVerificaInformazione {

    /**
     * Lista di tutti gli eventi creati dall'animatore
     */
    @OneToMany
    private List<Evento> listaEventi;
    /**
     * Il gestore di tutti gli stock di ogni biglietto creato
     */
    @Transient
    private GestoreStock gestoreStock;

    /**
     * Gestore degli Inviti che l'animatore ha inviato.
     */
    @Transient
    private GestoreInvitiInviati gestoreInvitiInviati;
    @Transient
    private GestoreItemRifiutati gestoreItemRifiutati;

    /**
     * Crea un nuovo Animatore della Filiera
     *
     * @param email      dell'animatore.
     * @param nomeUtente associato all'animatore
     */
    public AnimatoreFiliera(String id,String email, String nomeUtente) {
        super(id,email, nomeUtente);
        this.gestoreInvitiInviati = new GestoreInvitiInviati(MediatorInviti.getInstance());
        this.gestoreStock = new GestoreStock();
        this.listaEventi = new ArrayList<Evento>();
        this.gestoreItemRifiutati = new GestoreItemRifiutati();

    }

    public AnimatoreFiliera() {
    }

    /**
     * Crea un biglietto con le seguenti caratteristiche e lo manda in verifica:
     *
     * @param prezzo           del biglietto.
     * @param nome             del biglietto.
     * @param descrizione      del biglietto.
     * @param animatoreFiliera che crea il biglietto, lo stesso che crea l'evento.
     * @param evento           a cui è collegato il biglietto.
     * @return il biglietto appena creato.
     */
    public Biglietto creaBiglietto(String id, double prezzo, String nome, String descrizione, AnimatoreFiliera animatoreFiliera, Evento evento) {
        ItemFactory fact = new CreatorBiglietto(id, nome, descrizione, prezzo, this, evento);
        Biglietto biglietto = (Biglietto) fact.createItem();
        this.richiediVerificaInformazioni(biglietto);
        return biglietto;
    }

    /**
     * Riempie lo stock di biglietti
     *
     * @param stock da ricaricare.
     */
    public void aggiungiBiglietti(Stock stock, int quantita) {
        this.gestoreStock.ricaricaProdotto(stock, quantita);
    }



    public void invitaAzienda(Invito invito) {
        this.gestoreInvitiInviati.InviaInvito(invito);
    }

    /**
     * Crea l'evento e lo mette nella lista, se l'evento non è valido richiede i dati
     *
     * @param nome            dell'evento.
     * @param data            in cui si svolgerà l'evento.
     * @param luogo           nel quale si terrà l'evento.
     * @param descrizione     dell'evento.
     * @param capienzaMassima rappresenta il numero massimo di persone che possono partecipare.
     */
    public void creaEvento(String id,String nome, LocalDate data, String luogo, String descrizione, int capienzaMassima) {
        try {
            Evento eventoCreato = new Evento(id, nome, data, luogo, descrizione, capienzaMassima);
            this.listaEventi.add(eventoCreato);
        } catch (IllegalArgumentException e) {
            System.out.println("Errore nella creazione del evento, riprovare");
        }
    }

    /**
     * Crea l'evento e lo mette nella lista
     *
     * @param evento da creare
     */
    public void creaEvento(Evento evento) {
        if(evento == null)
            throw new NullPointerException("Evento non trovato");
        this.listaEventi.add(evento);
    }

    /**
     * Crea un invito con le info passate e lo invia tramite gestoreInvitiInviati
     * @param id
     * @param evento
     * @param partecipanteEvento
     * @param messaggio
     */
    public void invitaAzienda(String id,Evento evento, Azienda partecipanteEvento, String messaggio) {
        Invito invito = new Invito(id,this, evento, partecipanteEvento, messaggio);
        this.gestoreInvitiInviati.InviaInvito(invito);
    }

    public List<Evento> getListaEventi() {
        return listaEventi;
    }

    public GestoreInvitiInviati getGestoreInvitiInviati() {
        return gestoreInvitiInviati;
    }

    @Override
    public GestoreStock getGestoreStock() {
        return this.gestoreStock;
    }

    public GestoreItemRifiutati getGestoreItemRifiutati() {
        return this.gestoreItemRifiutati;
    }



    /**
     * @return la lista degli inviti inviati
     */
    public List<Invito> getInviti() {
        return this.gestoreInvitiInviati.getListaInvito();
    }
}
