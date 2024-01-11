package com.example.foyerUniversitaire.Service;

import com.example.foyerUniversitaire.Entity.Foyer;
import com.example.foyerUniversitaire.Entity.Universite;
import com.example.foyerUniversitaire.Repository.FoyerRepository;
import com.example.foyerUniversitaire.Repository.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AffectationServiceImp implements AffectationService {
    @Autowired
    private UniversiteRepository universiteRepository;
    @Autowired
    private FoyerRepository foyerRepository;
    @Override
    public Universite affecterFoyerUniversite(Long idFoyer, String nomUniversite) {
        Universite universite = universiteRepository.findByNomUniversite(nomUniversite);
        Foyer foyer = foyerRepository.findById(idFoyer).orElse(null);

        if (universite != null && foyer != null) {
            foyer.setUniversite(universite);
            universite.setFoyer(foyer); // Utilisez la méthode add pour ajouter le foyer à la liste
            foyerRepository.save(foyer);
            universiteRepository.save(universite);
            return universite;
        } else {
            // Gérez le cas où l'université ou le foyer n'a pas été trouvé
            return null;
        }
    }

}
