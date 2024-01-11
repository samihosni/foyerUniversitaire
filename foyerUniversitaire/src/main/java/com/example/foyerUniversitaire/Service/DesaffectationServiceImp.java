package com.example.foyerUniversitaire.Service;

import com.example.foyerUniversitaire.Entity.Foyer;
import com.example.foyerUniversitaire.Entity.Universite;
import com.example.foyerUniversitaire.Repository.FoyerRepository;
import com.example.foyerUniversitaire.Repository.UniversiteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DesaffectationServiceImp implements DesaffectationService {
    @Autowired
    private UniversiteRepository universiteRepository;
    @Autowired
    private FoyerRepository foyerRepository;
    @Override
    @Transactional
    public Universite desaffecterFoyerUniversite(Long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite)
                .orElse(null);

        Foyer foyer = universite.getFoyer();
        if (foyer != null && universite!=null) {
            universite.setFoyer(null);
            foyer.setUniversite(null);
            foyerRepository.save(foyer);
            universiteRepository.save(universite);
            return universite;
        } else {
            return null;
        }
    }
}