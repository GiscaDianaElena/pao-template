package ro.pao.repository.impl;

import ro.pao.config.DatabaseConfiguration;
import ro.pao.mapper.ORL_MEDICMapper;
import ro.pao.model.ORL_MEDIC;
import ro.pao.repository.ORL_MEDICRepository;

import java.sql.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ORL_MEDICRepositoryImpl implements ORL_MEDICRepository {

    private static final ORL_MEDICMapper orlMedicMapper = ORL_MEDICMapper.getInstance();

    @Override
    public Optional<ORL_MEDIC> getObjectById(UUID id) {
        String selectSql = "SELECT * FROM ORL_MEDIC WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return orlMedicMapper.mapToORL_MEDIC(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void deleteObjectById(UUID id) {
        String updateNameSql = "DELETE FROM ORL_MEDIC WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateObjectById(UUID id, ORL_MEDIC newObject) {
        String updateNameSql = "UPDATE ORL_Doctor SET salary=? WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            // preparedStatement.setDouble(1, newObject.getSalariu().doubleValue());
            preparedStatement.setString(2, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addNewObject(ORL_MEDIC ORL_MEDIC) {
        String insertSql = "INSERT INTO ORL_MEDIC (id, nume,prenume, email,cnp, adresa, numarTelefon " +
                ", data_angajare, experienta,salariu) VALUES (?, ?,?,?,?,?,?,?,?,?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, ORL_MEDIC.getIdPersoana().toString());
            preparedStatement.setString(2, ORL_MEDIC.getNume().toString());
            preparedStatement.setString(3, ORL_MEDIC.getPrenume().toString());
            preparedStatement.setString(4, ORL_MEDIC.getEmail().toString());
            preparedStatement.setString(5, ORL_MEDIC.getCNP().toString());
            preparedStatement.setString(6, ORL_MEDIC.getAdresa().toString());
            preparedStatement.setString(7, ORL_MEDIC.getNumarTelefon().toString());
            preparedStatement.setDate(8, Date.valueOf(ORL_MEDIC.getData_angajare().toString()));
            preparedStatement.setInt(9, ORL_MEDIC.getExperienta().intValue());
            // preparedStatement.setDouble(10, ORL_MEDIC.getSalariu().doubleValue());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ORL_MEDIC> getAll() {
        String selectSql = "SELECT * FROM ORL_MEDIC";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            return orlMedicMapper.mapToORL_MEDICList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List.of();
    }

    @Override
    public void addAllFromGivenList(List<ORL_MEDIC> ORL_MEDICList) {
        ORL_MEDICList.forEach(this::addNewObject);
    }
}