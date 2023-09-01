package ro.pao.repository;

import ro.pao.model.ORL_MEDIC;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ORL_MEDICRepository {

    Optional<ORL_MEDIC> getObjectById(UUID id);

    void deleteObjectById(UUID id);

    void updateObjectById(UUID id, ORL_MEDIC newObject);

    void addNewObject(ORL_MEDIC orl_medic);

    List<ORL_MEDIC> getAll();

    void addAllFromGivenList(List<ORL_MEDIC> ORL_MEDICList);
}