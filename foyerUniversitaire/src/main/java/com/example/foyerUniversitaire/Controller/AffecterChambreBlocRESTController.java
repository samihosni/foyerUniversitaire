package com.example.foyerUniversitaire.Controller;

import com.example.foyerUniversitaire.Entity.Bloc;
import com.example.foyerUniversitaire.Service.AffecterChambreBlocImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ChambreBloc")
public class AffecterChambreBlocRESTController {
    @Autowired
    private AffecterChambreBlocImp affecterChambreBlocImp;

    @PostMapping("/affecterChambresBloc/{idBloc}")
    public Bloc affecterChambresABloc(@RequestBody(required = false) List<Long> idChambre, @PathVariable Long idBloc) {
        return affecterChambreBlocImp.affecterChambresABloc(idChambre, idBloc);
    }
}
