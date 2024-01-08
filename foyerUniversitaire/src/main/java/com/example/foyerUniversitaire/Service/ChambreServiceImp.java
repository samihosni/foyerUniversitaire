package com.example.foyerUniversitaire.Service;

import com.example.foyerUniversitaire.Entity.Chambre;
import com.example.foyerUniversitaire.Entity.Etudiant;
import com.example.foyerUniversitaire.Repository.ChambreRepository;
import com.example.foyerUniversitaire.Repository.EtudiantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChambreServiceImp implements ChambreService {
    @Autowired
    private ChambreRepository chambreRepository;
    @Autowired
    private EtudiantRepository etudiantRepository;
    @Override
    public List<Chambre> retrieveAllChambres() {
        return chambreRepository.findAll();
    }
    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }
    @Override
    public Chambre updateChambre(Chambre c) {
        Optional<Chambre> existingChambre = chambreRepository.findById(c.getIdChambre());
        if (existingChambre.isPresent()) {
            Chambre updatedChambre = existingChambre.get();
            // Mettez à jour les champs de l'étudiant
            updatedChambre.setNumChambre(c.getNumChambre());
            updatedChambre.setTypeC(c.getTypeC());
            return chambreRepository.save(c);
        }
        else {
            throw new IllegalArgumentException("La chambre avec l'ID " + c.getIdChambre() + " n'existe pas.");
        }


    }
    @Override
    public Chambre retrieveChambre(long idChambre) {
        Optional<Chambre> optionalChambre = chambreRepository.findById(idChambre);
        return optionalChambre.orElse(null);
    }
    @Override
    public void removeChambre(long id) {
        chambreRepository.deleteById(id);
    }


}
