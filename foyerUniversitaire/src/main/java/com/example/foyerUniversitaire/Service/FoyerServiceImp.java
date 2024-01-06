package com.example.foyerUniversitaire.Service;

import com.example.foyerUniversitaire.Entity.Foyer;
import com.example.foyerUniversitaire.Repository.FoyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoyerServiceImp {
    @Autowired
    private FoyerRepository foyerRepository;

    public List<Foyer> retrieveFoyers() {
        return foyerRepository.findAll();
    }

    public Foyer updateFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    public Foyer addFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    public Foyer retrieveFoyer(long idFoyer) {
        Optional<Foyer> optionalFoyer = foyerRepository.findById(idFoyer);
        return optionalFoyer.orElse(null);
    }

    public void removeFoyer(long idFoyer) {
        foyerRepository.deleteById(idFoyer);
    }
}
