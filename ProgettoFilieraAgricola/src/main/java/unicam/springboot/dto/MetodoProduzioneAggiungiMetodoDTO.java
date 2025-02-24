package unicam.springboot.dto;

import unicam.modelli.informazioniAggiuntive.MetodoProduzione;

public class MetodoProduzioneAggiungiMetodoDTO {
    private String id;
    private String idProduttore;
    private String nome;
    private String descrizione;

    public MetodoProduzioneAggiungiMetodoDTO(String idProduttore, String id, String nome, String descrizione) {
        this.idProduttore = idProduttore;
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
    }

    public String getId() {
        return id;
    }

    public String getIdProduttore() {
        return idProduttore;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getNome() {
        return nome;
    }
}
