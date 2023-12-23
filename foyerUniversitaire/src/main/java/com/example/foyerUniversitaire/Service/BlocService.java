package com.example.foyerUniversitaire.Service;

import com.example.foyerUniversitaire.Entity.Bloc;
import com.example.foyerUniversitaire.Repository.BlocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class BlocService {

        @Autowired
        private BlocRepository blocRepository;

        public List<Bloc> retrieveBlocs() {
            return blocRepository.findAll();
        }

        public Bloc updateBloc(Bloc bloc) {
            return blocRepository.save(bloc);
        }

        public Bloc addBloc(Bloc bloc) {
            return blocRepository.save(bloc);
        }

        public Bloc retrieveBloc(long idBloc) {
            Optional<Bloc> optionalBloc = blocRepository.findById(idBloc);
            return optionalBloc.orElse(null);
        }

        public void removeBloc(long idBloc) {
            blocRepository.deleteById(idBloc);
        }
}
