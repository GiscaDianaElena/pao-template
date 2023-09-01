package ro.pao.repository;

import ro.pao.model.Tratament;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TratamentRepository {

    Optional<Tratament> getObjectById(UUID id);

    void deleteObjectById(UUID id);

    void updateObjectById(UUID id, Tratament newObject);

    void addNewObject(Tratament tratament);

    List<Tratament> getAll();

    void addAllFromGivenList(List<Tratament> TratamentList);
}