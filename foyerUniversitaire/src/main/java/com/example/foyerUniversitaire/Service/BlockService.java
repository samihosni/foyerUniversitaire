package com.example.foyerUniversitaire.Service;

import com.example.foyerUniversitaire.Entity.Bloc;

import java.util.List;

public interface BlockService {
    List<Bloc> retrieveBlocs();

    Bloc updateBloc(Bloc bloc);

    Bloc addBloc(Bloc bloc);

    Bloc retrieveBloc(long idBloc);

    void removeBloc(long idBloc);
}
