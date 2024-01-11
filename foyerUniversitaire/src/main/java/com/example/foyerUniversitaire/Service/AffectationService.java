package com.example.foyerUniversitaire.Service;

import com.example.foyerUniversitaire.Entity.Universite;

public interface AffectationService {
    Universite affecterFoyerUniversite(Long idFoyer, String nomUniversite);
}
