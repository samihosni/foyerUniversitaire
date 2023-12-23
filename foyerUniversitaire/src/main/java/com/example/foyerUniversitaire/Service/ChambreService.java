package com.example.foyerUniversitaire.Service;

import com.example.foyerUniversitaire.Entity.Chambre;
import com.example.foyerUniversitaire.Repository.ChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChambreService {
    @Autowired
    private ChambreRepository chambreRepository;

    public List<Chambre> retrieveAllChambres() {
        return chambreRepository.findAll();
    }

    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    public Chambre updateChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    public Chambre retrieveChambre(long idChambre) {
        Optional<Chambre> optionalChambre = chambreRepository.findById(idChambre);
        return optionalChambre.orElse(null);
    }
}
