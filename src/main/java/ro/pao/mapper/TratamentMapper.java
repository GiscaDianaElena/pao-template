package ro.pao.mapper;

import ro.pao.model.Tratament;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TratamentMapper{

    private static final TratamentMapper INSTANCE = new TratamentMapper();

    private TratamentMapper(){
    }

    public static TratamentMapper getInstance(){
        return INSTANCE;
    }

    public static Optional<Tratament> mapToTratament(ResultSet resultSet) throws SQLException {
        if(resultSet.next()){
            return Optional.of(
                    Tratament.builder()
                            // .medic(resultSet.getString(1))
                            // .pacient(resultSet.getString(2))
                            // .dataPrescrierii(resultSet.getDate(3))
                            // .medicamente(resultSet.getString(4))
                            // .durata(resultSet.getString(5))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public static List<Tratament> mapToTratamentList(ResultSet resultSet) throws SQLException {
        List<Tratament> TratamentList = new ArrayList<>();
        while (resultSet.next()) {
            TratamentList.add(
                    Tratament.builder()
                            // .medic(resultSet.getString(1))
                            // .pacient(resultSet.getString(2))
                            // .dataPrescrierii(resultSet.getDate(3))
                            // .medicamente(resultSet.getString(4))
                            // .durata(resultSet.getString(5))
                            .build()
            );
        }

        return TratamentList;
    }
}