package unicam.sprinboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import unicam.modelli.actors.Produttore;
import unicam.modelli.actors.azienda.Azienda;
import unicam.sprinboot.repository.ProduttoreListRepository;

public class ProduttoreServiceController {
    @Autowired
    private ProduttoreListRepository produttoreRepository;

    @Autowired
    public ProduttoreServiceController(ProduttoreListRepository aziendaRepository) {
        Azienda pr1 = new Produttore();
        //TODO set info azienda

        //TODO crea altre aziende
    }
}
