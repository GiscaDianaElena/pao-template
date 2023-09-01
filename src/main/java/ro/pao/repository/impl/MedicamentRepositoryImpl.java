package ro.pao.repository.impl;

import ro.pao.config.DatabaseConfiguration;
import ro.pao.mapper.MedicamentMapper;
import ro.pao.model.Medicament;
import ro.pao.model.Medici;
import ro.pao.repository.MedicamentRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class MedicamentRepositoryImpl implements MedicamentRepository {

    private static final MedicamentMapper medicamentMapper = MedicamentMapper.getInstance();

    @Override
    public Optional<Medicament> getObjectById(UUID id) {
        String selectSql = "SELECT * FROM medicament WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return medicamentMapper.mapToMedicament(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void deleteObjectById(UUID id) {
        String updateNameSql = "DELETE FROM medicament WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateObjectById(UUID id, Medicament newObject) {
        String updateNameSql = "UPDATE medicament SET price=? WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setDouble(1, newObject.getPret());
            preparedStatement.setString(2, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<List<Medicament>> getObjectByPret(Double pret) {
        String selectSql = "SELECT * FROM medicamentWHERE pret = ?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setDouble(1, Double.parseDouble(pret.toString()));

            ResultSet resultSet = preparedStatement.executeQuery();
            return Optional.ofNullable(medicamentMapper.mapToMedicamentList(resultSet));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();

    }
    @Override
    public void addNewObject(Medicament Medicament) {
        String insertSql = "INSERT INTO medicament (id, nume, pret, tipMedicament) VALUES (?, ?,?,?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, Medicament.getId().toString());
            preparedStatement.setString(2, Medicament.getNume().toString());
            // preparedStatement.setDouble(3, Medicament.getPret().doubleValue());
            preparedStatement.setString(4, Medicament.getTipMedicament().toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Medicament> getAll() {
        String selectSql = "SELECT * FROM medicament";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            return medicamentMapper.mapToMedicamentList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List.of();
    }

    @Override
    public void addAllFromGivenList(List<Medicament> MedicamentList) {
        MedicamentList.forEach(this::addNewObject);
    }
}