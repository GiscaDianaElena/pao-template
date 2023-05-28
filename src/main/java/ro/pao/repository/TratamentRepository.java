package ro.pao.repository;

import ro.pao.model.Tratament;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TratamentRepository {

    Optional<Tratament> getTratamentBypacient(Tratament pacient);

    Optional<List<Tratament>> getObjectBymedicamente(Tratament medicamente);

    void deleteTratamentBypacient(Tratament pacient);

    void updateTratamentBypacient(Tratament pacient, Tratament newTratament);

    void addNewTratament(Tratament Tratament);

    Optional<Tratament> getTratamentBypacient();

    List<Tratament> getAll();

    void addAllFromGivenList(List<Tratament> TratamentList);
}