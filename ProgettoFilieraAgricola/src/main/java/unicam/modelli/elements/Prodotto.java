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

@Entity
public class Prodotto extends Item {
    @Id
    private String id;
    @OneToOne
    private Azienda aziendaProduttrice;
    @OneToMany
    private List<Certificato> listaCertificati;
    @OneToOne
    private InformazioneAggiuntiva informazioneAggiuntiva;

    public Prodotto(double prezzo, String nomeItem, String descrizione, Azienda aziendaProduttrice, InformazioneAggiuntiva informazione, String id) {
        super(prezzo, nomeItem, descrizione);
        this.aziendaProduttrice = aziendaProduttrice;
        listaCertificati = new ArrayList<Certificato>();
        informazioneAggiuntiva = informazione;
        this.id = id;
    }

    public Prodotto(double prezzo, String nome, String descrizione, Azienda aziendaProduttrice, String id) {
        super(prezzo, nome, descrizione);
        this.aziendaProduttrice = aziendaProduttrice;
        listaCertificati = new ArrayList<Certificato>();
        this.id = id;
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

    public void setId(String id) {
        this.id = id;
    }
}
