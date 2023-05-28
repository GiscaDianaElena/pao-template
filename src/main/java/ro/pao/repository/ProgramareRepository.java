package ro.pao.repository;

import ro.pao.model.Programare;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProgramareRepository {

    Optional<Programare> getProgramareBydataOra(Programare dataOra);

    Optional<List<Programare>> getObjectBydataOra(Programare dataOra);

    void deleteProgramareBydataOra(Programare dataOra);

    void updateProgramareBydataOra(Programare dataOra,Programare newProgramare);

    void addNewProgramare(Programare Programare);

    Optional<Programare> getProgramareBydataOra();

    List<Programare> getAll();

    void addAllFromGivenList(List<Programare> ProgramareList);
}