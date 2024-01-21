package com.example.foyerUniversitaire.Service;

import com.example.foyerUniversitaire.Entity.Chambre;
import com.example.foyerUniversitaire.Entity.Etudiant;
import com.example.foyerUniversitaire.Entity.Reservation;
import com.example.foyerUniversitaire.Entity.TypeChambre;
import com.example.foyerUniversitaire.Repository.ChambreRepository;
import com.example.foyerUniversitaire.Repository.EtudiantRepository;
import com.example.foyerUniversitaire.Repository.ReservationRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Transactional
@Service
public class GererResService {
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ChambreRepository chambreRepository;

    @Autowired
    private EtudiantRepository etudiantRepository;

    public Reservation ajouterReservation(long idChambre, long cinEtudiant) {
        Etudiant etudiant = etudiantRepository.findByCin(cinEtudiant);

        if (etudiant != null) {
            // Check if the student already has reservations
            List<Reservation> reservations = etudiant.getReservations();

            if (reservations.isEmpty()) {
                Chambre chambre = chambreRepository.findById(idChambre).orElse(null);

                if (chambre != null) {
                    // Check if the maximum capacity of the room is still available
                    if (capaciteMaximaleDisponible(chambre)) {
                        // Create the reservation number in the specified format
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
                        String numReservation = String.format("%d-%s-%s",
                                chambre.getNumChambre(), chambre.getBloc().getNomBloc(), dateFormat.format(new Date()));

                        // Create the reservation
                        Reservation reservation = new Reservation();
                        reservation.setDesignationRes(numReservation);
                        reservation.setAnneeUniversitaire(new Date());
                        reservation.setEstValide(true);
                        reservation.setChambre(chambre);

                        reservation.setEtudiants(etudiant);
                        etudiant.getReservations().add(reservation);


                        // Add the reservation to the room
                        chambre.getReservations().add(reservation);

                        // Update the room capacity
                        mettreAJourCapaciteChambre(chambre);

                        // Save the reservation and the room
                        reservationRepository.save(reservation);
                        chambreRepository.save(chambre);

                        // Associate the reservation with the student
                        etudiant.getReservations().add(reservation);

                        // Save the student to update the association
                        etudiantRepository.save(etudiant);

                        return reservation;
                    } else {
                        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La capacité maximale de la chambre est atteinte.");
                    }
                } else {
                    throw new EntityNotFoundException("Chambre non trouvée.");
                }
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cet étudiant a déjà une réservation.");
            }
        } else {
            throw new EntityNotFoundException("Etudiant non trouvé.");
        }
    }


    private boolean capaciteMaximaleDisponible(Chambre chambre) {
        TypeChambre typeChambre = chambre.getTypeChambre();
        int capaciteMaximale = typeChambre.getCapaciteMax();
        int nombreReservationsActuel = chambre.getReservations().size();

        return nombreReservationsActuel < capaciteMaximale;
    }

    private void mettreAJourCapaciteChambre(Chambre chambre) {
        TypeChambre typeChambre = chambre.getTypeChambre();
        int capaciteActuelle = chambre.getCapaciteBloc();

        chambre.setCapaciteBloc(capaciteActuelle - 1);

        // Vous pouvez également effectuer des vérifications pour éviter une capacité négative si nécessaire.
        if (chambre.getCapaciteBloc() < 0) {
            chambre.setCapaciteBloc(0); // Ou toute autre logique appropriée.
        }
    }

    // Annuler Reservation
    public Reservation annulerReservation(long cinEtudiant) {
        Etudiant etudiant = etudiantRepository.findByCin(cinEtudiant);

        if (etudiant != null) {
            // Check if the student has a reservation
            List<Reservation> reservation = etudiant.getReservations();

            if (!reservation.isEmpty() ) {
                Reservation reservation1 = reservation.get(0);

                Chambre chambre = reservation1.getChambre();
                reservation1.setEstValide(false);
                reservation1.setChambre(null);
                reservation1.setEtudiants(null);

                chambre.getReservations().remove(reservation);
                mettreAJourCapaciteChambreAnnuler(chambre);

                reservationRepository.save(reservation1);
                chambreRepository.save(chambre);

                // Remove the reservation from the student
                etudiant.getReservations().clear();
                etudiantRepository.save(etudiant);

                return reservation1;
            } else {
                throw new EntityNotFoundException("Aucune réservation trouvée pour cet étudiant.");
            }
        } else {
            throw new EntityNotFoundException("Etudiant non trouvé.");
        }
    }

    private void mettreAJourCapaciteChambreAnnuler(Chambre chambre) {
        int capaciteActuelle = chambre.getCapaciteBloc();
        chambre.setCapaciteBloc(capaciteActuelle + 1);
    }
}