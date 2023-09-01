package ro.pao.service;

import ro.pao.model.Programare;

import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * In interfata serviciului se definesc metodele pe care vrem sa le implementam.
 *
 * Metodele trebuie sa fie operatii pe baza tipului de obiect.
 *
 * In cazul de fata, avem clasa 'Appointment' si serviciul 'ExampleService'.
 * Vom avea operatii de baza doar pe obiectul 'Appointment'
 *
 * In cazul in care adaugam un nou obiect, de exemplu 'Animal', vom face un serviciu nou, pe nume 'AnimalService'
 * In acel serviciu se apeleaza doar metode pe obiectul 'Animal'.
 * De exemplu: "getAnimalById", "removeAnimalById" etc.
 */
public interface ProgramareService {

    Optional<Programare> getById(UUID id) throws SQLException;

    Optional<List<Programare>> getByData(String date);
    Optional<List<Programare>> getByMedici(UUID id);

    List<Programare> getAllFromList();

    List<Programare> getAllWithCondition();

    void addAllFromGivenList(List<Programare> ProgramareList);

    void addOnlyOne(Programare Programare);

    void removeElementById(UUID id);

    void modificaElementById(UUID id, Programare newElement);
}