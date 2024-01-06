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

    @GetMapping
    public List<Chambre> retrieveAllChambres() {
        return chambreService.retrieveAllChambres();
    }

    @PostMapping
    public Chambre addChambre(@RequestBody Chambre chambre) {
        return chambreService.addChambre(chambre);
    }

    @PutMapping
    public Chambre updateChambre(@RequestBody Chambre chambre) {
        return chambreService.updateChambre(chambre);
    }

    @GetMapping("/{id}")
    public Chambre retrieveChambre(@PathVariable long id) {
        return chambreService.retrieveChambre(id);
    }
}
