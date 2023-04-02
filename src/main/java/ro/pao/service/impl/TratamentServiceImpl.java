package ro.pao.service.impl;

import ro.pao.model.Programare;
import ro.pao.model.Tratament;
import ro.pao.service.TratamentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class TratamentServiceImpl implements TratamentService {
    private static List<Tratament> tratamentList = new ArrayList<>();

    public List<Tratament> showAllTratament() {
        return tratamentList;
    }

    @Override
    public Optional<Tratament> getTratamentbyId(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<Tratament> getAllFromList() {
        return tratamentList;
    }

    @Override
    public void addAllFromGivenList(List<Tratament> tratamentList) {
        tratamentList.addAll(tratamentList);
    }

    @Override
    public void addOnlyOne(Tratament tratament) {
        tratamentList.add(null);
    }
}
