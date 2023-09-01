package ro.pao.service.impl;

import ro.pao.service.FisaMedicalaService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class FisaMedicalaServiceImpl implements FisaMedicalaService {
    private static List<FisaMedicala> fisaMedicalaList = new ArrayList<>();

    public List<FisaMedicala> showAllFisaMedicala() {
        return fisaMedicalaList;
    }

    @Override
    public Optional<FisaMedicala> getFisaMedicalabyId(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<FisaMedicala> getAllFromList() {
        return fisaMedicalaList;
    }

    @Override
    public void addAllFromGivenList(List<FisaMedicala> fisaMedicalaList) {
        fisaMedicalaList.addAll(fisaMedicalaList);
    }

    @Override
    public void addOnlyOne(FisaMedicala fisaMedicala) {
        fisaMedicalaList.add(null);
    }
}