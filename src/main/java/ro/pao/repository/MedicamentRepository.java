package ro.pao.repository;

import ro.pao.model.Medicament;
import ro.pao.model.Medici;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MedicamentRepository {

    Optional<Medicament> getObjectById(UUID id);

    Optional<List<Medicament>> getObjectByPret(Double pret);

    void deleteObjectById(UUID id);

    void updateObjectById(UUID id, Medicament newObject);

    void addNewObject(Medicament medicament);

    List<Medicament> getAll();

    void addAllFromGivenList(List<Medicament> MedicamentList);
}