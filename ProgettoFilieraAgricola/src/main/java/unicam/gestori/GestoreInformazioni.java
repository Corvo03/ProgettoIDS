package unicam.gestori;

import unicam.marketplace.InformazioneDaApprovare;
import unicam.actors.azienda.InformazioniSensibili;
import unicam.marketplace.RichiedenteVerificaInformazione;
import unicam.actors.AnimatoreFiliera;
import unicam.actors.azienda.Azienda;
import unicam.elements.Biglietto;
import unicam.elements.Pacchetto;
import unicam.elements.Prodotto;
import unicam.elements.Stock;

import java.util.*;

public class GestoreInformazioni {
    private static GestoreInformazioni istanza;
    private final Map<InformazioneDaApprovare, RichiedenteVerificaInformazione> informazioniDaApprovare;

    private GestoreInformazioni() {
        this.informazioniDaApprovare = new HashMap<>();
    }

    /**
     * Ritorna il puntatore all'istanza dell'oggetto (se esiste), altrimenti ne crea una nuova.
     * La classe è un Singleton, ne esiste una sola istanza.
     *
     * @return l'unica istanza della classe
     */
    public static GestoreInformazioni getInstance() {
        if (istanza == null)
            istanza = new GestoreInformazioni();
        return istanza;
    }

    /**
     * Aggiunge un'informazione da approvare alla lista delle informazioni da approvare.
     * Se l'informazione è già presente, lancia un'eccezione.
     *
     * @param informazione l'informazione da approvare
     * @param richiedente  il richiedente che ha richiesto la verifica dell'informazione
     */
    public void aggiungiInformazioneDaApprovare(InformazioneDaApprovare informazione,
                                                RichiedenteVerificaInformazione richiedente) {
        if (informazione == null)
            throw new NullPointerException("informazione null");
        if (informazioniDaApprovare.containsKey(informazione))
            throw new IllegalArgumentException("informazione già presente");
        informazioniDaApprovare.put(informazione, richiedente);
    }

    /**
     * Ritorna la lista delle informazioni da approvare.
     *
     * @return la lista delle informazioni da approvare
     */
    public List<InformazioneDaApprovare> getInformazioniDaApprovare() {
        return new ArrayList<>(informazioniDaApprovare.keySet());
    }

    /**
     * Data un informazione approvata, la rimuove dalla lista delle informazioni da approvare
     * e crea lo Stock corrispondente.
     *
     * @param informazione
     */
    public void informazioneApprovata(InformazioneDaApprovare informazione) {
        if (!informazioniDaApprovare.containsKey(informazione)) {
            throw new IllegalArgumentException("informazione non presente");
        }

        switch (informazione) {
            case Prodotto prodotto -> {
                Azienda azienda = prodotto.getAzienda();
                azienda.getGestoreStock().aggiungiStock(prodotto);
            }
            case Pacchetto pacchetto -> {
                Azienda azienda = pacchetto.getAzienda();
                azienda.getGestoreStock().aggiungiStock(pacchetto);
            }
            case Biglietto biglietto -> {
                AnimatoreFiliera animatore = biglietto.getAnimatore();
                animatore.getGestoreStock().aggiungiStock(biglietto);
            }
            case InformazioniSensibili informazioniSensibili -> {
                Azienda azienda = (Azienda) informazioniDaApprovare.get(informazione);
                azienda.setInformazioniSensibili(informazioniSensibili);
            }
            default -> throw new IllegalArgumentException("Tipo di informazione non supportato");
        }

        informazioniDaApprovare.remove(informazione);
    }


    /**
     * Data un informazione rifiutata, la rimuove dalla lista delle informazioni da approvare.
     * E se è un prodotto o pacchetto, viene aggiunto alla lista degli item rifiutati.
     * @param informazione
     */
    public void informazioneRifiutata(InformazioneDaApprovare informazione) {
        if (!informazioniDaApprovare.containsKey(informazione)) {
            throw new IllegalArgumentException("informazione non presente");
        }
        //todo aggiungere modo per arrivare al gestoreItemRifiutati
        informazioniDaApprovare.remove(informazione);
    }
}
