package com.example.foyerUniversitaire.Service;

import com.example.foyerUniversitaire.Entity.Universite;
import com.example.foyerUniversitaire.Repository.UniversiteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public  class UniversiteServiceImp implements UniversiteService {
    @Autowired
    private UniversiteRepository universiteRepository;


    @Override
    public Universite addUniversite(Universite universites) {
        return universiteRepository.save(universites);
    }

    @Override
    public Universite updateUniversite(Universite universite) {
        Optional<Universite> existingUniversite = universiteRepository.findById(universite.getIdUniversite());
        if (existingUniversite.isPresent()) {
            Universite updatedUniversite = existingUniversite.get();
            // Mettez à jour les champs de l'université
            updatedUniversite.setNomUniversite(universite.getNomUniversite());
            updatedUniversite.setAdresseUniversite(universite.getAdresseUniversite());

            return universiteRepository.save(updatedUniversite);
        } else {
            throw new IllegalArgumentException("L'université avec l'ID " + universite.getIdUniversite() + " n'existe pas.");
        }
    }

    @Override
    public Universite retrieveUniversite(long idUniversite) {
        Optional<Universite> optionalUniversite = universiteRepository.findById(idUniversite);
        return optionalUniversite.orElse(null);
    }

    @Override
    public void removeUniversite(long idUniversite) {
        universiteRepository.deleteById(idUniversite);
    }



    @Override
    public List<Universite> retrieveAllUniversities() {
        return universiteRepository.findAll();    }
}
