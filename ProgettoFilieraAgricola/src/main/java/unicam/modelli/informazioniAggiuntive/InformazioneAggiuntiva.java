package unicam.modelli.informazioniAggiuntive;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * Classe astratta che rappresenta un'informazione aggiuntiva,
 * come ad esempio Metodi di Produzione o Processi di Trasformazione.
 */
@Entity
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = MetodoProduzione.class, name = "concreta"),
        @JsonSubTypes.Type(value = ProcessoTrasformazione.class, name = "concreta")

})
public abstract class InformazioneAggiuntiva {
    @Id
    private String id;

    public InformazioneAggiuntiva(String id) {
        this.id = id;
    }
    public InformazioneAggiuntiva() {
    }
}
