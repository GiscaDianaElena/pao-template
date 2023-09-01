package ro.pao.repository.impl;

import ro.pao.config.DatabaseConfiguration;
import ro.pao.mapper.OftalmologMapper;
import ro.pao.model.Oftalmolog;
import ro.pao.repository.OftalmologRepository;

import java.sql.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class OftalmologRepositoryImpl implements OftalmologRepository {

    private static final OftalmologMapper oftalmologMapper = OftalmologMapper.getInstance();

    @Override
    public Optional<Oftalmolog> getObjectById(UUID id) {
        String selectSql = "SELECT * FROM Oftalmolog WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return oftalmologMapper.mapToOftalmolog(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void deleteObjectById(UUID id) {
        String updateNameSql = "DELETE FROM Oftalmolog WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateObjectById(UUID id, Oftalmolog newObject) {
        String updateNameSql = "UPDATE Oftalmolog SET salariu =? WHERE id=?";

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
    public void addNewObject(Oftalmolog Oftalmolog) {
        String insertSql = "INSERT INTO Ophthalmologist (id, name,last_name, email,cnp,address,phone_number,hire_date,experience,salary) VALUES (?, ?,?,?,?,?,?,?,?,?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, Oftalmolog.getIdPersoana().toString());
            preparedStatement.setString(2, Oftalmolog.getNume().toString());
            preparedStatement.setString(3, Oftalmolog.getPrenume().toString());
            preparedStatement.setString(4, Oftalmolog.getEmail().toString());
            preparedStatement.setString(5, Oftalmolog.getCNP().toString());
            preparedStatement.setString(6, Oftalmolog.getAdresa().toString());
            preparedStatement.setString(7, Oftalmolog.getNumarTelefon().toString());
            preparedStatement.setDate(8, Date.valueOf(Oftalmolog.getData_angajare().toString()));
            preparedStatement.setInt(9, Oftalmolog.getExperienta().intValue());
            // preparedStatement.setDouble(10, Oftalmolog.getSalariu().doubleValue());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Oftalmolog> getAll() {
        String selectSql = "SELECT * FROM Oftalmolog";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            return oftalmologMapper.mapToOftalmologList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List.of();
    }

    @Override
    public void addAllFromGivenList(List<Oftalmolog> OftalmologList) {
        OftalmologList.forEach(this::addNewObject);
    }
}