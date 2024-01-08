package com.example.foyerUniversitaire.Service;

import com.example.foyerUniversitaire.Entity.Universite;
import jakarta.transaction.Transactional;

public interface DesaffectationService {
    @Transactional
    Universite desaffecterFoyerUniversite(Long idUniversite);
}
