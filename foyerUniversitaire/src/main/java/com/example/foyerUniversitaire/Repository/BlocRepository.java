package com.example.foyerUniversitaire.Repository;

import com.example.foyerUniversitaire.Entity.Bloc;
import com.example.foyerUniversitaire.Entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BlocRepository extends JpaRepository< Bloc, Long> {

}
