package ro.pao.repository.impl;
import ro.pao.config.DatabaseConfiguration;
import ro.pao.mapper.MediciMapper;
import ro.pao.model.Medici;
import ro.pao.repository.MediciRepository;
import java.sql.*;
import java.util.List;
import java.util.Optional;

public abstract class MediciRepositoryImpl implements MediciRepository {

    private static final MediciMapper mediciMapper = MediciMapper.getInstance();
    private Medici nume;

    @Override
    public Optional<Medici> getMediciBynume(Medici nume) {
        String id_app = "SELECT * FROM appointment WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(id_app)) {
            preparedStatement.setString(1, nume.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return MediciMapper.mapToMedici(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    /*
    @Override
    public Optional<List<Medici>> getObjectBynume(Medici nume) {
        String selectSql = "SELECT * FROM appointment WHERE nume =?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, nume.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return Optional.ofNullable(MediciMapper.mapToMediciList(resultSet));
        } catch (SQLException e) {
            e.printStackTrace();
        }
     */

    // return Optional.empty();

    //  }

    @Override
    public Optional<List<Medici>> getObjectBynume(Medici nume) {
        String selectSql = "SELECT * FROM medici WHERE nume =?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, nume.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return Optional.ofNullable(MediciMapper.mapToMediciList(resultSet));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();

    }

    /*
    @Override
    public void deleteMediciBynume() {
        deleteMediciBynume(null);
    }
     */

    /*
    @Override
    public void deleteMediciBynume(Medici nume) {
    }
     */

    /*
    @Override
    public void updateMediciBynume(Medici nume, Medici newMedici) {

    }

    @Override
    public void addNewMedici(Medici Medici) {

    }
     */

    @Override
    public Optional<Medici> getMediciBynume() {
        Optional<Medici> mediciBynume = getMediciBynume(null);
        return mediciBynume;
    }

    /*
    @Override
    public Optional<Medici> getMediciBynume(Medici nume) {
        this.nume = nume;
        return Optional.empty();
    }
     */

    @Override
    public void deleteMediciBynume(Medici nume) {
        String updateNameSql = "DELETE FROM appointment WHERE nume =?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, nume.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateMediciBynume(Medici nume, Medici newMedici) {
        String updateNameSql = "UPDATE medici SET prenume=? WHERE nume=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, nume.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Medici> getAll() {
        String selectSql = "SELECT * FROM medici";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            return mediciMapper.mapToMediciList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List.of();
    }

    @Override
    public void addAllFromGivenList(List<Medici> MediciList) {
        MediciList.forEach(this::addMedici);
    }

    private void addMedici(Medici medici) {
    }
}