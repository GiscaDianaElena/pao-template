package ro.pao.repository.impl;

import ro.pao.config.DatabaseConfiguration;
import ro.pao.mapper.PacientMapper;
import ro.pao.model.Pacient;
import ro.pao.repository.PacientRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PacientRepositoryImpl implements PacientRepository {

    private static final PacientMapper pacientMapper = PacientMapper.getInstance();

    @Override
    public Optional<Pacient> getObjectById(UUID id) {
        String selectSql = "SELECT * FROM pacient WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return pacientMapper.mapToPacient(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void deleteObjectById(UUID id) {
        String updateNameSql = "DELETE FROM pacient WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateObjectById(UUID id, Pacient newObject) {
        String updateNameSql = "UPDATE pacient SET boala=? WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, newObject.getBoala());
            preparedStatement.setString(2, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addNewObject(Pacient Pacient) {
        String insertSql = "INSERT INTO person (id, name,last_name, email, cnp, address,phone_number, status, disease,blood_type,medical_insurance) VALUES (?, ?,?,?,?,?,?,?,?,?,?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, Pacient.getIdPersoana().toString());
            preparedStatement.setString(2, Pacient.getNume().toString());
            preparedStatement.setString(3, Pacient.getPrenume().toString());
            preparedStatement.setString(4, Pacient.getEmail().toString());
            preparedStatement.setString(5, Pacient.getCNP().toString());
            preparedStatement.setString(6, Pacient.getAdresa().toString());
            preparedStatement.setString(7, Pacient.getNumarTelefon().toString());
            preparedStatement.setString(8, Pacient.getStatus().toString());
            preparedStatement.setString(9, Pacient.getBoala().toString());
            preparedStatement.setString(10, Pacient.getGrupaSange());
            preparedStatement.setString(11, Pacient.getAsigurareMedicala());


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Pacient> getAll() {
        String selectSql = "SELECT * FROM pacient p,person pr where p.id = pr.id";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            return pacientMapper.mapToPacientList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List.of();
    }

    @Override
    public void addAllFromGivenList(List<Pacient> PacientList) {
        PacientList.forEach(this::addNewObject);
    }
}