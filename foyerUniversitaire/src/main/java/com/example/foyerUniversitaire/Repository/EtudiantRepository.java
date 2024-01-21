package com.example.foyerUniversitaire.Repository;

import com.example.foyerUniversitaire.Entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long>, EtudiantRepositoryCustom {



}
