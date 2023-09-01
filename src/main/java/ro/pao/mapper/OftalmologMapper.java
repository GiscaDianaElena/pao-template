package ro.pao.mapper;


import ro.pao.model.Programare;
import ro.pao.model.Oftalmolog;
import ro.pao.model.enums.EnumExample;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


public class OftalmologMapper {

    private static final OftalmologMapper INSTANCE = new OftalmologMapper();

    private OftalmologMapper() {
    }

    public static OftalmologMapper getInstance() {
        return INSTANCE;
    }


    public Optional<Oftalmolog> mapToOftalmolog(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Oftalmolog.builder()
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

    public List<Oftalmolog> mapToOftalmologList(ResultSet resultSet) throws SQLException {
        List<Oftalmolog> OftalmologList = new ArrayList<>();
        while (resultSet.next()) {
            OftalmologList.add(
                    Oftalmolog.builder()
                            .idPersoana((resultSet.getString(1)))
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

        return OftalmologList;
    }
}