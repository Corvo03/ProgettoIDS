package unicam.actors;

import unicam.actors.azienda.Azienda;
import unicam.creators.CreatorBiglietto;
import unicam.creators.ItemFactory;
import unicam.elements.Biglietto;
import unicam.elements.Stock;
import unicam.gestori.GestoreItemRifiutati;
import unicam.gestori.GestoreStock;
import unicam.inviti.*;
import unicam.marketplace.RichiedenteVerificaInformazione;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Contiene la lista degli eventi.
 * Si occupa di delegare le operazioni per
 * creare gli eventi, mandare inviti e mettere biglietti sul Market
 */
public class AnimatoreFiliera extends UtenteAutenticato implements RichiedenteVerificaInformazione {
    /**
     * Lista di tutti gli eventi creati dall'animatore
     */
    private List<Evento> listaEventi;

    /**
     * Il gestore di tutti gli stock di ogni biglietto creato
     */
    private GestoreStock gestoreStock;

    /**
     * Gestore degli Inviti che l'animatore ha inviato.
     */
    private GestoreInvitiInviati gestoreInvitiInviati;
    private GestoreItemRifiutati gestoreItemRifiutati;

    /**
     * Crea un nuovo Animatore della Filiera
     * @param email dell'animatore.
     * @param nomeUtente associato all'animatore
     */
    public AnimatoreFiliera(String email, String nomeUtente) {
        super(email, nomeUtente);
        this.gestoreInvitiInviati = new GestoreInvitiInviati(MediatorInviti.getInstance());
        this.gestoreStock = new GestoreStock();
        this.listaEventi = new ArrayList<Evento>();
        this.gestoreItemRifiutati = new GestoreItemRifiutati();
    }

    /**
     * Crea un biglietto con le seguenti caratteristiche e lo manda in verifica:
     *
     * @param prezzo del biglietto.
     * @param nome del biglietto.
     * @param descrizione del biglietto.
     * @param animatoreFiliera che crea il biglietto, lo stesso che crea l'evento.
     * @param evento a cui è collegato il biglietto.
     * @return il biglietto appena creato.
     */
    public Biglietto creaBiglietto(float prezzo, String nome, String descrizione, AnimatoreFiliera animatoreFiliera, Evento evento) {
        ItemFactory fact = new CreatorBiglietto(nome, descrizione, prezzo, this, evento);
        Biglietto biglietto = (Biglietto) fact.createItem();
        this.richiediVerificaInformazioni(biglietto);
        return biglietto;
    }

    /**
     * Riempie lo stock di biglietti
     * @param stock da ricaricare.
     */
    public void aggiungiBiglietti(Stock stock, int quantita) {
        this.gestoreStock.ricaricaProdotto(stock, quantita);
    }

    /**
     * Delega l'invito di un'azienda al mittente
     * @param evento al quale invitare l'azienda
     * @param partecipanteEvento da invitare all'evento
     * @param messaggio col quale mandare l'invito.
     */
    public void invitaAzienda(Evento evento, PartecipanteEvento partecipanteEvento,String messaggio) {
        Invito invito = new Invito(this, evento, partecipanteEvento, messaggio);
        this.gestoreInvitiInviati.InviaInvito(invito);
    }

    public void invitaAzienda(Invito invito){
        this.gestoreInvitiInviati.InviaInvito(invito);
    }

    /**
     * Crea l'evento e lo mette nella lista, se l'evento non è valido richiede i dati
     * @param nome dell'evento.
     * @param data in cui si svolgerà l'evento.
     * @param luogo nel quale si terrà l'evento.
     * @param descrizione dell'evento.
     * @param capienzaMassima rappresenta il numero massimo di persone che possono partecipare.
     */
    public void creaEvento(String nome, LocalDate data, String luogo, String descrizione, int capienzaMassima){
            try{
                Evento eventoCreato = new Evento(nome,data,luogo,descrizione,capienzaMassima);
            } catch (IllegalArgumentException e){
                System.out.println("Errore nella creazione del evento, riprovare");
            }
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
}
