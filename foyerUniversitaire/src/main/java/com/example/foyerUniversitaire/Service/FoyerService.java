package com.example.foyerUniversitaire.Service;

import com.example.foyerUniversitaire.Entity.Foyer;

import java.util.List;

public interface FoyerService {
    List<Foyer> retrieveFoyers();

    Foyer updateFoyer(Foyer foyer);

    Foyer addFoyer(Foyer foyer);

    Foyer retrieveFoyer(long idFoyer);

    void removeFoyer(long idFoyer);
}
