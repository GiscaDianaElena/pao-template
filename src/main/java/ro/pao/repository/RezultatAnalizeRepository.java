package ro.pao.repository;

import ro.pao.model.RezultatAnalize;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RezultatAnalizeRepository {

    Optional<RezultatAnalize> getRezultatAnalizeBypacient(RezultatAnalize pacient);

    Optional<List<RezultatAnalize>> getObjectByrezultate(RezultatAnalize rezultate);

    void deleteRezultatAnalizeBypacient(RezultatAnalize pacient);

    void updateRezultatAnalizeBypacient(RezultatAnalize pacient, RezultatAnalize newRezultatAnalize);

    void addNewRezultatAnalize(RezultatAnalize RezultatAnalize);

    Optional<RezultatAnalize> getRezultatAnalizeBypacient();

    List<RezultatAnalize> getAll();

    void addAllFromGivenList(List<RezultatAnalize> RezultatAnalizeList);
}