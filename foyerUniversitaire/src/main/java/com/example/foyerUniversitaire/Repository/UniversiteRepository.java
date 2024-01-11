package com.example.foyerUniversitaire.Repository;

import com.example.foyerUniversitaire.Entity.Chambre;
import com.example.foyerUniversitaire.Entity.Universite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UniversiteRepository extends JpaRepository<Universite, Long>, UniversiteRepositoryCustom {

}
