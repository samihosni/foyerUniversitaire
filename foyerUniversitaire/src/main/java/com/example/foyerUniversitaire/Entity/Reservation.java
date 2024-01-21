package com.example.foyerUniversitaire.Entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRes;

    public Chambre getChambre() {
        return chambre;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }

    //public List<Etudiant> getEtudiants() {
        //return etudiants;
    //}

    public void setEtudiants(Etudiant etudiant) {

        this.etudiants = etudiants;
    }
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "chambre_id")
    private Chambre chambre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiants;

    private String designationRes;
    private Date anneeUniversitaire;
    private boolean estValide;

    // Getters et setters


    public Long getIdRes() {
        return idRes;
    }

    public void setIdRes(Long idRes) {
        this.idRes = idRes;
    }

    public String getDesignationRes() {
        return designationRes;
    }

    public void setDesignationRes(String designationRes) {
        this.designationRes = designationRes;
    }

    public Date getAnneeUniversitaire() {
        return anneeUniversitaire;
    }

    public void setAnneeUniversitaire(Date anneeUniversitaire) {
        this.anneeUniversitaire = anneeUniversitaire;
    }

    public boolean isEstValide() {
        return estValide;
    }

    public void setEstValide(boolean estValide) {
        this.estValide = estValide;
    }
}
