package com.example.foyerUniversitaire.Controller;

import com.example.foyerUniversitaire.Entity.Reservation;
import com.example.foyerUniversitaire.Service.ReservationServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationRESTController {
    @Autowired
    private ReservationServiceImp reservationService;

    @GetMapping
    public List<Reservation> retrieveAllReservation() {
        return reservationService.retrieveAllReservation();
    }

    @PutMapping
    public Reservation updateReservation(@RequestBody Reservation reservation) {
        return reservationService.updateReservation(reservation);
    }

    @GetMapping("/{id}")
    public Reservation retrieveReservation(@PathVariable String id) {
        return reservationService.retrieveReservation(id);
    }
}
