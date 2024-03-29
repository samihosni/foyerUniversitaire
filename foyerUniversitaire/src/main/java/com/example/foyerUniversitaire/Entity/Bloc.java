package com.example.foyerUniversitaire.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBloc;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "foyer_id")
    private Foyer foyer;
    @JsonManagedReference
    @OneToMany(mappedBy = "bloc")
    private List<Chambre> chambres;
    private String nomBloc;
    private Long capaciteBloc;

    public Foyer getFoyer() {
        return foyer;
    }

    public void setFoyer(Foyer foyer) {
        this.foyer = foyer;
    }

    public List<Chambre> getChambres() {
        return chambres;
    }

    public void setChambres(List<Chambre> chambres) {
        this.chambres = chambres;
    }
// Getters et  setters


    public Long getIdBloc() {
        return idBloc;
    }

    public void setIdBloc(Long idBloc) {
        this.idBloc = idBloc;
    }

    public String getNomBloc() {
        return nomBloc;
    }

    public void setNomBloc(String nomBloc) {
        this.nomBloc = nomBloc;
    }

    public Long getCapaciteBloc() {
        return capaciteBloc;
    }

    public void setCapaciteBloc(Long capaciteBloc) {
        this.capaciteBloc = capaciteBloc;
    }
}