package unicam.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.modelli.actors.ResponsabilePiattaforma;
import unicam.modelli.elements.Certificato;
import unicam.modelli.gestori.GestoreSistema;
import unicam.repository.Data;

import java.util.List;

@RestController
public class CertificatoServiceController {

    Data data = Data.getIstance();


     @GetMapping("/certificato")
     public ResponseEntity<List<Certificato>> getCertificato(){
         return new ResponseEntity<>(Data.gestoreSistema.getListaCertificati(), HttpStatus.OK);
     }

     @PostMapping("/certificato")
     public ResponseEntity<String> addCertificato(@RequestBody Certificato certificato){
         Data.gestoreSistema.creaCertificato(certificato, Data.responsabilePiattaforma);
         return new ResponseEntity<>("certificato creato", HttpStatus.CREATED);
     }

     @GetMapping("/certificato/{id}")
     public ResponseEntity<Certificato> getCertificato(@PathVariable String id){
         for(Certificato certificato : Data.gestoreSistema.getListaCertificati()){
             if(certificato.getId().equals(id)){
                 return new ResponseEntity<>(certificato, HttpStatus.OK);
             }
         }
         return null;
     }


}
