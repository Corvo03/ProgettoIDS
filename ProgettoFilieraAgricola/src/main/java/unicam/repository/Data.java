package unicam.repository;

import unicam.modelli.actors.*;
import unicam.modelli.actors.azienda.Azienda;
import unicam.modelli.actors.azienda.InformazioniSensibili;
import unicam.modelli.actors.azienda.Profilo;
import unicam.modelli.elements.Biglietto;
import unicam.modelli.elements.Prodotto;
import unicam.modelli.inviti.Evento;
import unicam.modelli.inviti.Invito;

import java.time.LocalDate;
import java.util.*;

public class Data {
    public static List<Biglietto> biglietti = new ArrayList<>();
    public static List<Invito> inviti = new ArrayList<>();
    public static List<Evento> eventi = new ArrayList<>();
    public static List<Azienda> aziende = new ArrayList<>();
    public static List<AnimatoreFiliera> animatori = new ArrayList<>();
    public static List<Profilo> profili = new ArrayList<>();
    private static int idAziende = 0;
    private static Data istance;


    private Data() {
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
                prod.creaProdotto(10.F + i, "Prodotto" + i, "Descrizione" + i, null);
            }
        }
    }

    private void riempiBiglietti() {
    }

    private void riempiInviti() {

    }

    private void riempiEventi() {
        for (int i = 1; i <= 5; i++) {
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

    public Evento getEventoById(String id) {
        for (Evento evento : eventi) {
            if (Objects.equals(evento.getId(), id))
                return evento;
        }
        return null;
    }
}
