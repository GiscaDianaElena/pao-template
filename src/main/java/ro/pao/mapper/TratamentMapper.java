package ro.pao.mapper;

import ro.pao.model.Medicament;
import ro.pao.model.Tratament;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class TratamentMapper{

    private static final TratamentMapper INSTANCE = new TratamentMapper();

    private TratamentMapper(){
    }

    public static TratamentMapper getInstance(){
        return INSTANCE;
    }

    public Optional<Tratament> mapToTratament(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Tratament.builder()
                            .idTratament(UUID.fromString(resultSet.getString(1)))
                            .nume(resultSet.getString(2))
                            .dataPrescrierii(resultSet.getDate(3))
                            .medicamentList((List<Medicament>) resultSet.getArray(5))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public List<Tratament> mapToTratamentList(ResultSet resultSet) throws SQLException {
        List<Tratament> TratamentList = new ArrayList<>();
        while (resultSet.next()) {
            TratamentList.add(
                    Tratament.builder()
                            .idTratament(UUID.fromString(resultSet.getString(1)))
                            .nume(resultSet.getString(2))
                            .dataPrescrierii(resultSet.getDate(3))
                            .medicamentList((List<Medicament>) resultSet.getArray(5))
                            .build()
            );
        }

        return TratamentList;
    }
}