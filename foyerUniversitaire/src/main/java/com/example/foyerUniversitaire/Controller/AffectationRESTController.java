package com.example.foyerUniversitaire.Controller;

import com.example.foyerUniversitaire.Entity.Universite;
import com.example.foyerUniversitaire.Service.AffectationServiceImp;
import com.example.foyerUniversitaire.Service.DesaffectationServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/affectation")
public class AffectationRESTController {
    @Autowired
    private AffectationServiceImp affectationServiceImp;
    @Autowired
    private DesaffectationServiceImp desaffectationServiceImp;
    @PutMapping("/FoyerToUniversite/{idFoyer}/{idUniversite}")

    public Universite affecterFoyerUniversite(@PathVariable Long idUniversite, @PathVariable Long idFoyer){
        Universite universite= affectationServiceImp.affecterFoyerUniversite(idFoyer,idUniversite);
        return universite;
    }
    @PostMapping("/nonFoyerUniversite/{idUniversite}")
    public  Universite desaffecterFoyerUniversite( @PathVariable Long idUniversite){
        return desaffectationServiceImp.desaffecterFoyerUniversite(idUniversite);
    }

}
