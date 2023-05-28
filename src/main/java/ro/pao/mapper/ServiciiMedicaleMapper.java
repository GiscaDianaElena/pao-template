package ro.pao.mapper;

import ro.pao.model.ServiciiMedicale;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ServiciiMedicaleMapper{

    private static final ServiciiMedicaleMapper INSTANCE = new ServiciiMedicaleMapper();

    private ServiciiMedicaleMapper(){
    }

    public static ServiciiMedicaleMapper getInstance(){
        return INSTANCE;
    }

    public static Optional<ServiciiMedicale> mapToServiciiMedicale(ResultSet resultSet) throws SQLException {
        if(resultSet.next()){
            return Optional.of(
                    ServiciiMedicale.builder()
                            .numeServiciu(resultSet.getString(1))
                            .descriere(resultSet.getString(2))
                            .cost(resultSet.getDouble(3))
                            .durata(resultSet.getInt(4))
                            .personalMedical(resultSet.getString(5))
                            .echipament(resultSet.getString(6))
                            .disponibilitate(resultSet.getDate(7))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public static List<ServiciiMedicale> mapToServiciiMedicaleList(ResultSet resultSet) throws SQLException {
        List<ServiciiMedicale> ServiciiMedicaleList = new ArrayList<>();
        while (resultSet.next()) {
            ServiciiMedicaleList.add(
                    ServiciiMedicale.builder()
                            .numeServiciu(resultSet.getString(1))
                            .descriere(resultSet.getString(2))
                            .cost(resultSet.getDouble(3))
                            .durata(resultSet.getInt(4))
                            .personalMedical(resultSet.getString(5))
                            .echipament(resultSet.getString(6))
                            .disponibilitate(resultSet.getDate(7))
                            .build()
            );
        }

        return ServiciiMedicaleList;
    }
}