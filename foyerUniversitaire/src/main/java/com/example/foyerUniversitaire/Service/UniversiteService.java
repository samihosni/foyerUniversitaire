package com.example.foyerUniversitaire.Service;

import com.example.foyerUniversitaire.Entity.Universite;
import com.example.foyerUniversitaire.Repository.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UniversiteService {
    @Autowired
    private UniversiteRepository universiteRepository;

    public List<Universite> retrieveAllUniversities() {
        return universiteRepository.findAll();
    }

    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    public Universite updateUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    public Universite retrieveUniversite(long idUniversite) {
        Optional<Universite> optionalUniversite = universiteRepository.findById(idUniversite);
        return optionalUniversite.orElse(null);
    }
}
