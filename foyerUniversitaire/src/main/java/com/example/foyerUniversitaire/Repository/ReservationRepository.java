package com.example.foyerUniversitaire.Repository;

import com.example.foyerUniversitaire.Entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
