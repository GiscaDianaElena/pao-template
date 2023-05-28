package ro.pao.repository.impl;
import ro.pao.config.DatabaseConfiguration;
import ro.pao.mapper.TratamentMapper;
import ro.pao.model.Tratament;
import ro.pao.repository.TratamentRepository;
import java.sql.*;
import java.util.List;
import java.util.Optional;

public abstract class TratamentRepositoryImpl implements TratamentRepository {

    private static final TratamentMapper tratamentMapper = TratamentMapper.getInstance();
    private Tratament pacient;

    @Override
    public Optional<Tratament> getTratamentBypacient(Tratament pacient) {
        String id_app = "SELECT * FROM tratament WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(id_app)) {
            preparedStatement.setString(1, pacient.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return TratamentMapper.mapToTratament(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public Optional<List<Tratament>> getObjectBymedicamente(Tratament medicamente) {
        String selectSql = "SELECT * FROM tratament WHERE medicamente =?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, medicamente.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return Optional.ofNullable(TratamentMapper.mapToTratamentList(resultSet));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();

    }

    @Override
    public Optional<Tratament> getTratamentBypacient() {
        Optional<Tratament> tratamentBypacient = getTratamentBypacient(null);
        return tratamentBypacient;
    }


    @Override
    public void deleteTratamentBypacient(Tratament pacient) {
        String updateNameSql = "DELETE FROM tratament WHERE pacient =?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, pacient.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateTratamentBypacient(Tratament pacient, Tratament newTratament) {
        String updateNameSql = "UPDATE tratament SET medicamente =? WHERE pacient =?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, pacient.toString());

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
        TratamentList.forEach(this::addTratament);
    }

    private void addTratament(Tratament tratament) {
    }

}