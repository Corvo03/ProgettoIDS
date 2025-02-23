package unicam.springboot.dto;

import unicam.modelli.actors.azienda.Azienda;
import unicam.modelli.inviti.PartecipanteEvento;

public class PartecipanteEventoDTO {
    private String id;
    private String nome;

    public PartecipanteEventoDTO(PartecipanteEvento p) {
        if(p instanceof Azienda azienda){
            this.id = azienda.getId();
            this.nome = azienda.getNome();
        }
        else
            throw new IllegalArgumentException("Tipo di partecipante evento non gestito");
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
