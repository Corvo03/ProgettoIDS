package unicam.modelli.inviti;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public abstract class PartecipanteEvento {
    @Id
    private String id;
    public GestoreInvitiRicevuti getGestoreInvitiRicevuti() {
        return null;
    }
}
