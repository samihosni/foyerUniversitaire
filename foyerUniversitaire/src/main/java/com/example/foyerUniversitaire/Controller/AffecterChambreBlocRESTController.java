package com.example.foyerUniversitaire.Controller;

import com.example.foyerUniversitaire.Entity.Bloc;
import com.example.foyerUniversitaire.Service.AffecterChambreBlocImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ChambreBloc")
public class AffecterChambreBlocRESTController {
    @Autowired
    private AffecterChambreBlocImp affecterChambreBlocImp;

    @PostMapping("/affecterChambresBloc/{idBloc}")
    public ResponseEntity<Bloc> affecterChambresABloc(@RequestBody List<Long> numChambres, @PathVariable long idBloc) {
        Bloc bloc = affecterChambreBlocImp.affecterChambresABloc(numChambres, idBloc);
        if (bloc != null) {
            return ResponseEntity.ok(bloc);
        } else {
            // Gérez le cas où le bloc ou les chambres n'ont pas été trouvés
            return ResponseEntity.notFound().build();
        }
    }

}
