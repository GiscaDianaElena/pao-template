package ro.pao.repository;

import ro.pao.model.Medici;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MediciRepository {

    Optional<Medici> getMediciBynume(Medici nume);

    Optional<List<Medici>> getObjectBynume(Medici nume);

    void deleteMediciBynume(Medici nume);

    void updateMediciBynume(Medici nume, Medici newMedici);

    void addNewMedici(Medici Medici);

    Optional<Medici> getMediciBynume();

    void deleteFisaMedicalaBypacient(FisaMedicala pacient);

    List<Medici> getAll();

    void addAllFromGivenList(List<Medici> MediciList);
}