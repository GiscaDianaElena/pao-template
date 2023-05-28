package ro.pao.repository.impl;
import ro.pao.config.DatabaseConfiguration;
import ro.pao.mapper.ProgramareMapper;
import ro.pao.model.Programare;
import ro.pao.repository.ProgramareRepository;
import java.sql.*;
import java.util.List;
import java.util.Optional;

public abstract class ProgramareRepositoryImpl implements ProgramareRepository {

    private static final ProgramareMapper programareMapper = ProgramareMapper.getInstance();
    private Programare dataOra;

    @Override
    public Optional<Programare> getProgramareBydataOra(Programare dataOra) {
        String id_app = "SELECT * FROM appointment WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(id_app)) {
            preparedStatement.setString(1, dataOra.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return ProgramareMapper.mapToProgramare(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public Optional<List<Programare>> getObjectBydataOra(Programare dataOra) {
        String selectSql = "SELECT * FROM programare WHERE dataOra =?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, dataOra.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return Optional.ofNullable(ProgramareMapper.mapToProgramareList(resultSet));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();

    }

    @Override
    public Optional<Programare> getProgramareBydataOra() {
        Optional<Programare> programareBydataOra = getProgramareBydataOra(null);
        return programareBydataOra;
    }


    @Override
    public void deleteProgramareBydataOra(Programare dataOra) {
        String updateNameSql = "DELETE FROM programare WHERE dataOra =?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, dataOra.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateProgramareBydataOra(Programare dataOra, Programare newProgramare) {
        String updateNameSql = "UPDATE programare SET status=? WHERE dataOra=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, dataOra.toString());

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
        ProgramareList.forEach(this::addProgramare);
    }

    private void addProgramare(Programare programare) {
    }

}