package com.example.foyerUniversitaire.Controller;

import com.example.foyerUniversitaire.Entity.Etudiant;
import com.example.foyerUniversitaire.Service.EtudiantService;
import com.example.foyerUniversitaire.Service.EtudiantServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiant")
public class EtudiantRESTController {
    @Autowired
    private EtudiantService etudiantServiceImp;

    @GetMapping("/listeEtudiant")
    public List<Etudiant> retrieveAllEtudiants() {

        return etudiantServiceImp.retrieveAllEtudiants();
    }

    @PostMapping("/ajouterEtudiant")
    public Etudiant addEtudiants(@RequestBody Etudiant etudiants) {

        return etudiantServiceImp.addEtudiants(etudiants);
    }


    @PutMapping("/modifierEtudiant/{id}")
    public Etudiant updateEtudiant(@RequestBody Etudiant etudiant, @PathVariable Long id  ) {
        Etudiant etudiant1=etudiantServiceImp.retrieveEtudiant(id);
        etudiant.setIdEtudiant(id);
        etudiant.setPrenomEtudiant(etudiant1.getPrenomEtudiant());


        return etudiantServiceImp.updateEtudiant(etudiant);
    }


    @GetMapping("/afficherEtudiant/{id}")
    public Etudiant retrieveEtudiant(@PathVariable long id) {

        return etudiantServiceImp.retrieveEtudiant(id);
    }

    @DeleteMapping("/supprimerEtudiant/{id}")
    public void removeEtudiant(@PathVariable long id) {

        etudiantServiceImp.removeEtudiant(id);
    }
}
