package ro.pao.repository.impl;
import ro.pao.config.DatabaseConfiguration;
import ro.pao.mapper.ProgramareMapper;
import ro.pao.model.Programare;
import ro.pao.repository.ProgramareRepository;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ProgramareRepositoryImpl implements ProgramareRepository {

    private static final ProgramareMapper programareMapper = ProgramareMapper.getInstance();

    @Override
    public Optional<Programare> getProgramareById(UUID id) {
        String id_app = "SELECT * FROM programare WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(id_app)) {
            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return programareMapper.mapToProgramare(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public Optional<Programare> getProgramareByData(Data data) {
        return Optional.empty();
    }

    @Override
    public Optional<Programare> getProgramareByMedici(UUID id) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Programare>> getObjectByData(String data) {
        String selectSql = "SELECT * FROM programare WHERE data=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, data.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return Optional.ofNullable(programareMapper.mapToProgramareList(resultSet));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();

    }

    @Override
    public Optional<List<Programare>> getObjectByMedici(UUID id) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Programare>> getObjectByDoctor(UUID id) {
        String selectSql = "SELECT * FROM programare WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return Optional.ofNullable(programareMapper.mapToProgramareList(resultSet));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();

    }
    @Override
    public void deleteProgramareById(UUID id) {
        String updateNameSql = "DELETE FROM programare WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateProgramareById(UUID id, Programare newProgramare) {
        String updateNameSql = "UPDATE programare SET price=? WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setDouble(1, newProgramare.getPret());
            preparedStatement.setString(2, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addNewProgramare(Programare Programare) {
        String insertSql = "INSERT INTO programare (idProgramare, data, pret, id_medici) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, Programare.getIdProgramare().toString());
            preparedStatement.setString(2, Programare.getData().toString());
            preparedStatement.setDouble(3, Programare.getPret().doubleValue());
            preparedStatement.setString(4, Programare.getId_medici().toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Programare> getAll() {
        String selectSql = "SELECT * FROM programare";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            return programareMapper.mapToProgramareList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List.of();
    }

    @Override
    public void addAllFromGivenList(List<Programare> ProgramareList) {
        ProgramareList.forEach(this::addNewProgramare);
    }
}