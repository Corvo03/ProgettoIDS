package unicam.springboot.dto;

import unicam.modelli.informazioniAggiuntive.InformazioneAggiuntiva;

public class AddProdottoDTO {
    private String idProdotto;
    private String idAzienda;
    private float prezzo;
    private String nome;
    private String descrizione;
    private InformazioneAggiuntiva informazioneAggiuntiva;


    public AddProdottoDTO(String idProdotto, String idAzienda, float prezzo,
                          String nome, String descrizione,
                          InformazioneAggiuntiva informazioneAggiuntiva) {
        this.idProdotto = idProdotto;
        this.idAzienda = idAzienda;
        this.prezzo = prezzo;
        this.nome = nome;
        this.descrizione = descrizione;
        this.informazioneAggiuntiva = informazioneAggiuntiva;

    }

    public AddProdottoDTO() {
    }


    public String getIdAzienda() {
        return idAzienda;
    }

    public InformazioneAggiuntiva getInformazioneAggiuntiva() {
        return informazioneAggiuntiva;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getNome() {
        return nome;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public String getIdProdotto() {
        return idProdotto;
    }
}
