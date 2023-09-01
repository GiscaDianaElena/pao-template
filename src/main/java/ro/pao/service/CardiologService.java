package ro.pao.service;

import ro.pao.model.Cardiolog;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * In interfata serviciului se definesc metodele pe care vrem sa le implementam.
 *
 * Metodele trebuie sa fie operatii pe baza tipului de obiect.
 *
 * In cazul de fata, avem clasa 'Cardiologist' si serviciul 'ExampleService'.
 * Vom avea operatii de baza doar pe obiectul 'Cardiologist'
 *
 * In cazul in care adaugam un nou obiect, de exemplu 'Animal', vom face un serviciu nou, pe nume 'AnimalService'
 * In acel serviciu se apeleaza doar metode pe obiectul 'Animal'.
 * De exemplu: "getAnimalById", "removeAnimalById" etc.
 */
public interface CardiologService {

    Optional<Cardiolog> getById(UUID id);

    Optional<Cardiolog> getBySomeFieldOfClass(Object someFieldFromCardiolog);

    List<Cardiolog> getAllFromList();

    List<Cardiolog> getAllWithCondition();

    void addAllFromGivenList(List<Cardiolog> CardiologList);

    void addOnlyOne(Cardiolog Cardiolog);

    void removeElementById(UUID id);

    void modificaElementById(UUID id, Cardiolog newElement);
}