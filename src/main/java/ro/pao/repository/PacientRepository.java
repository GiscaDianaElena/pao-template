package ro.pao.repository;

import ro.pao.model.Pacient;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PacientRepository {

    Optional<Pacient> getPacientBynume(Pacient nume);

    Optional<List<Pacient>> getObjectBynume(Pacient nume);

    void deletePacientBynume(Pacient nume);

    void updatePacientBynume(Pacient nume, Pacient newPacient);

    void addNewPacient(Pacient Pacient);

    List<Pacient> getAll();

    void addAllFromGivenList(List<Pacient> PacientList);
}