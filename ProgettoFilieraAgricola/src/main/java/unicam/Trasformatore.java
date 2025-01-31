package unicam;

import java.util.List;

public class Trasformatore extends Azienda implements CreatoreProdotto {

    public Trasformatore() {
    }

    @Override
    public Prodotto creaProdotto(Float prezzo, String nome, String descrizione, List<Certificato> listaCertificati) {
        if (prezzo <= 0)
            throw new IllegalArgumentException("Prezzo non valido");
        if (nome == null || nome.isEmpty())
            throw new IllegalArgumentException("Nome prodotto non valido");
        if (descrizione == null || descrizione.isEmpty())
            throw new IllegalArgumentException("Descrizione non valida");
        Prodotto prodotto = new Prodotto(prezzo, nome, descrizione, this);
        if (listaCertificati != null)
            prodotto.setListaCertificati(listaCertificati);
        this.richiediVerificaInformazioni(prodotto);
        return prodotto;
    }
}
