package ro.pao.repository;

import ro.pao.model.FisaMedicala;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;

public interface FisaMedicalaRepository {

    Optional<FisaMedicala> getFisaMedicalazByPacient(FisaMedicala pacient);

    Optional<FisaMedicala> getFisaMedicalaBypacient(FisaMedicala pacient);

    Optional<List<FisaMedicala>> getObjectBypacient(FisaMedicala pacient);

    void deleteFisaMedicalaBypacient();

    Optional<FisaMedicala> getFisaMedicalaBypacient();

    void deleteFisaMedicalaBypacient(FisaMedicala pacient);

    void updateFisaMedicalaBypacient(FisaMedicala pacient, FisaMedicala newFisaMedicala);

    void addNewFisaMedicala(FisaMedicala FisaMedicala);

    List<FisaMedicala> getAll();

    void addAllFromGivenList(List<FisaMedicala> FacturaList);
}