package unicam.repository;

import unicam.modelli.actors.*;
import unicam.modelli.actors.azienda.Azienda;
import unicam.modelli.actors.azienda.InformazioniSensibili;
import unicam.modelli.actors.azienda.Profilo;
import unicam.modelli.elements.Biglietto;
import unicam.modelli.inviti.Evento;
import unicam.modelli.inviti.Invito;

import java.time.LocalDate;
import java.util.*;

public class Data {
    public List<Biglietto> biglietti;
    public List<Azienda> aziende;
    public List<Invito> inviti;
    public List<AnimatoreFiliera> animatori;
    public List<Profilo> profili;
    private int idAziende = 1;
    private static Data istance;

    private Data() {
        animatori = new ArrayList<>();
        aziende = new ArrayList<>();
        inviti = new ArrayList<>();
        biglietti = new ArrayList<>();
        profili = new ArrayList<>();

        riempiAnimatore();
        riempiAzienda();
        riempiEventi();
        riempiInviti();
        riempiBiglietti();
        riempiAziendeDiProdotti();
    }

    private void riempiAziendeDiProdotti() {
        List<Produttore> listaProduttori = new ArrayList<>();
        for (Azienda azienda : aziende) {
            if (azienda instanceof Produttore produttore) {
                listaProduttori.add(produttore);
            }
        }
        for (Produttore prod : listaProduttori) {
            for (int i = 1; i <= 5; i++) {
                prod.creaProdotto(10.F + i, "Prodotto" + i, "Descrizione" + i, null, Integer.toString(i));
            }
        }
    }

    private void riempiBiglietti() {
    }

    private void riempiInviti() {
        for(int i = 1; i <= 15; i++) {

            AnimatoreFiliera animatore = this.getAnimatoreById(Integer.toString(i));
            Random r = new Random();

            //ogni animatore invita tre azienda in maniera random
            for(int j=1; j<4; j++){
                try{
                    int numEventi = animatore.getListaEventi().size();
                    if(numEventi != 0){
                        animatore.invitaAzienda(
                                animatore.getListaEventi().get(i%animatore.getListaEventi().size()),
                                this.getAziendaById(Integer.toString(r.nextInt(1,15))),
                                "Messaggio invito"+i
                        );
                    }
                    else
                        break;

                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    private void riempiEventi() {
        for (int i = 0; i <= 5; i++) {
            animatori.get(i).creaEvento(Integer.toString(i * 2 + 1), "Evento1Animatore" + i, LocalDate.now(), "Luogo" + i,
                    "DescrEvento", 100);
            animatori.get(i).creaEvento(Integer.toString(i * 2 + 2), "Evento2Animatore" + i, LocalDate.now(), "Luogo" + i,
                    "DescrEvento", 100);
        }
        for (int i = 6; i <= 12; i++) {
            animatori.get(i).creaEvento(Integer.toString(i * 2 + 1), "Evento1Animatore" + i, LocalDate.now(), "Luogo" + i,
                    "DescrEvento", 100);
            animatori.get(i).creaEvento(Integer.toString(i * 2 + 2), "Evento2Animatore" + i, LocalDate.now(), "Luogo" + i,
                    "DescrEvento", 100);
            animatori.get(i).creaEvento(Integer.toString(i * 2 + 3), "Evento3Animatore" + i, LocalDate.now(), "Luogo" + i,
                    "DescrEvento", 100);
        }
    }

    private void riempiAzienda() {
        for (int i = 1; i <= 5; i++) {
            List<String> sediProd = new ArrayList<>();
            sediProd.add("SedeProduttivaPrincipale");
            sediProd.add("SedeProduttivaSecondaria");
            sediProd.add("Prod" + i);
            Produttore prod = new Produttore("nomeProduttore" + i, "produttore" + i + "@some.thing", sediProd,
                    new InformazioniSensibili("via sede prod" + i, "prod" + i + "@pec.com",
                            "AziendaProd" + i, "pIvaProd" + i, "codProd" + i),
                    "profiloProduttore" + i, "descrProfiloProduttore" + i
            );
            prod.setId(Integer.toString(idAziende++));
            aziende.add(prod);
            Trasformatore tras = new Trasformatore(
                    "nomeTrasformatore" + i, "trasformatore" + i + "@some.thing", sediProd,
                    new InformazioniSensibili("via sede trasf" + i, "trasf" + i + "@pec.com",
                            "AziendaTrasf" + i, "pIvaTrasf" + i, "codTrasf" + i),
                    "profiloTrasformatore" + i, "descrTrasformatore" + i
            );
            tras.setId(Integer.toString(idAziende++));
            aziende.add(tras);
            DistributoreTipicita dist = new DistributoreTipicita(
                    "nomeDistributore" + i, "distributore" + i + "@some.thing", sediProd,
                    new InformazioniSensibili("via sede distr" + i, "distr" + i + "@pec.com",
                            "AziendaDistr" + i, "pIvaDistr" + i, "codDistr" + i),
                    "profiloDistributore" + i, "descrProfiloDistributore" + i
            );
            dist.setId(Integer.toString(idAziende++));
            aziende.add(dist);
        }
    }

    private void riempiAnimatore() {
        for (int i = 1; i <= 15; i++) {
            animatori.add(
                    new AnimatoreFiliera(Integer.toString(i), "animatore" + i + "@some.thing", "utAnimatore" + i));
        }
    }


    public static Data getIstance() {
        if (istance == null) {
            istance = new Data();
        }
        return istance;
    }

    public AnimatoreFiliera getAnimatoreById(String id) {
        for (AnimatoreFiliera anim : animatori) {
            if (Objects.equals(anim.getId(), id))
                return anim;
        }
        return null;
    }

    public Evento getEventoById(String idEvento, String idAnimatore) {
        for (Evento evento : getAnimatoreById(idAnimatore).getListaEventi()) {
            if (Objects.equals(evento.getId(), idEvento))
                return evento;
        }
        return null;
    }

    public Azienda getAziendaById(String id) {
        for (Azienda azienda : aziende) {
            if (Objects.equals(azienda.getId(), id))
                return azienda;
        }
        return null;
    }
}
