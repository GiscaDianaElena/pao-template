package ro.pao.service;

import ro.pao.model.Programare;
import ro.pao.model.Medicament;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * In interfata serviciului se definesc metodele pe care vrem sa le implementam.
 *
 * Metodele trebuie sa fie operatii pe baza tipului de obiect.
 *
 * In cazul de fata, avem clasa 'Medicine' si serviciul 'ExampleService'.
 * Vom avea operatii de baza doar pe obiectul 'Medicine'
 *
 * In cazul in care adaugam un nou obiect, de exemplu 'Animal', vom face un serviciu nou, pe nume 'AnimalService'
 * In acel serviciu se apeleaza doar metode pe obiectul 'Animal'.
 * De exemplu: "getAnimalById", "removeAnimalById" etc.
 */
public interface MedicamentService {

    Optional<Medicament> getById(UUID id);

    Optional<Medicament> getByNume(Medicament someFieldFromMedicament);

    Optional<List<Medicament>> getByPret();

    Optional<List<Medicament>> getByPret(Double pret);

    Optional<Medicament> getByName(Medicament someFieldFromMedicament);

    List<Medicament> getAllFromList();

    List<Medicament> getAllWithCondition();

    void addAllFromGivenList(List<Medicament> MedicamentList);

    void addOnlyOne(Medicament Medicament);

    void removeElementById(UUID id);

    void modificaElementById(UUID id, Medicament newElement);
}