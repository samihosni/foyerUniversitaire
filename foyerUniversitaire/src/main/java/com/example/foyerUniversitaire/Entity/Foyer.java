package com.example.foyerUniversitaire.Entity;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFoyer;
    @OneToOne()
    @JoinColumn(name = "universite_id")
    private Universite universite;

    @OneToMany(mappedBy = "foyer")
    private List<Bloc> blocs;

    private String nomFoyer;
    private Long capaciteFoyer;

    public Universite getUniversite() {
        return universite;
    }

    public void setUniversite(Universite universite) {
        this.universite = universite;
    }

    public List<Bloc> getBlocs() {
        return blocs;
    }

    public void setBlocs(List<Bloc> blocs) {
        this.blocs = blocs;
    }
// Getters et setters


    public Long getIdFoyer() {
        return idFoyer;
    }

    public void setIdFoyer(Long idFoyer) {
        this.idFoyer = idFoyer;
    }

    public String getNomFoyer() {
        return nomFoyer;
    }

    public void setNomFoyer(String nomFoyer) {
        this.nomFoyer = nomFoyer;
    }

    public Long getCapaciteFoyer() {
        return capaciteFoyer;
    }

    public void setCapaciteFoyer(Long capaciteFoyer) {
        this.capaciteFoyer = capaciteFoyer;
    }
}