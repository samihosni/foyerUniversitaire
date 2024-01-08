package com.example.foyerUniversitaire.Controller;

import com.example.foyerUniversitaire.Entity.Foyer;
import com.example.foyerUniversitaire.Service.FoyerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/foyer")
public class FoyerRESTController {

    @Autowired
    private FoyerServiceImp foyerService;

    @GetMapping("/listeFoyer")
    public List<Foyer> retrieveFoyers() {
        return foyerService.retrieveFoyers();
    }

    @PostMapping("/ajouterFoyer")
    public Foyer addFoyer(@RequestBody Foyer foyer) {
        return foyerService.addFoyer(foyer);
    }

    @PutMapping("/modifierFoyer/{id}")
    public Foyer updateFoyer(@RequestBody Foyer foyer, @PathVariable Long id) {
        foyer.setIdFoyer(id);
        foyer.setNomFoyer(foyer.getNomFoyer());
        foyer.setCapaciteFoyer(foyer.getCapaciteFoyer());

        return foyerService.updateFoyer(foyer);
    }

    @GetMapping("/afficherFoyer/{id}")
    public Foyer retrieveFoyer(@PathVariable long id) {
        return foyerService.retrieveFoyer(id);
    }

    @DeleteMapping("/supprimerFoyer/{id}")
    public void removeFoyer(@PathVariable long id) {
        foyerService.removeFoyer(id);
    }
}
