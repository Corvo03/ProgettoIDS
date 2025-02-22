package unicam.modelli.informazioniAggiuntive;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public abstract class InformazioneAggiuntiva {

    public InformazioneAggiuntiva() {
    }
    @Id
    private String id;
}
