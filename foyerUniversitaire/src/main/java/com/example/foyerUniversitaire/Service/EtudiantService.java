package com.example.foyerUniversitaire.Service;

import com.example.foyerUniversitaire.Entity.Etudiant;

import java.util.List;

public interface EtudiantService {
    List<Etudiant> retrieveAllEtudiants();

    Etudiant addEtudiants(Etudiant etudiants);

    Etudiant updateEtudiant(Etudiant etudiant);

    Etudiant retrieveEtudiant(long idEtudiant);

    void removeEtudiant(long idEtudiant);


}
