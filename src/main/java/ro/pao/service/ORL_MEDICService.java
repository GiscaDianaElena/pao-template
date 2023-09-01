package ro.pao.service;

import ro.pao.model.ORL_MEDIC;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * In interfata serviciului se definesc metodele pe care vrem sa le implementam.
 *
 * Metodele trebuie sa fie operatii pe baza tipului de obiect.
 *
 * In cazul de fata, avem clasa 'ORL_Doctor' si serviciul 'ExampleService'.
 * Vom avea operatii de baza doar pe obiectul 'ORL_Doctor'
 *
 * In cazul in care adaugam un nou obiect, de exemplu 'Animal', vom face un serviciu nou, pe nume 'AnimalService'
 * In acel serviciu se apeleaza doar metode pe obiectul 'Animal'.
 * De exemplu: "getAnimalById", "removeAnimalById" etc.
 */
public interface ORL_MEDICService {

    Optional<ORL_MEDIC> getById(UUID id);

    Optional<ORL_MEDIC> getBySomeFieldOfClass(Object someFieldFromORL_MEDIC);

    List<ORL_MEDIC> getAllFromList();

    List<ORL_MEDIC> getAllWithCondition();

    void addAllFromGivenList(List<ORL_MEDIC> ORL_MEDICList);

    void addOnlyOne(ORL_MEDIC ORL_MEDIC);

    void removeElementById(UUID id);

    void modificaElementById(UUID id, ORL_MEDIC newElement);
}