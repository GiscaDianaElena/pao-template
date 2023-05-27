package ro.pao.mapper;

import ro.pao.model.Programare;
import ro.pao.model.StatutProgramare;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProgramareMapper{

    private static final ProgramareMapper INSTANCE = new ProgramareMapper();

    private ProgramareMapper(){
    }

    public static ProgramareMapper getInstance(){
        return INSTANCE;
    }

    public Optional<Programare> mapToProgramare(ResultSet resultSet) throws SQLException {
        if(resultSet.next()){
            return Optional.of(
                    Programare.builder()
                            // .dataOra(resultSet.getLocalDateTime(1))
                           //  .medic(resultSet.getString(2))
                            // .pacient(resultSet.getString(3))
                            // .serviciiMedicale(resultSet.getString(4))
                             .durata(Duration.parse(resultSet.getString(5)))
                             .status(StatutProgramare.valueOf(resultSet.getString(6)))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public List<Programare> mapToProgramareList(ResultSet resultSet) throws SQLException {
        List<Programare> ProgramareList = new ArrayList<>();
        while (resultSet.next()) {
            ProgramareList.add(
                    Programare.builder()
                            // .dataOra(resultSet.getLocalDateTime(1))
                           //  .medic(resultSet.getString(2))
                           //  .pacient(resultSet.getString(3))
                           //  .serviciiMedicale(resultSet.getString(4))
                            .durata(Duration.parse(resultSet.getString(5)))
                            .status(StatutProgramare.valueOf(resultSet.getString(6)))
                            .build()
            );
        }

        return ProgramareList;
    }
}