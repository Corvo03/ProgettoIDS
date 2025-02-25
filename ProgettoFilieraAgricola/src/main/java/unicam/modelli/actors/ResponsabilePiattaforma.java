package unicam.modelli.actors;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import unicam.modelli.elements.Certificato;
import unicam.modelli.gestori.GestoreSistema;

/**
 * Responsabile della piattaforma, può creare certificati che verranno
 * usati dalle aziende
 */
@Entity
public class ResponsabilePiattaforma extends UtenteAutenticato {
    @Id
    private String id;
    public ResponsabilePiattaforma(String id,String email, String nomeUtente) {
        super(id,email, nomeUtente);
    }

    public ResponsabilePiattaforma() {
    }

    public void creaCertificato(String id,String nome, String descrizione, UtenteAutenticato utenteAutenticato) {
        Certificato certificato = new Certificato(id,nome, descrizione);
        GestoreSistema.getInstance().creaCertificato(certificato, this);
    }
}
