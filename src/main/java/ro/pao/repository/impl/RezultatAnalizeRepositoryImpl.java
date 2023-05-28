package ro.pao.repository.impl;
import ro.pao.config.DatabaseConfiguration;
import ro.pao.mapper.RezultatAnalizeMapper;
import ro.pao.model.RezultatAnalize;
import ro.pao.repository.RezultatAnalizeRepository;
import java.sql.*;
import java.util.List;
import java.util.Optional;

public abstract class RezultatAnalizeRepositoryImpl implements RezultatAnalizeRepository {

    private static final RezultatAnalizeMapper rezultatAnalizeMapper = RezultatAnalizeMapper.getInstance();
    private RezultatAnalize pacient;

    @Override
    public Optional<RezultatAnalize> getRezultatAnalizeBypacient(RezultatAnalize pacient) {
        String id_app = "SELECT * FROM rezultatAnalize WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(id_app)) {
            preparedStatement.setString(1, pacient.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return RezultatAnalizeMapper.mapToRezultatAnalize(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public Optional<List<RezultatAnalize>> getObjectByrezultate(RezultatAnalize rezultate) {
        String selectSql = "SELECT * FROM rezultatAnalize WHERE rezultate =?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, rezultate.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return Optional.ofNullable(RezultatAnalizeMapper.mapToRezultatAnalizeList(resultSet));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();

    }

    @Override
    public Optional<RezultatAnalize> getRezultatAnalizeBypacient() {
        Optional<RezultatAnalize> rezultatAnalizeBypacient = getRezultatAnalizeBypacient(null);
        return rezultatAnalizeBypacient;
    }


    @Override
    public void deleteRezultatAnalizeBypacient(RezultatAnalize pacient) {
        String updateNameSql = "DELETE FROM rezultatAnalize WHERE pacient =?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, pacient.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateRezultatAnalizeBypacient(RezultatAnalize pacient, RezultatAnalize newRezultatAnalize) {
        String updateNameSql = "UPDATE rezultatAnalize SET rezultat =? WHERE pacient =?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, pacient.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<RezultatAnalize> getAll() {
        String selectSql = "SELECT * FROM rezultatAnalize";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            return rezultatAnalizeMapper.mapToRezultatAnalizeList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List.of();
    }

    @Override
    public void addAllFromGivenList(List<RezultatAnalize> RezultatAnalizeList) {
        RezultatAnalizeList.forEach(this::addRezultatAnalize);
    }

    private void addRezultatAnalize(RezultatAnalize rezultatAnalize) {
    }

}