package ro.pao.repository;

import ro.pao.model.Cardiolog;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CardiologRepository {

    Optional<Cardiolog> getObjectById(UUID id);

    void deleteObjectById(UUID id);

    void updateObjectById(UUID id, Cardiolog newObject);

    void addNewObject(Cardiolog cardiolog);

    List<Cardiolog> getAll();

    void addAllFromGivenList(List<Cardiolog> CardiologList);
}