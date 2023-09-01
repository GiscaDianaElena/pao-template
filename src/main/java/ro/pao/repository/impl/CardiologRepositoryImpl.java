package ro.pao.repository.impl;

import ro.pao.config.DatabaseConfiguration;
import ro.pao.mapper.CardiologMapper;
import ro.pao.model.Cardiolog;
import ro.pao.repository.CardiologRepository;

import java.sql.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CardiologRepositoryImpl implements CardiologRepository {

    private static final CardiologMapper cardiologMapper = CardiologMapper.getInstance();

    @Override
    public Optional<Cardiolog> getObjectById(UUID id) {
        String selectSql = "SELECT * FROM cardiolog WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return cardiologMapper.mapToCardiolog(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void deleteObjectById(UUID id) {
        String updateNameSql = "DELETE FROM cardiolog WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateObjectById(UUID id, Cardiolog newObject) {
        String updateNameSql = "UPDATE cardiolog SET salariu=? WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setDouble(1, newObject.getSalariu().double());
            preparedStatement.setString(2, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addNewObject(Cardiolog Cardiolog) {
        String insertSql = "INSERT INTO cardiolog (idPersoana, nume , prenume, email,cnp, adresa , numarTelefon , " +
                "data , experienta , salariu) VALUES (?, ?,?,?,?,?,?,?,?,?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, Cardiolog.getIdPersoana().toString());
            preparedStatement.setString(2, Cardiolog.getNume().toString());
            preparedStatement.setString(3, Cardiolog.getPrenume().toString());
            preparedStatement.setString(4, Cardiolog.getEmail().toString());
            preparedStatement.setString(5, Cardiolog.getCNP().toString());
            preparedStatement.setString(6, Cardiolog.getAdresa().toString());
            preparedStatement.setString(7, Cardiolog.getNumarTelefon().toString());
            preparedStatement.setDate(8, Date.valueOf(Cardiolog.getData_angajare().toString()));
            preparedStatement.setInt(9, Cardiolog.getExperienta().intValue());
            preparedStatement.setDouble(10, Cardiolog.getSalariu().doubleValue());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Cardiolog> getAll() {
        String selectSql = "SELECT * FROM cardiolog";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            return cardiologMapper.mapToCardiologList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List.of();
    }

    @Override
    public void addAllFromGivenList(List<Cardiolog> CardiologList) {
        CardiologList.forEach(this::addNewObject);
    }
}