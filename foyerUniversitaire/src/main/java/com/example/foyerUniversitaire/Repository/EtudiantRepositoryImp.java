package com.example.foyerUniversitaire.Repository;

import com.example.foyerUniversitaire.Entity.Etudiant;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.Optional;

public class EtudiantRepositoryImp implements EtudiantRepositoryCustom{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Etudiant findByCin(long cinEtudiant) {
        // Utilisation de JPA pour créer et exécuter une requête typée
        TypedQuery<Etudiant> query = entityManager.createQuery(
                "SELECT e FROM Etudiant e WHERE e.cin = :cin", Etudiant.class);
        query.setParameter("cin", cinEtudiant);

        try {
            // Récupérer l'étudiant s'il existe, sinon renvoyer null
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

}
