package com.example.foyerUniversitaire.Service;

import com.example.foyerUniversitaire.Entity.Etudiant;
import com.example.foyerUniversitaire.Repository.EtudiantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EtudiantServiceImp implements EtudiantService{
    @Autowired
    private EtudiantRepository etudiantRepository;

    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant addEtudiants(Etudiant etudiants) {
        return etudiantRepository.save(etudiants);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant etudiant) {
        Optional<Etudiant> existingEtudiant = etudiantRepository.findById(etudiant.getIdEtudiant());
        if (existingEtudiant.isPresent()) {
            Etudiant updatedEtudiant = existingEtudiant.get();
            // Mettez à jour les champs de l'étudiant
            updatedEtudiant.setNomEtudiant(etudiant.getNomEtudiant());
            updatedEtudiant.setPrenomEtudiant(etudiant.getPrenomEtudiant());
            updatedEtudiant.setCin(etudiant.getCin());
            updatedEtudiant.setEcole(etudiant.getEcole());
            updatedEtudiant.setDateNaissance(etudiant.getDateNaissance());
            // ... autres champs

            return etudiantRepository.save(updatedEtudiant);
        } else {
            throw new IllegalArgumentException("L'étudiant avec l'ID " + etudiant.getIdEtudiant() + " n'existe pas.");
        }
    }

    @Override
    public Etudiant retrieveEtudiant(long idEtudiant) {
        Optional<Etudiant> optionalEtudiant = etudiantRepository.findById(idEtudiant);
        return optionalEtudiant.orElse(null);
    }

    @Override
    public void removeEtudiant(long idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);
    }




}


