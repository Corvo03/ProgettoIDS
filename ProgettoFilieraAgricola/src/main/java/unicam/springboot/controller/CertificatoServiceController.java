package unicam.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.modelli.actors.ResponsabilePiattaforma;
import unicam.modelli.elements.Certificato;
import unicam.modelli.gestori.GestoreSistema;
import java.util.List;

@RestController
public class CertificatoServiceController {

     private final GestoreSistema gS = GestoreSistema.getInstance();
     private final ResponsabilePiattaforma responsabilePiattaforma = new ResponsabilePiattaforma();

     @GetMapping("/certificato")
     public ResponseEntity<List<Certificato>> getCertificato(){
         return new ResponseEntity<>(gS.getListaCertificati(), HttpStatus.OK);
     }

     @PostMapping("/certificato")
     public ResponseEntity<String> addCertificato(@RequestBody Certificato certificato){
         gS.creaCertificato(certificato, responsabilePiattaforma);
         return new ResponseEntity<>("certificato creato", HttpStatus.CREATED);
     }

     @GetMapping("/certificato/{id}")
     public ResponseEntity<Certificato> getCertificato(@PathVariable String id){
         for(Certificato certificato : gS.getListaCertificati()){
             if(certificato.getId().equals(id)){
                 return new ResponseEntity<>(certificato, HttpStatus.OK);
             }
         }
         return null;
     }


}
