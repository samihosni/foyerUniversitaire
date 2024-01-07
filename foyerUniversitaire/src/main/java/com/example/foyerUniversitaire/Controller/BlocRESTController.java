package com.example.foyerUniversitaire.Controller;

import com.example.foyerUniversitaire.Entity.Bloc;
import com.example.foyerUniversitaire.Service.BlocServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bloc")
public class BlocRESTController {
    @Autowired
    private BlocServiceImp blocService;

    @GetMapping("/listeBloc")
    public List<Bloc> retrieveBlocs() {
        return blocService.retrieveBlocs();
    }

    @PostMapping("/ajouterBloc")
    public Bloc addBloc(@RequestBody Bloc bloc) {
        return blocService.addBloc(bloc);
    }

    @PutMapping("/modifierBloc/{id}")
    public Bloc updateBloc(@RequestBody Bloc bloc, @PathVariable Long id) {
        bloc.setIdBloc(id);
        bloc.setNomBloc(bloc.getNomBloc());
        bloc.setCapaciteBloc(bloc.getCapaciteBloc());



        return blocService.updateBloc(bloc);
    }

    @GetMapping("/afficherBloc/{id}")
    public Bloc retrieveBloc(@PathVariable long id) {
        return blocService.retrieveBloc(id);
    }

    @DeleteMapping("/supprimerBloc/{id}")
    public void removeBloc(@PathVariable long id) {
        blocService.removeBloc(id);
    }
}
