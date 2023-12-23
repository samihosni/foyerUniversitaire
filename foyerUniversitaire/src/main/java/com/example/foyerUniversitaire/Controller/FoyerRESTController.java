package com.example.foyerUniversitaire.Controller;

import com.example.foyerUniversitaire.Entity.Foyer;
import com.example.foyerUniversitaire.Service.FoyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/foyer")
public class FoyerRESTController {

    @Autowired
    private FoyerService foyerService;

    @GetMapping
    public List<Foyer> retrieveFoyers() {
        return foyerService.retrieveFoyers();
    }

    @PostMapping
    public Foyer addFoyer(@RequestBody Foyer foyer) {
        return foyerService.addFoyer(foyer);
    }

    @PutMapping
    public Foyer updateFoyer(@RequestBody Foyer foyer) {
        return foyerService.updateFoyer(foyer);
    }

    @GetMapping("/{id}")
    public Foyer retrieveFoyer(@PathVariable long id) {
        return foyerService.retrieveFoyer(id);
    }

    @DeleteMapping("/{id}")
    public void removeFoyer(@PathVariable long id) {
        foyerService.removeFoyer(id);
    }
}
