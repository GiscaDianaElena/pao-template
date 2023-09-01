package ro.pao.mapper;

import ro.pao.model.Programare;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ProgramareMapper{

    private static final ProgramareMapper INSTANCE = new ProgramareMapper();

    private ProgramareMapper(){
    }

    public static ProgramareMapper getInstance(){
        return INSTANCE;
    }

    public Optional<Programare> mapToProgramare(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Programare.builder()
                            .idProgramare(UUID.fromString(resultSet.getString(1)))
                            .data(resultSet.getString(2))
                            .pret(resultSet.getDouble(3))
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
                            .idProgramare(UUID.fromString(resultSet.getString(1)))
                            .data(resultSet.getString(2))
                            .pret(resultSet.getDouble(3))
                            .build()
            );
        }

        return ProgramareList;
    }
}