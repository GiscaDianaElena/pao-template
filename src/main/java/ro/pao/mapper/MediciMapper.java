package ro.pao.mapper;

import ro.pao.model.Medici;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MediciMapper{

    private static final MediciMapper INSTANCE = new MediciMapper();

    private MediciMapper(){
    }

    public static MediciMapper getInstance(){
        return INSTANCE;
    }

    public Optional<Medici> mapToMedici(ResultSet resultSet) throws SQLException {
        if(resultSet.next()){
            return Optional.of(
                    Medici.builder()
                            .nume(resultSet.getString(1))
                            .prenume(resultSet.getString(2))
                            // .specializare(resultSet.getString(3))
                            .titlu(resultSet.getString(4))
                            .experienta(resultSet.getDouble(5))
                            // .adresa(resultSet.getString(6))
                            .numarTelefon(resultSet.getString(7))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public List<Medici> mapToMediciList(ResultSet resultSet) throws SQLException {
        List<Medici> MediciList = new ArrayList<>();
        while (resultSet.next()) {
            MediciList.add(
                    Medici.builder()
                            .nume(resultSet.getString(1))
                            .prenume(resultSet.getString(2))
                            // .specializare(resultSet.getString(3))
                            .titlu(resultSet.getString(4))
                            .experienta(resultSet.getDouble(5))
                            // .adresa(resultSet.getString(6))
                            .numarTelefon(resultSet.getString(7))
                            .build()
            );
        }

        return MediciList;
    }
}