package ro.pao.service;

import ro.pao.model.Pacient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PacientService {
    static List<Pacient> pacientList = new ArrayList<>();
    // o lista unde stocam toti pacientii

    List<Pacient> showAllPacient();

    Optional<Pacient> getPacientbyId(UUID id);

    List<Pacient> getAllFromList();

    void addAllFromGivenList(List<Pacient> pacientList);

    void addOnlyOne(Pacient pacient);
}
