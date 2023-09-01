package ro.pao.mapper;


import ro.pao.model.Programare;
import ro.pao.model.ORL_MEDIC;
import ro.pao.model.enums.EnumExample;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


public class ORL_MEDICMapper {

    private static final ORL_MEDICMapper INSTANCE = new ORL_MEDICMapper();

    private ORL_MEDICMapper() {
    }

    public static ORL_MEDICMapper getInstance() {
        return INSTANCE;
    }


    public Optional<ORL_MEDIC> mapToORL_MEDIC(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    ORL_MEDIC.builder()
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

    public List<ORL_MEDIC> mapToORL_MEDICList(ResultSet resultSet) throws SQLException {
        List<ORL_MEDIC> ORL_MEDICList = new ArrayList<>();
        while (resultSet.next()) {
            ORL_MEDICList.add(
                    ORL_MEDIC.builder()
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

        return ORL_MEDICList;
    }
}