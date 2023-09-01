package ro.pao.mapper;


import ro.pao.model.Programare;
import ro.pao.model.Tratament;
import ro.pao.model.Pacient;
import ro.pao.model.enums.EnumExample;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


public class PacientMapper {

    private static final PacientMapper INSTANCE = new PacientMapper();

    private PacientMapper() {
    }

    public static PacientMapper getInstance() {
        return INSTANCE;
    }


    public Optional<Pacient> mapToPacient(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Pacient.builder()
                            .idPersoana((resultSet.getString(1)))
                            .nume(resultSet.getString(2))
                            .prenume(resultSet.getString(3))
                            .email(resultSet.getString(4))
                            .CNP(resultSet.getString(5))
                            .adresa(resultSet.getString(6))
                            .numarTelefon(resultSet.getString(7))
                            .status(resultSet.getString(8))
                            .boala(resultSet.getString(9))
                            .GrupaSange(resultSet.getString(10))
                            .AsigurareMedicala(resultSet.getString(11))
                            .programare((Programare) resultSet.getObject(12))
                            .tratament((Tratament) resultSet.getObject(13))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public List<Pacient> mapToPacientList(ResultSet resultSet) throws SQLException {
        List<Pacient> PacientList = new ArrayList<>();
        while (resultSet.next()) {
            PacientList.add(
                    Pacient.builder()
                            .idPersoana(resultSet.getString(1))
                            .nume(resultSet.getString(2))
                            .prenume(resultSet.getString(3))
                            .email(resultSet.getString(4))
                            .CNP(resultSet.getString(5))
                            .adresa(resultSet.getString(6))
                            .numarTelefon(resultSet.getString(7))
                            .status(resultSet.getString(8))
                            .boala(resultSet.getString(9))
                            .GrupaSange(resultSet.getString(10))
                            .AsigurareMedicala(resultSet.getString(11))
                            .programare((Programare) resultSet.getObject(12))
                            .tratament((Tratament) resultSet.getObject(13))
                            .build()
            );
        }

        return PacientList;
    }
}