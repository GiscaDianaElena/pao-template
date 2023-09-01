package ro.pao.mapper;


import ro.pao.model.Medicament;
import ro.pao.model.enums.EnumExample;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class MedicamentMapper {

    private static final MedicamentMapper INSTANCE = new MedicamentMapper();

    private MedicamentMapper() {
    }

    public static MedicamentMapper getInstance() {
        return INSTANCE;
    }


    public Optional<Medicament> mapToMedicament(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Medicament.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .nume(resultSet.getString(2))
                            .pret(resultSet.getDouble(3))
                            //enums
                            .tipMedicament(resultSet.getString(4))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public List<Medicament> mapToMedicamentList(ResultSet resultSet) throws SQLException {
        List<Medicament> MedicamentList = new ArrayList<>();
        while (resultSet.next()) {
            MedicamentList.add(
                    Medicament.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .nume(resultSet.getString(2))
                            .pret(resultSet.getDouble(3))
                            //enums
                            .tipMedicament(resultSet.getString(4))
                            .build()
            );
        }

        return MedicamentList;
    }
}