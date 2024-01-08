package com.example.foyerUniversitaire.Service;

import com.example.foyerUniversitaire.Entity.Chambre;
import com.example.foyerUniversitaire.Entity.Etudiant;
import com.example.foyerUniversitaire.Entity.Reservation;
import com.example.foyerUniversitaire.Repository.ChambreRepository;
import com.example.foyerUniversitaire.Repository.EtudiantRepository;
import com.example.foyerUniversitaire.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImp {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private ChambreRepository chambreRepository;
    @Autowired
    private EtudiantRepository etudiantRepository;
    public List<Reservation> retrieveAllReservation() {

        return reservationRepository.findAll();
    }

    public Reservation updateReservation(Reservation res) {

        return reservationRepository.save(res);
    }

    public Reservation retrieveReservation(String idReservation) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(Long.parseLong(idReservation));
        return optionalReservation.orElse(null);
    }


}
