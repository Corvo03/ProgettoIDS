package unicam;

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

    public List<InformazioneDaApprovare> getInformazioniDaApprovare() {
        return new ArrayList<>(informazioniDaApprovare.keySet());
    }

    public void informazioneApprovata(InformazioneDaApprovare informazione) {
        if (!informazioniDaApprovare.containsKey(informazione)) {
            throw new IllegalArgumentException("informazione non presente");
        }
        if (informazione instanceof Prodotto prodotto) {
            Azienda azienda = prodotto.getAzienda();
            azienda.getGestoreStock().aggiungiStock(new Stock(prodotto));
        }
        else if (informazione instanceof Pacchetto pacchetto) {
            Azienda azienda = pacchetto.getAzienda();
            azienda.getGestoreStock().aggiungiStock(new Stock(pacchetto));
        }
        else if (informazione instanceof Biglietto biglietto){
            AnimatoreFiliera animatore = biglietto.getAnimatore();
            animatore.getGestoreStock().aggiungiStock(new Stock(biglietto));
        }
        else if (informazione instanceof InformazioniSensibili informazioniSensibili){
            Azienda azienda = (Azienda) informazioniDaApprovare.get(informazione);
            azienda.setInformazioniSensibili(informazioniSensibili);
        }
        informazioniDaApprovare.remove(informazione);
    }

    public void informazioneRifiutata(InformazioneDaApprovare informazione) {
        if (!informazioniDaApprovare.containsKey(informazione)) {
            throw new IllegalArgumentException("informazione non presente");
        }
        //todo aggiungere modo per arrivare al gestoreItemRifiutati
        informazioniDaApprovare.remove(informazione);
    }
}
