package com.example.foyerUniversitaire.Repository;

import com.example.foyerUniversitaire.Entity.Universite;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
@Transactional
public class UniversiteRepositoryImp implements UniversiteRepositoryCustom{
    @PersistenceContext
    EntityManager entityManager;
    public Universite findByNomUniversite(String nom) {
        Query query = entityManager.createNativeQuery("SELECT c.* FROM Universite c " +
                "WHERE c.name LIKE ?", Universite.class);
        query.setParameter(1, nom + "%");

        return (Universite) query.getSingleResult();
    }


}
