package com.example.foyerUniversitaire.Controller;

import com.example.foyerUniversitaire.Entity.Etudiant;
import com.example.foyerUniversitaire.Service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiant")
public class EtudiantRESTController {
    @Autowired
    private EtudiantService etudiantService;

    @GetMapping
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantService.retrieveAllEtudiants();
    }

    @PostMapping
    public List<Etudiant> addEtudiants(@RequestBody List<Etudiant> etudiants) {
        return etudiantService.addEtudiants(etudiants);
    }

    @PutMapping
    public Etudiant updateEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.updateEtudiant(etudiant);
    }

    @GetMapping("/{id}")
    public Etudiant retrieveEtudiant(@PathVariable long id) {
        return etudiantService.retrieveEtudiant(id);
    }

    @DeleteMapping("/{id}")
    public void removeEtudiant(@PathVariable long id) {
        etudiantService.removeEtudiant(id);
    }
}
