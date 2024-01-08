package com.example.foyerUniversitaire.Service;

import com.example.foyerUniversitaire.Entity.Universite;

import java.util.List;

public interface UniversiteService {

    Universite addUniversite(Universite universites);

    Universite updateUniversite(Universite universite);

    Universite retrieveUniversite(long idUniversite);

    void removeUniversite(long idUniversite);


    List<Universite> retrieveAllUniversities();

}
