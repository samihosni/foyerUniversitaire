package com.example.foyerUniversitaire.Controller;

public class ReservationRequest {
    private long idChambre;
    private long cinEtudiant;

    public long getIdChambre() {
        return idChambre;
    }

    public void setIdChambre(long idChambre) {
        this.idChambre = idChambre;
    }

    public long getCinEtudiant() {
        return cinEtudiant;
    }

    public void setCinEtudiant(long cinEtudiant) {
        this.cinEtudiant = cinEtudiant;
    }
}
