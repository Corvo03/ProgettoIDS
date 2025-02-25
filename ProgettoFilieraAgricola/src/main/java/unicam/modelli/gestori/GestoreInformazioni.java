package unicam.modelli.gestori;

import unicam.modelli.actors.Curatore;
import unicam.modelli.elements.Item;
import unicam.modelli.marketplace.InformazioneDaApprovare;
import unicam.modelli.actors.azienda.InformazioniSensibili;
import unicam.modelli.marketplace.RichiedenteVerificaInformazione;
import unicam.modelli.actors.azienda.Azienda;

import java.util.*;

/**
 * Classe che si occupa di gestire le informazioni da approvare.
 */
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
     * @param informazione approvata.
     */
    public void informazioneApprovata(InformazioneDaApprovare informazione) {
        if (!informazioniDaApprovare.containsKey(informazione)) {
            throw new IllegalArgumentException("informazione non presente");
        }
        switch (informazione) {
            case Item item -> {
                informazioniDaApprovare.get(informazione).getGestoreStock().aggiungiStock(item);
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
     * @param informazione non approvata.
     */
    public void informazioneRifiutata(InformazioneDaApprovare informazione) {
        if (!informazioniDaApprovare.containsKey(informazione)) {
            throw new IllegalArgumentException("informazione non presente");
        }
        if (informazione instanceof Item item){
            informazioniDaApprovare.get(informazione).getGestoreItemRifiutati()
                    .aggiungiItemRifiutato(item);
        }
        informazioniDaApprovare.remove(informazione);
    }

    public InformazioneDaApprovare getInformazioneDaApprovareDaId(String id) {
        for (InformazioneDaApprovare info : informazioniDaApprovare.keySet()) {
            if (info.getId().equals(id))
                return info;
        }
        return null;
    }
}
