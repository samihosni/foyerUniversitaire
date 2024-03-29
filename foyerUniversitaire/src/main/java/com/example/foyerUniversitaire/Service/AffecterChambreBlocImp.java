package com.example.foyerUniversitaire.Service;

import com.example.foyerUniversitaire.Entity.Bloc;
import com.example.foyerUniversitaire.Entity.Chambre;
import com.example.foyerUniversitaire.Repository.BlocRepository;
import com.example.foyerUniversitaire.Repository.ChambreRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AffecterChambreBlocImp implements AffecterChambreBloc {
    @Autowired
    private BlocRepository blocRepository;

    @Autowired
    private ChambreRepository chambreRepository;
    @Override
    @Transactional
    public Bloc affecterChambresABloc(List<Long> numChambres, Long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc).orElse(null);

        if (bloc != null) {
            //List<Chambre> chambres = chambreRepository.findAllById(numChambres);
            List<Chambre> chambres = chambreRepository.findAllByNumChambreIn(numChambres);

            if (!chambres.isEmpty()) {
                // Assurez-vous que les chambres n'appartiennent à aucun autre bloc
                for (Chambre chambre : chambres) {
                    if (chambre.getBloc() != null) {
                        throw new IllegalArgumentException("La chambre avec l'ID " + chambre.getIdChambre() +
                                " appartient déjà à un autre bloc.");
                    }
                    chambre.setBloc(bloc);
                }

                bloc.getChambres().addAll(chambres);
                blocRepository.save(bloc);
                chambreRepository.saveAll(chambres);

                return bloc;
            } else {
                throw new IllegalArgumentException("Aucune chambre avec les ID spécifiés n'a été trouvée.");
            }
        } else {
            throw new IllegalArgumentException("Le bloc avec l'ID " + idBloc + " n'a pas été trouvé.");
        }
    }
}
