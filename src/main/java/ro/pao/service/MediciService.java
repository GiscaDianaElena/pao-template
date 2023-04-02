package ro.pao.service;

import ro.pao.model.Medici;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MediciService {
    static List<Medici> mediciList = new ArrayList<>();
    // o lista unde stocam toti medicii

    List<Medici> showAllMedici();

    Optional<Medici> getMedicibyId(UUID id);

    List<Medici> getAllFromList();

    void addAllFromGivenList(List<Medici> mediciList);

    void addOnlyOne(Medici medici);
}
