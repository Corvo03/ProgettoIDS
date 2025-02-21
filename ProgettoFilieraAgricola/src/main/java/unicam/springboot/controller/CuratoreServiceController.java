package unicam.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import unicam.modelli.actors.Curatore;
import unicam.modelli.gestori.GestoreSistema;

@RestController
public class CuratoreServiceController {
    private final Curatore curatore = new Curatore();
    private final GestoreSistema gS = GestoreSistema.getInstance();


}
