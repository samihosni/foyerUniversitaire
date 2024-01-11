package com.example.foyerUniversitaire.Controller;

import com.example.foyerUniversitaire.Entity.Bloc;
import com.example.foyerUniversitaire.Entity.Foyer;
import com.example.foyerUniversitaire.Service.AffecterChambreBlocImp;
import com.example.foyerUniversitaire.Service.FoyerToBLocImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blocToFoyer")
public class BlocToFoyerRESTController {
    @Autowired
    private FoyerToBLocImp foyerToBLocImp;

    @PostMapping("/affecterblocFoyer/{idBloc}/{nomFoyer}")
    public ResponseEntity<Foyer> affecterChambresABloc(@PathVariable List<Long> idBloc, @PathVariable String nomFoyer) {
        Foyer foyer = foyerToBLocImp.BlocToFoyer(idBloc, nomFoyer);
        if (foyer != null) {
            return ResponseEntity.ok(foyer);
        } else {
            // Gérez le cas où le bloc ou les chambres n'ont pas été trouvés
            return ResponseEntity.notFound().build();
        }
    }

}
