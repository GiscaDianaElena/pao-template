package ro.pao.service.impl;

import ro.pao.model.Pacient;
import ro.pao.model.Programare;
import ro.pao.service.ProgramareService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ProgramareServiceImpl implements ProgramareService {
    private static List<Programare> programareList = new ArrayList<>();

    public List<Programare> showAllProgramare() {
        return programareList;
    }

    @Override
    public Optional<Programare> getProgramarebyId(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<Programare> getAllFromList() {
        return programareList;
    }

    @Override
    public void addAllFromGivenList(List<Programare> programareList) {
        programareList.addAll(programareList);
    }

    @Override
    public void addOnlyOne(Programare programare) {
        programareList.add(null);
    }
}
