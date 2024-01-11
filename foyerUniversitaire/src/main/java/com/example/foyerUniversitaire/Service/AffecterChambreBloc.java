package com.example.foyerUniversitaire.Service;

import com.example.foyerUniversitaire.Entity.Bloc;
import jakarta.transaction.Transactional;

import java.util.List;

public interface AffecterChambreBloc {


    @Transactional
    Bloc affecterChambresABloc(List<Long> numChambres, Long idBloc);
}
