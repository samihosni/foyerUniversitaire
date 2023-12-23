package com.example.foyerUniversitaire.Service;

import com.example.foyerUniversitaire.Entity.Reservation;
import com.example.foyerUniversitaire.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

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
