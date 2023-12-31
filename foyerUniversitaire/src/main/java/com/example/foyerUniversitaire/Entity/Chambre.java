package com.example.foyerUniversitaire.Entity;
 import jakarta.persistence.*;

 import java.util.List;

@Entity
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChambre;

    public Bloc getBloc() {
        return bloc;
    }

    public void setBloc(Bloc bloc) {
        this.bloc = bloc;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public TypeChambre getTypeChambre() {
        return typeChambre;
    }

    public void setTypeChambre(TypeChambre typeChambre) {
        this.typeChambre = typeChambre;
    }

    @ManyToOne
    @JoinColumn(name = "bloc_id")
    private Bloc bloc;

    @OneToMany(mappedBy = "chambre")
    private List<Reservation> reservations;



    @Enumerated(EnumType.STRING)
    private TypeChambre typeChambre;


    private Long numChambre;

    @Enumerated(EnumType.STRING)
    private TypeChambre typeC;

    public boolean estCapaciteMaxAtteinte(){
        int capaciteMax = typeChambre.getCapaciteMax();
        return reservations.size()>=capaciteMax;
    }

    // Getters et setters


    public Long getIdChambre() {
        return idChambre;
    }

    public void setIdChambre(Long idChambre) {
        this.idChambre = idChambre;
    }

    public Long getNumChambre() {
        return numChambre;
    }

    public void setNumChambre(Long numChambre) {
        this.numChambre = numChambre;
    }

    public TypeChambre getTypeC() {
        return typeC;
    }

    public void setTypeC(TypeChambre typeC) {
        this.typeC = typeC;
    }




}
