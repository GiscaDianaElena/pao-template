package ro.pao.repository.impl;

import ro.pao.config.DatabaseConfiguration;
import ro.pao.mapper.TratamentMapper;
import ro.pao.model.Tratament;
import ro.pao.repository.TratamentRepository;

import java.sql.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class TratamentRepositoryImpl implements TratamentRepository {

    private static final TratamentMapper tratamentMapper = TratamentMapper.getInstance();

    @Override
    public Optional<Tratament> getObjectById(UUID id) {
        String selectSql = "SELECT * FROM tratament WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return tratamentMapper.mapToTratament(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void deleteObjectById(UUID id) {
        String updateNameSql = "DELETE FROM tratament WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateObjectById(UUID id, Tratament newObject) {
        String updateNameSql = "UPDATE tratament SET nume =? WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, newObject.getNume());
            preparedStatement.setString(2, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addNewObject(Tratament Tratament) {
        String insertSql = "INSERT INTO Tratament (idTratament, nume, dataPrescrierii) VALUES (?, ?,?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, Tratament.getIdTratament().toString());
            preparedStatement.setString(2, Tratament.getNume().toString());
            preparedStatement.setDate(3, Date.valueOf(Tratament.getDataPrescrierii().toString()));


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Tratament> getAll() {
        String selectSql = "SELECT * FROM tratament";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            return tratamentMapper.mapToTratamentList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List.of();
    }

    @Override
    public void addAllFromGivenList(List<Tratament> TratamentList) {
        TratamentList.forEach(this::addNewObject);
    }
}