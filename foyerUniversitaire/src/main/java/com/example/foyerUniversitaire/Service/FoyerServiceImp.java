package com.example.foyerUniversitaire.Service;

import com.example.foyerUniversitaire.Entity.Foyer;
import com.example.foyerUniversitaire.Repository.FoyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoyerServiceImp implements FoyerService {
    @Autowired
    private FoyerRepository foyerRepository;
    @Override

    public List<Foyer> retrieveFoyers() {
        return foyerRepository.findAll();
    }
    @Override
    public Foyer updateFoyer(Foyer foyer) {
        Optional<Foyer> existingFoyer = foyerRepository.findById(foyer.getIdFoyer());
        if (existingFoyer.isPresent()){
            Foyer updateFoyer =existingFoyer.get();
            // Mettre à jour les champs
            updateFoyer.setNomFoyer(foyer.getNomFoyer());
            updateFoyer.setCapaciteFoyer((foyer.getCapaciteFoyer()));

            return foyerRepository.save(updateFoyer);
        }
        else {
            throw new IllegalArgumentException("Le foyer avec l'ID " + foyer.getIdFoyer() + " n'existe pas.");
        }
    }
    @Override
    public Foyer addFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }
    @Override
    public Foyer retrieveFoyer(long idFoyer) {
        Optional<Foyer> optionalFoyer = foyerRepository.findById(idFoyer);
        return optionalFoyer.orElse(null);
    }
    @Override
    public void removeFoyer(long idFoyer) {
        foyerRepository.deleteById(idFoyer);
    }
}
