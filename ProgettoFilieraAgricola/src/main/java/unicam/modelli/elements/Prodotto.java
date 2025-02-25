package unicam.modelli.elements;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import unicam.modelli.gestori.GestoreSistema;
import unicam.modelli.informazioniAggiuntive.InformazioneAggiuntiva;
import unicam.modelli.actors.azienda.Azienda;

import java.util.ArrayList;
import java.util.List;

/**
 * Rappresenta un prodotto che può essere venduto nel marketplace
 * dopo essere stato approvato e caricato
 */
@Entity
public class Prodotto extends Item {
    @OneToOne
    private Azienda aziendaProduttrice;
    @OneToMany
    private List<Certificato> listaCertificati;
    @OneToOne
    private InformazioneAggiuntiva informazioneAggiuntiva;

    /**
     * Crea un prodotto con i dati passati
     * @param id
     * @param prezzo
     * @param nomeItem
     * @param descrizione
     * @param aziendaProduttrice
     * @param informazione
     */
    public Prodotto(String id, double prezzo, String nomeItem, String descrizione, Azienda aziendaProduttrice, InformazioneAggiuntiva informazione) {
        super(id, prezzo, nomeItem, descrizione);
        this.aziendaProduttrice = aziendaProduttrice;
        listaCertificati = new ArrayList<Certificato>();
        informazioneAggiuntiva = informazione;

    }

    /**
     * Crea un prodotto con i dati passati
     * @param id
     * @param prezzo
     * @param nome
     * @param descrizione
     * @param aziendaProduttrice
     */
    public Prodotto(String id, double prezzo, String nome, String descrizione, Azienda aziendaProduttrice) {
        super(id, prezzo, nome, descrizione);
        this.aziendaProduttrice = aziendaProduttrice;
        listaCertificati = new ArrayList<Certificato>();

    }

    public Prodotto() {
    }

    public Azienda getAziendaProduttrice() {
        return aziendaProduttrice;
    }

    public List<Certificato> getListaCertificati() {
        return listaCertificati;
    }

    public InformazioneAggiuntiva getInformazioneAggiuntiva() {
        return informazioneAggiuntiva;
    }

    public void setListaCertificati(List<Certificato> listaCertificati) {
        this.listaCertificati = listaCertificati;
    }

    /**
     * Permette di aggiungere un certificato al prodotto.
     *
     * @param certificato da aggiungere al prodotto.
     * @throws NullPointerException     se il certificato non è valido.
     * @throws IllegalArgumentException se il certificato non è presente nella lista dei certificati disponibili.
     */
    public void addCertificato(Certificato certificato) {
        if (certificato == null)
            throw new NullPointerException("Certificato non trovato");
        if (!GestoreSistema.getInstance().containsCertificato(certificato))
            throw new IllegalArgumentException("Certificato non esistente");
        if (!listaCertificati.contains(certificato))
            listaCertificati.add(certificato);
        //se il certificato è già presente non viene inserito nuovamente
    }

    public Azienda getAzienda() {
        return aziendaProduttrice;
    }

}
