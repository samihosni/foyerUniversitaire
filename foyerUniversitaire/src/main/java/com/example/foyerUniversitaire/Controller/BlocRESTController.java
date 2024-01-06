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

    @GetMapping
    public List<Bloc> retrieveBlocs() {
        return blocService.retrieveBlocs();
    }

    @PostMapping
    public Bloc addBloc(@RequestBody Bloc bloc) {
        return blocService.addBloc(bloc);
    }

    @PutMapping
    public Bloc updateBloc(@RequestBody Bloc bloc) {
        return blocService.updateBloc(bloc);
    }

    @GetMapping("/{id}")
    public Bloc retrieveBloc(@PathVariable long id) {
        return blocService.retrieveBloc(id);
    }

    @DeleteMapping("/{id}")
    public void removeBloc(@PathVariable long id) {
        blocService.removeBloc(id);
    }
}
