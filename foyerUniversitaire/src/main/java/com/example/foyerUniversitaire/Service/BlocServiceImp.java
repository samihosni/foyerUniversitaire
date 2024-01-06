package com.example.foyerUniversitaire.Service;

import com.example.foyerUniversitaire.Entity.Bloc;
import com.example.foyerUniversitaire.Repository.BlocRepository;
import com.example.foyerUniversitaire.Repository.ChambreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class BlocServiceImp implements BlockService {

    @Autowired
    BlocRepository blocRepo;
    @Autowired
    ChambreRepository chambreRepo;
    public void setBlocRepo(BlocRepository b) {
        this.blocRepo = b;
    }
    @Override
    public List<Bloc> retrieveBlocs() {
        return (List<Bloc>) blocRepo.findAll();
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocRepo.save(bloc);
    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepo.save(bloc);
    }

    @Override
    public Bloc retrieveBloc(long idBloc) {
        return blocRepo.findById(idBloc).orElse(null);
    }

    @Override
    public void removeBloc(long idBloc) {
        blocRepo.deleteById(idBloc);
    }
}
