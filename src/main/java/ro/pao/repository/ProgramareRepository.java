package ro.pao.repository;

import ro.pao.model.Programare;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProgramareRepository {

    Optional<Programare> getProgramareById(UUID id);

    Optional<Programare> getProgramareByData(Data date);
    Optional<Programare> getProgramareByMedici(UUID id);
    Optional<List<Programare>> getObjectByData(String date);

    Optional<List<Programare>> getObjectByMedici(UUID id);

    Optional<List<Programare>> getObjectByDoctor(UUID id);

    void deleteProgramareById(UUID id);

    void updateProgramareById(UUID id, Programare newProgramare);

    void addNewProgramare(Programare programare);

    List<Programare> getAll();

    void addAllFromGivenList(List<Programare> ProgramareList);
}