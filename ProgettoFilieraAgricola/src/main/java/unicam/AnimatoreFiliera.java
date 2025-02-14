package unicam;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * contiene la lista degli eventi
 * si occupa di delegare le operazioni per
 * creare gli eventi, mandare inviti e mettere biglietti sul Market
 */
public non-sealed class AnimatoreFiliera extends UtenteAutenticato implements RichiedenteVerificaInformazione {
    /**
     * lista di tutti gli eventi creati dall'animatore
     */
    private List<Evento> listaEventi;
    /**
     * il gestore di tutti gli stock di ogni biglietto creato
     */
    private GestoreStock gestoreStock;
    /**
     * il mittente relativo a questo animatore
     */
    private MittenteInvito mittenteInvito;


    /**
     *
     * @param email
     * @param password
     * @param nomeUtente
     */
    public AnimatoreFiliera(String email, String password, String nomeUtente) {
        super(email, password, nomeUtente);
        this.mittenteInvito = new MittenteInvito();
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
    public Biglietto  creaBiglietto(float prezzo, String nome, String descrizione, AnimatoreFiliera animatoreFiliera, Evento evento) {
        ItemFactory fact = new CreatorBiglietto(nome, descrizione, prezzo, this, evento);
        Biglietto biglietto = (Biglietto) fact.createItem();
        this.richiediVerificaInformazioni(biglietto);
        return biglietto; //TODO è necessario che ritorni un biglietto? dove lo uso?
    }

    /**
     * riempie lo stock di biglietti
     * @param biglietto
     */
    public void aggiungiBiglietti(Biglietto biglietto, int quantita) {
        if(this.gestoreStock.getListaStock().contains(biglietto)){
            int index = this.gestoreStock.getListaStock().indexOf(biglietto);
            this.gestoreStock.getListaStock().get(index).addQuantita(quantita);
        }

    }

    /**
     * delega l'invito di un'azienda al mittente
     * @param evento
     * @param azienda
     * @param dataCreazione
     * @param dataScadenza
     */
    public void invitaAzienda(Evento evento, Azienda azienda, LocalDate dataCreazione, LocalDate dataScadenza){
        this.mittenteInvito.inviaInvito(this,evento,(PartecipanteEvento) azienda, LocalDate.now(),dataScadenza);
    }

    /**
     * crea l'evento e lo mette nella lista, se l'evento non è valido richiede i dati
     * @param nome
     * @param data
     * @param luogo
     * @param descrizione
     * @param capienzaMassima
     */
    public void creaEvento(String nome, LocalDate data, String luogo, String descrizione, int capienzaMassima){
            try{
                Evento eventoCreato = new Evento(nome,data,luogo,descrizione,capienzaMassima);
            } catch (IllegalArgumentException e){
                System.out.println("Errore nella creazione del evento, riprovare");
            }
    }

    public GestoreStock getGestoreStock() {
        return gestoreStock;
    }

    public List<Evento> getListaEventi() {
        return listaEventi;
    }

    public MittenteInvito getMittenteInvito() {
        return mittenteInvito;
    }
}
