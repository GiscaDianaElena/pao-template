package ro.pao.service.impl;

import ro.pao.model.Medici;
import ro.pao.service.MediciService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class MediciServiceImpl implements MediciService {
    private static List<Medici> mediciList = new ArrayList<>();

    public List<Medici> showAllMedici() {
        return mediciList;
    }

    @Override
    public Optional<Medici> getMedicibyId(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<Medici> getAllFromList() {
        return mediciList;
    }

    @Override
    public void addAllFromGivenList(List<Medici> mediciList) {
        mediciList.addAll(mediciList);
    }

    @Override
    public void addOnlyOne(Medici medici) {
        mediciList.add(null);
    }
}
