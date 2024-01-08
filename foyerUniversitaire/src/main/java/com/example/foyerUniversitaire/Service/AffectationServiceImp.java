package com.example.foyerUniversitaire.Service;

import com.example.foyerUniversitaire.Entity.Foyer;
import com.example.foyerUniversitaire.Entity.Universite;
import com.example.foyerUniversitaire.Repository.FoyerRepository;
import com.example.foyerUniversitaire.Repository.UniversiteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AffectationServiceImp implements AffectationService {
    @Autowired
    private UniversiteRepository universiteRepository;
    @Autowired
    private FoyerRepository foyerRepository;
    @Override
    @Transactional
    public Universite affecterFoyerUniversite(Long idFoyer, Long idUniversite){
        Foyer foyer = foyerRepository.findById(idFoyer).orElseThrow(()-> new RuntimeException("Foyer non trouvé"));
        Universite universite= universiteRepository.findById(idUniversite).orElseThrow(()->new RuntimeException("Université non trouvée"));
        universite.setFoyer(foyer);
        return universiteRepository.save(universite);
    }

}
