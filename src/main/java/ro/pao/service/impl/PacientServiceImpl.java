package ro.pao.service.impl;

import ro.pao.model.Medici;
import ro.pao.model.Pacient;
import ro.pao.service.PacientService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PacientServiceImpl implements PacientService {
    private static List<Pacient> pacientList = new ArrayList<>();

    public List<Pacient> showAllPacient() {
        return pacientList;
    }

    @Override
    public Optional<Pacient> getPacientbyId(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<Pacient> getAllFromList() {
        return pacientList;
    }

    @Override
    public void addAllFromGivenList(List<Pacient> pacientList) {
        pacientList.addAll(pacientList);
    }

    @Override
    public void addOnlyOne(Pacient pacient) {
        pacientList.add(null);
    }
}
