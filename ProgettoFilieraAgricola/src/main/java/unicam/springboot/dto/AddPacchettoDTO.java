package unicam.springboot.dto;

import unicam.modelli.elements.Item;

import java.util.ArrayList;
import java.util.List;

public class AddPacchettoDTO extends Item {

    private String nomeAziendaProduttrice;
    private String idAzienda;
    private List<String> listaProdotti;

    public AddPacchettoDTO(String id, double prezzo, String nomeItem, String descrizione, String idAzienda, List<String> listaIdProdotti) {
        super(id, prezzo, nomeItem, descrizione);

        this.listaProdotti = listaIdProdotti;
        this.idAzienda = idAzienda;
    }

    public AddPacchettoDTO(){
        this.listaProdotti = new ArrayList<>();
    }

    public String getNomeAziendaProduttrice() {
        return nomeAziendaProduttrice;
    }

    public void setNomeAziendaProduttrice(String nomeAziendaProduttrice) {
        this.nomeAziendaProduttrice = nomeAziendaProduttrice;
    }

    public String getIdAzienda() {
        return idAzienda;
    }

    public void setIdAzienda(String idAzienda) {
        this.idAzienda = idAzienda;
    }

    public List<String> getListaProdotti() {
        return listaProdotti;
    }

    public void setListaProdotti(List<String> listaProdotti) {
        this.listaProdotti = listaProdotti;
    }
}