package ro.pao.mapper;

import ro.pao.model.Medici;
import ro.pao.model.Programare;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class MediciMapper{

    private static final MediciMapper INSTANCE = new MediciMapper();

    private MediciMapper(){
    }

    public static MediciMapper getInstance(){
        return INSTANCE;
    }

    public Optional<Medici> mapToMedici(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Medici.builder()
                            .idPersoana(resultSet.getString(1))
                            .nume(resultSet.getString(2))
                            .prenume(resultSet.getString(3))
                            .email(resultSet.getString(4))
                            .CNP(resultSet.getString(5))
                            .adresa(resultSet.getString(6))
                            .numarTelefon(resultSet.getString(7))
                            .data_angajare(resultSet.getString(8))
                            .experienta(resultSet.getInt(9))
                            .salariu(resultSet.getDouble(10))
                            .programareList((List<Programare>) resultSet.getArray(11))
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
                            .idPersoana(resultSet.getString(1))
                            .nume(resultSet.getString(2))
                            .prenume(resultSet.getString(3))
                            .email(resultSet.getString(4))
                            .CNP(resultSet.getString(5))
                            .adresa(resultSet.getString(6))
                            .numarTelefon(resultSet.getString(7))
                            .data_angajare(resultSet.getString(8))
                            .experienta(resultSet.getInt(9))
                            .salariu(resultSet.getDouble(10))
                            .programareList((List<Programare>) resultSet.getArray(11))
                            .build()
            );
        }

        return MediciList;
    }
}