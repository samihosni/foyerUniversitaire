package com.example.foyerUniversitaire.Entity;
 import com.fasterxml.jackson.annotation.JsonBackReference;
 import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
 import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "bloc_id")
    private Bloc bloc;
    @JsonManagedReference
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


    public int getCapaciteBloc(){
        if (bloc != null) {
            return bloc.getChambres().size();
        } else {
            return 0; // ou une valeur par défaut appropriée
        }
    }

    public void setCapaciteBloc(int i) {
        if (bloc != null) {
            // Modifiez la capacité du bloc en fonction du nombre de chambres
            int nombreChambresActuel = bloc.getChambres().size();
            int differenceCapacite = bloc.getCapaciteBloc().intValue() - nombreChambresActuel;

            if (differenceCapacite > 0) {
                // Ajoutez des chambres pour atteindre la nouvelle capacité
                for (int j = 0; j < differenceCapacite; j++) {
                    // Ajoutez ici la logique pour créer une nouvelle chambre si nécessaire
                    // Vous devrez peut-être ajuster cette logique en fonction de votre modèle de données
                }
            } else if (differenceCapacite < 0) {
                // Supprimez des chambres pour atteindre la nouvelle capacité
                for (int k = 0; k < -differenceCapacite; k++) {
                    // Ajoutez ici la logique pour supprimer une chambre si nécessaire
                    // Vous devrez peut-être ajuster cette logique en fonction de votre modèle de données
                }
            }

            // Mise à jour de la capacité du bloc après modification
            int nouvelleCapacite = bloc.getChambres().size();
            System.out.println("Nouvelle capacité du bloc: " + nouvelleCapacite);
        } else {
            System.out.println("La chambre n'est associée à aucun bloc.");
        }
    }
}
