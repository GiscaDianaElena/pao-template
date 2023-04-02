package ro.pao.service;

import ro.pao.model.FisaMedicala;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FisaMedicalaService {
    static List<FisaMedicala> fisaMedicalaList = new ArrayList<>();
    // o lista unde stocam toate fisele medicale

    List<FisaMedicala> showAllFisaMedicala();

    Optional<FisaMedicala> getFisaMedicalabyId(UUID id);

    List<FisaMedicala> getAllFromList();

    void addAllFromGivenList(List<FisaMedicala> fisaMedicalaList);

    void addOnlyOne(FisaMedicala fisaMedicala);
}
