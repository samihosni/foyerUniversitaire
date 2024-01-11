package com.example.foyerUniversitaire.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
    public class Universite {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idUniversite;

        @OneToOne(mappedBy = "universite")
        private Foyer foyer;

        private String nomUniversite;

            //Getters et Setters
        public Long getIdUniversite() {
            return idUniversite;
        }

        public void setIdUniversite(Long idUniversite) {
            this.idUniversite = idUniversite;
        }

        public String getNomUniversite() {
            return nomUniversite;
        }

        public void setNomUniversite(String nomUniversite) {
            this.nomUniversite = nomUniversite;
        }

        public String getAdresseUniversite() {
            return adresseUniversite;
        }

        public void setAdresseUniversite(String adresseUniversite) {
            this.adresseUniversite = adresseUniversite;
        }

        private String adresseUniversite;

    public Foyer getFoyer() {
        return foyer;
    }

    public void setFoyer(Foyer foyer) {
        this.foyer = foyer;
    }


}
