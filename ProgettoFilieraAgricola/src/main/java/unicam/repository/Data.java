package unicam.repository;

import unicam.modelli.actors.*;
import unicam.modelli.actors.azienda.Azienda;
import unicam.modelli.actors.azienda.InformazioniSensibili;
import unicam.modelli.actors.azienda.Profilo;
import unicam.modelli.elements.Biglietto;
import unicam.modelli.elements.Item;
import unicam.modelli.elements.Prodotto;

import unicam.modelli.elements.ElementoMarketplace;
import unicam.modelli.gestori.GestoreSistema;
import unicam.modelli.informazioniAggiuntive.MetodoProduzione;
import unicam.modelli.informazioniAggiuntive.ProcessoTrasformazione;
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
    private static int idItem = 1;
    private int idAziende = 1;
    private static Data istance;
    public static List<MetodoProduzione> metodiProduzione = new ArrayList<>();
    public static List<ProcessoTrasformazione> processiTrasformazione = new ArrayList<>();
    public static GestoreSistema gestoreSistema = GestoreSistema.getInstance();


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
                prod.creaProdotto(Integer.toString(idItem++),10.F + i, "Prodotto" + i, "Descrizione" + i, null);
            }
        }

        riempiMetodiProduzione();
        riempiProcessiTrasformazione();
        creaProdotti();
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
                        animatore.invitaAzienda(Integer.toString(i+j),
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
            Produttore prod = new Produttore(Integer.toString(idAziende++),"nomeProduttore" + i, "produttore" + i + "@some.thing", sediProd,
                    new InformazioniSensibili("via sede prod" + i, "prod" + i + "@pec.com",
                            "AziendaProd" + i, "pIvaProd" + i, "codProd" + i),
                    "profiloProduttore" + i, "descrProfiloProduttore" + i
            );
            aziende.add(prod);
            Trasformatore tras = new Trasformatore(Integer.toString(idAziende++),"nomeTrasformatore" + i,
                    "trasformatore" + i + "@some.thing", sediProd,
                    new InformazioniSensibili("via sede trasf" + i, "trasf" + i + "@pec.com",
                            "AziendaTrasf" + i, "pIvaTrasf" + i, "codTrasf" + i),
                    "profiloTrasformatore" + i, "descrTrasformatore" + i
            );
            aziende.add(tras);
            DistributoreTipicita dist = new DistributoreTipicita(Integer.toString(idAziende++),
                    "nomeDistributore" + i, "distributore" + i + "@some.thing", sediProd,
                    new InformazioniSensibili("via sede distr" + i, "distr" + i + "@pec.com",
                            "AziendaDistr" + i, "pIvaDistr" + i, "codDistr" + i),
                    "profiloDistributore" + i, "descrProfiloDistributore" + i
            );
            aziende.add(dist);
        }
    }

    private void riempiAnimatore() {
        for (int i = 1; i <= 15; i++) {
            animatori.add(
                    new AnimatoreFiliera(Integer.toString(i), "animatore" + i + "@some.thing", "utAnimatore" + i));
        }
    }

    private void riempiMetodiProduzione() {
        for (int i = 1; i <= 15; i++) {
            metodiProduzione.add(new MetodoProduzione("Metodo" + i, "DescrizioneMetodo" + i));
        }
    }

    private void riempiProcessiTrasformazione() {
        for (int i = 1; i <= 15; i++) {
            processiTrasformazione.add(new ProcessoTrasformazione("Processo" + i, "DescrizioneProcesso" + i));
        }
    }

    private void creaProdotti() {
        int i = 0;
        for (Azienda azienda : aziende) {
            i++;
            if (azienda instanceof Produttore) {
                ((Produttore) azienda).creaProdotto(i+"a",10.0, "prodotto" + i, "descr" + i, metodiProduzione.getFirst())
                ;
                ((Produttore) azienda).creaProdotto(i+"b", 10.0, "prodotto" + i, "descr" + i, metodiProduzione.getFirst());
            }
            if (azienda instanceof Trasformatore) {
                ((Trasformatore) azienda).creaProdotto(i+"",10.0, "prodotto" + i, "descr" + i, processiTrasformazione.getFirst());
            }
            if (azienda instanceof DistributoreTipicita) {
                ((DistributoreTipicita) azienda).creaProdotto(i+"",10.0, "prodotto" + i, "descr" + i);
            }
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

//    public Evento getEventoById(String id) {
//        for (Evento evento : eventi) {
//            if (Objects.equals(evento.getId(), id))
//                return evento;
//        }
//        return null;
//    }

    public Prodotto getProdottoById(String id) {
        Prodotto prodotto = null;
        for (Azienda azienda : aziende) {
            for (ElementoMarketplace elementoMarketplace : gestoreSistema.getElementiDisponibiliMarketplace()) {
                prodotto = (Prodotto) elementoMarketplace.getStock().getItem();
                if (Objects.equals(prodotto.getNomeItem(), id))
                    return prodotto;
            }
        }
        return null;
    }

    public Item getProdottoByAzienda(String idAzienda, String idProdotto) {
        Azienda azienda = getAziendaById(idAzienda);
        return azienda.getGestoreStock().getStock(idProdotto).getItem();
    }

    public Invito getInvitoById(String idInvito, String idAzienda){
        Azienda azienda = getAziendaById(idAzienda);
        return azienda.getInvito(idInvito);
    }
}
