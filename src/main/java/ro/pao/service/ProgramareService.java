package ro.pao.service;

import ro.pao.model.Programare;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProgramareService {
    static List<Programare> programareList = new ArrayList<>();
    // o lista unde stocam toate programarile

    List<Programare> showAllProgramare();

    Optional<Programare> getProgramarebyId(UUID id);

    List<Programare> getAllFromList();

    void addAllFromGivenList(List<Programare> programareList);

    void addOnlyOne(Programare programare);

    boolean getByData(String nameValue);
}
