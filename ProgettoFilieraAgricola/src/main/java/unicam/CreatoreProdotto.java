package unicam;

import java.util.List;

public interface CreatoreProdotto {
    Prodotto creaProdotto(Float prezzo, String nome, String descrizione, List<Certificato> listaCertificati);
}