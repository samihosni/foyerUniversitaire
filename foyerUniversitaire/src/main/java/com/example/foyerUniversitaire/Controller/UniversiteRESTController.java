package com.example.foyerUniversitaire.Controller;

import com.example.foyerUniversitaire.Entity.Universite;
import com.example.foyerUniversitaire.Service.UniversiteService;
import com.example.foyerUniversitaire.Service.UniversiteServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/universite")
public class UniversiteRESTController {
    @Autowired
    private UniversiteService universiteService;

    @GetMapping("/listeUniversite")
    public List<Universite> retrieveAllUniversities() {
        return universiteService.retrieveAllUniversities();
    }

    @PostMapping("/ajouterUniversite")
    public Universite addUniversite(@RequestBody Universite universite) {
        return universiteService.addUniversite(universite);
    }

    @PutMapping("/modifierUniversite/{id}")
    public Universite updateUniversite(@RequestBody Universite universite, @PathVariable Long id) {
        Universite universite1=universiteService.retrieveUniversite(id);
        universite.setIdUniversite(id);
        return universiteService.updateUniversite(universite);
    }

    @GetMapping("/afficherUniversite/{id}")
    public Universite retrieveUniversite(@PathVariable long id) {
        return universiteService.retrieveUniversite(id);
    }

    @DeleteMapping("/supprimerUniversite/{id}")
    public void removeUniversite(@PathVariable long id) {
        universiteService.removeUniversite(id);
    }
}
