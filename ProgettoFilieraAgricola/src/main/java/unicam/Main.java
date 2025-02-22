package unicam;

import unicam.modelli.actors.Acquirente;
import unicam.modelli.actors.Curatore;
import unicam.modelli.actors.Produttore;
import unicam.modelli.elements.ElementoMarketplace;
import unicam.modelli.gestori.GestoreInformazioni;
import unicam.modelli.gestori.GestoreSistema;
import unicam.modelli.marketplace.Bancomat;
import unicam.modelli.marketplace.InformazioneDaApprovare;

public class Main {
    public static void main(String[] args) {
        //produttore crea prodotti e vedo sta stanno dentro gestoreinformazioni
        Produttore produttore = new Produttore("produttore1", "prod@prod.a", null, null);
        produttore.creaProdotto(10.0f, "Prodotto1", "Descrizione1", null,"aaa");
        produttore.creaProdotto(20.0f, "Prodotto2", "Descrizione2", null,"bbb");
        System.out.println("Prodotti creati:");
        for (InformazioneDaApprovare info : GestoreInformazioni.getInstance().getInformazioniDaApprovare()) {
            System.out.println(info);
        }

        //curatore approva prodotti e verifico che siano stati aggiunti a marketplace
        Curatore curatore = new Curatore("Cur1", "cur1@abc.com");
        curatore.approvaInformazione(GestoreInformazioni.getInstance().getInformazioniDaApprovare().getFirst());
        curatore.approvaInformazione(GestoreInformazioni.getInstance().getInformazioniDaApprovare().getFirst());
        //ricarica elementi e diventano disponibili nel marketplace
        produttore.getGestoreStock().ricaricaProdotto(produttore.getGestoreStock().getListaStock().get(0), 2);
        produttore.getGestoreStock().ricaricaProdotto(produttore.getGestoreStock().getListaStock().get(1), 10);
        System.out.println("Elementi disponibili nel marketplace:");
        for (ElementoMarketplace elemento : GestoreSistema.getInstance().getElementiDisponibiliMarketplace()) {
            System.out.println(elemento.getId());
            System.out.println(elemento.getStock().getItem().getNomeItem());
            System.out.println(elemento.getStock().getItem().getPrezzo());
            System.out.println(elemento.getStock().getQuantita());
            System.out.println("\n");
        }

        //acquirente compra e verifico che siano stati aggiornati i prodotti in marketplace
        Acquirente acquirente = new Acquirente("email", "nomeUtente");
        acquirente.aggiungiElementoAlCarrello(GestoreSistema.getInstance().getElementiDisponibiliMarketplace().getFirst(),1);
        acquirente.aggiungiElementoAlCarrello(GestoreSistema.getInstance().getElementiDisponibiliMarketplace().get(1),3);
        acquirente.completaAcquisto(new Bancomat());
        System.out.println("Dopo acquisto");
        for (ElementoMarketplace elemento : GestoreSistema.getInstance().getElementiDisponibiliMarketplace()) {
            System.out.println(elemento.getId());
            System.out.println(elemento.getStock().getItem().getNomeItem());
            System.out.println(elemento.getStock().getItem().getPrezzo());
            System.out.println(elemento.getStock().getQuantita());
            System.out.println("\n");
        }
    }
}
