package com.example.foyerUniversitaire.Service;

import com.example.foyerUniversitaire.Entity.Foyer;
import jakarta.transaction.Transactional;

import java.util.List;

public interface FoyerToBLoc {
    @Transactional
    Foyer BlocToFoyer(List<Long> idBloc, String nomFoyer);
}
