package unicam.springboot.dto;

import unicam.modelli.informazioniAggiuntive.MetodoProduzione;

public class MetodoProduzioneAggiungiMetodoDTO {
    private String id;
    private MetodoProduzione metodoProduzione;

    public MetodoProduzioneAggiungiMetodoDTO(String id, MetodoProduzione metodoProduzione) {
        this.id = id;
        this.metodoProduzione = metodoProduzione;
    }

    public String getId() {
        return id;
    }

    public MetodoProduzione getMetodoProduzione() {
        return metodoProduzione;
    }
}
