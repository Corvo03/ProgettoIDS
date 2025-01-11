package unicam;

import java.util.ArrayList;
import java.util.List;

public class Prodotto extends Item{
    private final Azienda aziendaProduttrice;
    private List<Certificato> listaCertificati;

    public Prodotto(float prezzo, String nomeItem, String descrizione, Azienda aziendaProduttrice) {
        super(prezzo, nomeItem, descrizione);
        this.aziendaProduttrice = aziendaProduttrice;
        listaCertificati = new ArrayList<Certificato>();
    }

    public Prodotto(float prezzo, String nomeItem, String descrizione, int quantita, Azienda aziendaProduttrice) {
        super(prezzo, nomeItem, descrizione, quantita);
        this.aziendaProduttrice = aziendaProduttrice;
        listaCertificati = new ArrayList<Certificato>();
    }


    public Azienda getAziendaProduttrice() {
        return aziendaProduttrice;
    }

    public List<Certificato> getListaCertificati() {
        return listaCertificati;
    }

    public void setListaCertificati(List<Certificato> listaCertificati) {
        this.listaCertificati = listaCertificati;
    }

    public void addCertificato(Certificato certificato){
        if(certificato == null)
            throw new NullPointerException("Certificato non trovato");
        if(!listaCertificati.contains(certificato))
            listaCertificati.add(certificato);
        //se il certificato è già presente non viene inserito nuovamente
    }
}
