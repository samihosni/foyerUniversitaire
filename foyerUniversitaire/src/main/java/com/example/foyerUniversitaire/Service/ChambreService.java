package com.example.foyerUniversitaire.Service;

import com.example.foyerUniversitaire.Entity.Chambre;

import java.util.List;

public interface ChambreService {
    List<Chambre> retrieveAllChambres();

    Chambre addChambre(Chambre c);

    Chambre updateChambre(Chambre c);

    Chambre retrieveChambre(long idChambre);

    void removeChambre(long id);
}
