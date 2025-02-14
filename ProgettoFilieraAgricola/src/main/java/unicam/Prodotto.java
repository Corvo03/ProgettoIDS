package unicam;

import java.util.ArrayList;
import java.util.List;

public class Prodotto extends Item{
    private final Azienda aziendaProduttrice;
    private List<Certificato> listaCertificati;
    private InformazioneAggiuntiva informazioneAggiuntiva;

    public Prodotto(double prezzo, String nomeItem, String descrizione, Azienda aziendaProduttrice, InformazioneAggiuntiva informazione) {
        super(prezzo, nomeItem, descrizione);
        this.aziendaProduttrice = aziendaProduttrice;
        listaCertificati = new ArrayList<Certificato>();
        informazioneAggiuntiva = informazione;
    }

    public Prodotto(double prezzo, String nome, String descrizione, Azienda aziendaProduttrice) {
        super(prezzo, nome, descrizione);
        this.aziendaProduttrice = aziendaProduttrice;
        listaCertificati = new ArrayList<Certificato>();;
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
     * @param certificato da aggiungere al prodotto.
     * @throws NullPointerException se il certificato non è valido.
     */
    public void addCertificato(Certificato certificato){
        if(certificato == null)
            throw new NullPointerException("Certificato non trovato");
        if(!listaCertificati.contains(certificato))
            listaCertificati.add(certificato);
        //se il certificato è già presente non viene inserito nuovamente
    }

    public Azienda getAzienda() {
        return aziendaProduttrice;
    }
}
