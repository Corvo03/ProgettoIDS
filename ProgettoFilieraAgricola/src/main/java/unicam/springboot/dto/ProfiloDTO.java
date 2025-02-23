package unicam.springboot.dto;

import unicam.modelli.actors.azienda.Profilo;

public class ProfiloDTO {
    private String nome;
    private String descrizione;

    public ProfiloDTO(String nome, String descrizione) {
        this.nome = nome;
        this.descrizione = descrizione;
    }

    public ProfiloDTO(Profilo profilo) {
        this.nome = profilo.getNomeProfilo();
        this.descrizione = profilo.getDescrizione();
    }

    public String getNome() {
        return nome;
    }

    public String getDescrizione() {
        return descrizione;
    }
}
