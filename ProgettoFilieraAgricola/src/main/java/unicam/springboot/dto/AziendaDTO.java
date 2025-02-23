package unicam.springboot.dto;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import unicam.modelli.actors.azienda.Azienda;
import unicam.modelli.actors.azienda.InformazioniSensibili;
import unicam.modelli.actors.azienda.Profilo;
import unicam.modelli.gestori.GestoreStock;
import unicam.modelli.inviti.GestoreInvitiRicevuti;

import java.util.List;

public class AziendaDTO {
    private String id;
    private List<String> indirizzoSediProduttive;
    private InformazioniSensibili informazioniSensibili;
    private ProfiloDTO profilo;

    public AziendaDTO(Azienda azienda) {
        this.id = azienda.getId();
        this.indirizzoSediProduttive = azienda.getIndirizzoSediProduttive();
        this.informazioniSensibili = azienda.getInformazioniSensibili();
        this.profilo = new ProfiloDTO(azienda.getProfilo());
    }

    public String getId() {
        return id;
    }

    public List<String> getIndirizzoSediProduttive() {
        return indirizzoSediProduttive;
    }

    public InformazioniSensibili getInformazioniSensibili() {
        return informazioniSensibili;
    }

    public ProfiloDTO getProfilo() {
        return profilo;
    }
}
