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
    public Bloc affecterChambresABloc(List<Long> idChambre, Long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc)
                .orElseThrow(() -> new RuntimeException("Bloc non trouvé avec l'identifiant : " + idBloc));

        List<Chambre> chambres = chambreRepository.findAllById(idChambre);

        // Assurez-vous que les chambres existent avant de les affecter au bloc


        // Affectez les chambres au bloc
        bloc.setChambres(chambres);

        // Mettez à jour le bloc dans la base de données
        return blocRepository.save(bloc);
    }
}
