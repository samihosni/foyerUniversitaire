package com.example.foyerUniversitaire.Service;

import com.example.foyerUniversitaire.Entity.Etudiant;
import com.example.foyerUniversitaire.Repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtudiantService {

    @Autowired
    private EtudiantRepository etudiantRepository;

    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRepository.findAll();
    }

    public List<Etudiant> addEtudiants(List<Etudiant> etudiants) {
        return etudiantRepository.saveAll(etudiants);
    }

    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    public Etudiant retrieveEtudiant(long idEtudiant) {
        Optional<Etudiant> optionalEtudiant = etudiantRepository.findById(idEtudiant);
        return optionalEtudiant.orElse(null);
    }

    public void removeEtudiant(long idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);
    }
}

