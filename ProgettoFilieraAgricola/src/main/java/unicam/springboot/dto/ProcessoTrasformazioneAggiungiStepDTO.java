package unicam.springboot.dto;

import unicam.modelli.informazioniAggiuntive.Fase;

public class ProcessoTrasformazioneAggiungiStepDTO {
    private String id;
    private String nomeProcesso;
    private Fase fase;

    public ProcessoTrasformazioneAggiungiStepDTO(String id, Fase fase, String nomeProcesso) {
        this.id = id;
        this.nomeProcesso = nomeProcesso;
        this.fase = fase;
    }

    public String getNomeProcesso() {
        return nomeProcesso;
    }

    public String getId() {
        return id;
    }

    public Fase getFase() {
        return fase;
    }
}
