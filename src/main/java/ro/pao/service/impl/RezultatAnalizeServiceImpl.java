package ro.pao.service.impl;

import ro.pao.service.RezultatAnalizeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class RezultatAnalizeServiceImpl implements RezultatAnalizeService {
    private static List<RezultatAnalize> rezultatAnalizeList = new ArrayList<>();

    public List<RezultatAnalize> showAllRezultatAnalize() {
        return rezultatAnalizeList;
    }

    @Override
    public Optional<RezultatAnalize> getRezultatAnalizebyId(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<RezultatAnalize> getAllFromList() {
        return rezultatAnalizeList;
    }

    @Override
    public void addAllFromGivenList(List<RezultatAnalize> rezultatAnalizeList) {
        rezultatAnalizeList.addAll(rezultatAnalizeList);
    }

    @Override
    public void addOnlyOne(RezultatAnalize rezultatAnalize) {
        rezultatAnalizeList.add(null);
    }
}
