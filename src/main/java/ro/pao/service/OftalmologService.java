package ro.pao.service;

import ro.pao.model.Oftalmolog;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * In interfata serviciului se definesc metodele pe care vrem sa le implementam.
 *
 * Metodele trebuie sa fie operatii pe baza tipului de obiect.
 *
 * In cazul de fata, avem clasa 'Ophthalmologist' si serviciul 'ExampleService'.
 * Vom avea operatii de baza doar pe obiectul 'Ophthalmologist'
 *
 * In cazul in care adaugam un nou obiect, de exemplu 'Animal', vom face un serviciu nou, pe nume 'AnimalService'
 * In acel serviciu se apeleaza doar metode pe obiectul 'Animal'.
 * De exemplu: "getAnimalById", "removeAnimalById" etc.
 */
public interface OftalmologService {

    Optional<Oftalmolog> getById(UUID id);

    Optional<Oftalmolog> getBySomeFieldOfClass(Object someFieldFromOftalmolog);

    List<Oftalmolog> getAllFromList();

    List<Oftalmolog> getAllWithCondition();

    void addAllFromGivenList(List<Oftalmolog> OftalmologList);

    void addOnlyOne(Oftalmolog Oftalmolog);

    void removeElementById(UUID id);

    void modificaElementById(UUID id, Oftalmolog newElement);
}