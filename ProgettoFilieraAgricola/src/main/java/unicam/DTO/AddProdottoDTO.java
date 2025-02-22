package unicam.DTO;

import unicam.modelli.actors.azienda.Azienda;
import unicam.modelli.informazioniAggiuntive.InformazioneAggiuntiva;

public class AddProdottoDTO {
    private String idAzienda;
    private float prezzo;
    private String nome;
    private String descrizione;
    private InformazioneAggiuntiva informazioneAggiuntiva;

    public AddProdottoDTO(String idAzienda, float prezzo,
                          String nome, String descrizione,
                          InformazioneAggiuntiva informazioneAggiuntiva){
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

    public Azienda getAzienda() {
        return null;
    }
}
