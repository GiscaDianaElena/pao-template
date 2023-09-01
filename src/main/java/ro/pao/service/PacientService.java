package ro.pao.service;

import ro.pao.model.Pacient;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * In interfata serviciului se definesc metodele pe care vrem sa le implementam.
 *
 * Metodele trebuie sa fie operatii pe baza tipului de obiect.
 *
 * In cazul de fata, avem clasa 'Patient' si serviciul 'ExampleService'.
 * Vom avea operatii de baza doar pe obiectul 'Patient'
 *
 * In cazul in care adaugam un nou obiect, de exemplu 'Animal', vom face un serviciu nou, pe nume 'AnimalService'
 * In acel serviciu se apeleaza doar metode pe obiectul 'Animal'.
 * De exemplu: "getAnimalById", "removeAnimalById" etc.
 */
public interface PacientService {

    Optional<Pacient> getById(UUID id);

    Optional<Pacient> getBySomeFieldOfClass(Object someFieldFromPacient);

    List<Pacient> getAllFromList();

    List<Pacient> getAllWithCondition();

    void addAllFromGivenList(List<Pacient> PacientList);

    void addOnlyOne(Pacient Pacient);

    void removeElementById(UUID id);

    void modificaElementById(UUID id, Pacient newElement);
}