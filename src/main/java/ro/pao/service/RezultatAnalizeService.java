package ro.pao.service;

import ro.pao.model.RezultatAnalize;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RezultatAnalizeService {
    static List<RezultatAnalize> rezultatAnalizeList = new ArrayList<>();
    // o lista unde stocam toate rezultatele analizelor

    List<RezultatAnalize> showAllRezultatAnalize();

    Optional<RezultatAnalize> getRezultatAnalizebyId(UUID id);

    List<RezultatAnalize> getAllFromList();

    void addAllFromGivenList(List<RezultatAnalize> rezultatAnalizeList);

    void addOnlyOne(RezultatAnalize rezultatAnalize);
}
