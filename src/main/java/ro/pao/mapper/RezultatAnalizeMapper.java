package ro.pao.mapper;

import ro.pao.model.RezultatAnalize;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RezultatAnalizeMapper{

    private static final RezultatAnalizeMapper INSTANCE = new RezultatAnalizeMapper();

    private RezultatAnalizeMapper(){
    }

    public static RezultatAnalizeMapper getInstance(){
        return INSTANCE;
    }

    public static Optional<RezultatAnalize> mapToRezultatAnalize(ResultSet resultSet) throws SQLException {
        if(resultSet.next()){
            return Optional.of(
                    RezultatAnalize.builder()
                            // .pacient(resultSet.getString(1))
                            // .medic(resultSet.getString(2))
                            // .data(resultSet.getDate(3))
                            .tipAnalize(resultSet.getString(4))
                            .rezultate(resultSet.getString(5))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public static List<RezultatAnalize> mapToRezultatAnalizeList(ResultSet resultSet) throws SQLException {
        List<RezultatAnalize> RezultateAnalizeList = new ArrayList<>();
        List<RezultatAnalize> RezultatAnalizeList = null;
        while (resultSet.next()) {
            RezultatAnalizeList.add(
                    RezultatAnalize.builder()
                            // .pacient(resultSet.getString(1))
                            // .medic(resultSet.getString(2))
                            // .data(resultSet.getDate(3))
                            .tipAnalize(resultSet.getString(4))
                            .rezultate(resultSet.getString(5))
                            .build()
            );
        }

        return RezultatAnalizeList;
    }
}