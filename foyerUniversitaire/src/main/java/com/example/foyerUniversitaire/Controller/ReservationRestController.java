package com.example.foyerUniversitaire.Controller;

import com.example.foyerUniversitaire.Entity.Reservation;
import com.example.foyerUniversitaire.Service.GererResService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.foyerUniversitaire.Entity.Universite;
import com.example.foyerUniversitaire.Service.AffectationServiceImp;
import com.example.foyerUniversitaire.Service.DesaffectationServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservation")
public class ReservationRestController {

   @Autowired
    private GererResService gererResService;

    @PostMapping("/ajouterReservation")
    public Reservation ajouterReservation(
            @RequestParam("idChambre") long idChambre,
            @RequestParam("cinEtudiant") long cinEtudiant) {
        return gererResService.ajouterReservation(idChambre, cinEtudiant);
    }
    /*@PostMapping("/ajouterReservation")
    public Reservation ajouterReservationJson(@RequestBody ReservationRequest request) {
        return gererResService.ajouterReservation(request.getIdChambre(), request.getCinEtudiant());
    }*/
    @GetMapping("/annulerReservation/{cinEtudiant}")
    public Reservation annulerReservation(@PathVariable long cinEtudiant) {
        return gererResService.annulerReservation(cinEtudiant);
    }
}
