package ro.pao.mapper;

import ro.pao.model.FisaMedicala;
import ro.pao.model.RezultatAnalize;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FisaMedicalaMapper{

    private static final FisaMedicalaMapper INSTANCE = new FisaMedicalaMapper();

    private FisaMedicalaMapper(){
    }

    public static FisaMedicalaMapper getInstance(){
        return INSTANCE;
    }

    public Optional<FisaMedicala> mapToFisaMedicala(ResultSet resultSet) throws SQLException {
        if(resultSet.next()){
            return Optional.of(
                    FisaMedicala.builder()
                            // .pacient(resultSet.getString(1))
                            //.medic(resultSet.getString(2))
                            // .data(resultSet.getDate(3))
                            .medicamente(resultSet.getString(4))
                            .alergii(resultSet.getString(5))
                            .boliCronice(resultSet.getString(6))
                            // .rezultateAnalize(resultSet.getString(7)
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public List<FisaMedicala> mapToFisaMedicalaList(ResultSet resultSet) throws SQLException {
        List<FisaMedicala> FisaMedicalaList = new ArrayList<>();
        while (resultSet.next()) {
            FisaMedicalaList.add(
                    FisaMedicala.builder()
                            // .pacient(resultSet.getString(1))
                            //.medic(resultSet.getString(2))
                            // .data(resultSet.getDate(3))
                            .medicamente(resultSet.getString(4))
                            .alergii(resultSet.getString(5))
                            .boliCronice(resultSet.getString(6))
                            // .rezultateAnalize(resultSet.getString(7)
                            .build()
            );
        }

        return FisaMedicalaList;
    }
}