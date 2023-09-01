package ro.pao.repository;

import ro.pao.model.Pacient;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PacientRepository {

    Optional<Pacient> getObjectById(UUID id);

    void deleteObjectById(UUID id);

    void updateObjectById(UUID id, Pacient newObject);

    void addNewObject(Pacient pacient);

    List<Pacient> getAll();

    void addAllFromGivenList(List<Pacient> PacientList);
}