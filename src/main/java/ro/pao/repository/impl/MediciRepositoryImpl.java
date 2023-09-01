package ro.pao.repository.impl;
import ro.pao.config.DatabaseConfiguration;
import ro.pao.mapper.MediciMapper;
import ro.pao.model.Medici;
import ro.pao.repository.MediciRepository;
import ro.pao.threads.AsyncLogger;
import ro.pao.threads.ThreadExecuter;

import java.sql.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;


public class MediciRepositoryImpl implements MediciRepository {

    private static final MediciMapper mediciMapper = MediciMapper.getInstance();

    @Override
    public Optional<Medici> getMediciById(String id) {
        String selectSql = "SELECT * FROM medici WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return mediciMapper.mapToMedici(resultSet);
        } catch (SQLException e) {
            AsyncLogger.getInstance().log(Level.SEVERE,
                    "A esuat cautarea doctorului dupa id\n" + e.getMessage());
        }

        return Optional.empty();
    }
    @Override
    public Optional<List<Medici>> getObjectByName(String name) {
        String selectSql = "SELECT * FROM medici WHERE name = ?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, name.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return Optional.ofNullable(mediciMapper.mapToMediciList(resultSet));
        } catch (SQLException e) {
            AsyncLogger.getInstance().log(Level.SEVERE,
                    "A esuat cautarea doctorului dupa nume\n" + e.getMessage());
        }

        return Optional.empty();

    }

    @Override
    public void deleteMediciById(String id) {
        String updateNameSql = "DELETE FROM medici WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)){
            preparedStatement.setString(1, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            ThreadExecuter.getInstance().add(() -> {
                AsyncLogger.getInstance().log(Level.SEVERE,
                        "A esuat stergerea doctorului\n" + e.getMessage());
            });
        }
    }



    @Override
    public void updateMediciById(String id, Medici newMedici) {
        String updateNameSql = "UPDATE medici SET salariu =? WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            // preparedStatement.setDouble(1, newMedici.getSalariu().doubleValue());
            preparedStatement.setString(2, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            AsyncLogger.getInstance().log(Level.SEVERE,
                    "A esuat updatarea doctorului\n" + e.getMessage());
        }
    }

    @Override
    public void addNewMedici(Medici Medici) {
        String insertSql = "INSERT INTO medici (id, nume, prenume, email, cnp, adresa , numarTelefon, " +
                "data_angajare, experienta, salariu) VALUES (?, ?,?,?,?,?,?,?,?,?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, Medici.getIdPersoana().toString());
            preparedStatement.setString(2, Medici.getNume().toString());
            preparedStatement.setString(3, Medici.getPrenume().toString());
            preparedStatement.setString(4, Medici.getEmail().toString());
            preparedStatement.setString(5, Medici.getCNP().toString());
            preparedStatement.setString(6, Medici.getAdresa().toString());
            preparedStatement.setString(7, Medici.getNumarTelefon().toString());
            preparedStatement.setString(8, Medici.getData_angajare().toString());
            preparedStatement.setInt(9, Medici.getExperienta().intValue());
            // preparedStatement.setDouble(10, Medici.getSalariu().doubleValue());



            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            AsyncLogger.getInstance().log(Level.SEVERE,
                    "A esuat inserarea doctorului\n" + e.getMessage());
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
            AsyncLogger.getInstance().log(Level.SEVERE,
                    "A esuat de a afisa toti doctorii\n" + e.getMessage());
        }

        return List.of();
    }

    @Override
    public void addAllFromGivenList(List<Medici> MediciList) {
        MediciList.forEach(this::addNewMedici);
    }
}