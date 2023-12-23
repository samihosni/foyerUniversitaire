package com.example.foyerUniversitaire.Controller;

import com.example.foyerUniversitaire.Entity.Universite;
import com.example.foyerUniversitaire.Service.UniversiteService;
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

    @GetMapping
    public List<Universite> retrieveAllUniversities() {
        return universiteService.retrieveAllUniversities();
    }

    @PostMapping
    public Universite addUniversite(@RequestBody Universite universite) {
        return universiteService.addUniversite(universite);
    }

    @PutMapping
    public Universite updateUniversite(@RequestBody Universite universite) {
        return universiteService.updateUniversite(universite);
    }

    @GetMapping("/{id}")
    public Universite retrieveUniversite(@PathVariable long id) {
        return universiteService.retrieveUniversite(id);
    }
}
