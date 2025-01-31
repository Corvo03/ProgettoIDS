package unicam;

public class Main {
    public static void main(String[] args) {
        //produttore crea prodotti e vedo sta stanno dentro gestoreinformazioni
        Produttore produttore = new Produttore();
        produttore.creaProdotto(10.0f, "Prodotto1", "Descrizione1", null);
        produttore.creaProdotto(20.0f, "Prodotto2", "Descrizione2", null);
        for (InformazioneDaApprovare info : GestoreInformazioni.getInstance().getInformazioniDaApprovare()) {
            System.out.println(info);
        }

        //curatore approva prodotti e verifico che siano stati aggiunti a marketplace
        Curatore curatore = new Curatore();
        curatore.approvaInformazione(GestoreInformazioni.getInstance().getInformazioniDaApprovare().getFirst());
        curatore.approvaInformazione(GestoreInformazioni.getInstance().getInformazioniDaApprovare().getFirst());
        for (ElementoMarketplace elemento : GestoreMarketplace.getInstance().getMarketPlace().getListaElementi()) {
            System.out.println(elemento.getId());
            System.out.println(elemento.getStock().getItem().getNomeItem());
            System.out.println(elemento.getStock().getItem().getPrezzo());
            System.out.println(elemento.getStock().getQuantita());
            System.out.println("\n");
        }

        //produttore ricarica prodotti, acquirente compra e verifico che siano stati aggiornati i prodotti in marketplace
        produttore.getGestoreStock().ricaricaProdotto(produttore.getGestoreStock().getListaStock().get(0), 1);
        produttore.getGestoreStock().ricaricaProdotto(produttore.getGestoreStock().getListaStock().get(1), 10);
        Acquirente acquirente = new Acquirente("email", "password", "nomeUtente");
        acquirente.aggiungiElementoAlCarrello(GestoreMarketplace.getInstance().getMarketPlace().getListaElementi().getFirst(),1);
        acquirente.aggiungiElementoAlCarrello(GestoreMarketplace.getInstance().getMarketPlace().getListaElementi().get(1),3);
        acquirente.completaAcquisto(new MetodoPagamento());
        for (ElementoMarketplace elemento : GestoreMarketplace.getInstance().getMarketPlace().getListaElementi()) {
            System.out.println(elemento.getId());
            System.out.println(elemento.getStock().getItem().getNomeItem());
            System.out.println(elemento.getStock().getItem().getPrezzo());
            System.out.println(elemento.getStock().getQuantita());
            System.out.println("\n");
        }
    }
}
