package com.example.foyerUniversitaire.Controller;

import com.example.foyerUniversitaire.Entity.Chambre;
import com.example.foyerUniversitaire.Service.ChambreServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chambre")
public class ChambreRESTController {
    @Autowired
    private ChambreServiceImp chambreService;

    @GetMapping("/listeChambre")
    public List<Chambre> retrieveAllChambres() {
        return chambreService.retrieveAllChambres();
    }

    @PostMapping("/ajouterChambre")
    public Chambre addChambre(@RequestBody Chambre chambre) {
        return chambreService.addChambre(chambre);
    }

    @PutMapping("/modifierChambre/{id}")
    public Chambre updateChambre(@RequestBody Chambre chambre, @PathVariable Long id) {
        chambre.setIdChambre(id);
        chambre.setNumChambre(chambre.getNumChambre());
        chambre.setTypeC(chambre.getTypeC());

        return chambreService.updateChambre(chambre);
    }

    @GetMapping("/afficherChambre/{id}")
    public Chambre retrieveChambre(@PathVariable long id) {

        return chambreService.retrieveChambre(id);
    }
    @DeleteMapping("/supprimerChambre/{id}")
    public void removeChambre(@PathVariable long id) {
        chambreService.removeChambre(id);
    }
}
