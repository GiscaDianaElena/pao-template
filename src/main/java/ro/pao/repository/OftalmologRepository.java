package ro.pao.repository;

import ro.pao.model.Oftalmolog;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OftalmologRepository {

    Optional<Oftalmolog> getObjectById(UUID id);

    void deleteObjectById(UUID id);

    void updateObjectById(UUID id, Oftalmolog newObject);

    void addNewObject(Oftalmolog oftalmolog);

    List<Oftalmolog> getAll();

    void addAllFromGivenList(List<Oftalmolog> OftalmologList);
}