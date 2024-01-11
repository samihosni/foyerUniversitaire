package com.example.foyerUniversitaire.Service;

import com.example.foyerUniversitaire.Entity.Bloc;
import com.example.foyerUniversitaire.Entity.Chambre;
import com.example.foyerUniversitaire.Entity.Foyer;
import com.example.foyerUniversitaire.Repository.BlocRepository;
import com.example.foyerUniversitaire.Repository.ChambreRepository;
import com.example.foyerUniversitaire.Repository.FoyerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FoyerToBLocImp implements FoyerToBLoc {
    @Autowired
    private BlocRepository blocRepository;

    @Autowired
    private FoyerRepository foyerRepository;
    @Override
    @Transactional
    public Foyer BlocToFoyer(List<Long> idBloc, String nomFoyer) {
        Foyer foyer = foyerRepository.findByNomFoyer(nomFoyer);

        if (foyer != null) {
            //List<Chambre> chambres = chambreRepository.findAllById(numChambres);
            List<Bloc> blocs = blocRepository.findAllById(idBloc);

            if (!blocs.isEmpty()) {
                // Assurez-vous que les chambres n'appartiennent à aucun autre bloc
                for (Bloc bloc : blocs) {
                    if (bloc.getFoyer() != null) {
                        throw new IllegalArgumentException("Le bloc avec l'ID " + bloc.getIdBloc() +
                                " appartient déjà à un autre foyer.");
                    }
                    bloc.setFoyer(foyer);
                }

                foyer.getBlocs().addAll(blocs);
                foyerRepository.save(foyer);
                blocRepository.saveAll(blocs);

                return foyer;
            } else {
                throw new IllegalArgumentException("Aucune chambre avec les ID spécifiés n'a été trouvée.");
            }
        } else {
            throw new IllegalArgumentException("Le bloc avec l'ID " + idBloc + " n'a pas été trouvé.");
        }
    }
}
