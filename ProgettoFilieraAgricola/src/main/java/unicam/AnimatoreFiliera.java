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
     * il mittente realtivo a questo animatore
     */
    private GestoreStock gestoreStock;
    /**
     * il mittente realtivo a questo animatore
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
     * Crea un biglietto con le seguenti caratteristiche:
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
    public void aggiungiBiglietti(Evento evento) {
        //todo
    }

    /**
     * delega l'invito di un'azienda al mittente
     * @param evento
     * @param azienda
     * @param dataCreazione
     * @param dataScadenza
     */
    public void invitaAzienda(Evento evento, Azienda azienda, Date dataCreazione, Date dataScadenza){
        this.mittenteInvito.inviaInvito(this,evento,(PartecipanteEvento) azienda, dataCreazione,dataScadenza);
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


    //TODO crea biglietto passando come parametro l'evento, il biglietto deve essere verificato
    //     il gestore info inserirà nello stock dell'animatore se approvato.
}
