package com.example.foyerUniversitaire.Controller;

import com.example.foyerUniversitaire.Entity.Universite;
import com.example.foyerUniversitaire.Service.AffectationServiceImp;
import com.example.foyerUniversitaire.Service.DesaffectationServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/affectation")
public class AffectationRESTController {
    @Autowired
    private AffectationServiceImp affectationServiceImp;
    @Autowired
    private DesaffectationServiceImp desaffectationServiceImp;
    @PostMapping("/FoyerToUniversite/{idFoyer}/{nomUniversite}")

    public ResponseEntity<Universite> affecterFoyerUniversite(@PathVariable String nomUniversite,  @PathVariable Long idFoyer){
        Universite universite= affectationServiceImp.affecterFoyerUniversite(idFoyer,nomUniversite);
        if (universite!=null){
            return new ResponseEntity<>(universite, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @PostMapping("/nonFoyerUniversite/{idUniversite}")
    public  Universite desaffecterFoyerUniversite( @PathVariable Long idUniversite){
        return desaffectationServiceImp.desaffecterFoyerUniversite(idUniversite);
    }

}
