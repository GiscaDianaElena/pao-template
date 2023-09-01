package ro.pao.repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import ro.pao.model.Programare;
import ro.pao.model.Medici;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MediciRepository {

    Optional<Medici> getMediciById(String id);
    Optional<List<Medici>> getObjectByName(String name);

    void deleteMediciById(String id);

    void updateMediciById(String id, Medici newMedici);

    void addNewMedici(Medici medici);

    List<Medici> getAll();

    void addAllFromGivenList(List<Medici> MediciList);
}