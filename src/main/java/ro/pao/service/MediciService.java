package ro.pao.service;

import ro.pao.model.Medici;
import ro.pao.repository.MediciRepository;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * In interfata serviciului se definesc metodele pe care vrem sa le implementam.
 *
 * Metodele trebuie sa fie operatii pe baza tipului de obiect.
 *
 * In cazul de fata, avem clasa 'Doctor' si serviciul 'ExampleService'.
 * Vom avea operatii de baza doar pe obiectul 'Doctor'
 *
 * In cazul in care adaugam un nou obiect, de exemplu 'Animal', vom face un serviciu nou, pe nume 'AnimalService'
 * In acel serviciu se apeleaza doar metode pe obiectul 'Animal'.
 * De exemplu: "getAnimalById", "removeAnimalById" etc.
 */
public interface MediciService {

    Optional<Medici> getById(String id);

    Optional<List<Medici>> getByNume(String nume);

    Optional<List<Medici>> getByName(String name);

    Optional<Medici> getBySomeFieldOfClass(Medici someFieldFromMedici);

    List<Medici> getAllFromList();

    List<Medici> getAllWithCondition();

    void addAllFromGivenList(List<Medici> MediciList);

    void addOnlyOne(Medici Medici);

    void removeElementById(String id);

    void modificaElementById(String id, Medici newElement);
}