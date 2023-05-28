package ro.pao.repository.impl;
import ro.pao.config.DatabaseConfiguration;
import ro.pao.mapper.ServiciiMedicaleMapper;
import ro.pao.model.ServiciiMedicale;
import ro.pao.repository.ServiciiMedicaleRepository;
import java.sql.*;
import java.util.List;
import java.util.Optional;

public abstract class ServiciiMedicaleRepositoryImpl implements ServiciiMedicaleRepository {

    private static final ServiciiMedicaleMapper serviciiMedicaleMapper = ServiciiMedicaleMapper.getInstance();
    private ServiciiMedicale numeServiciu;

    @Override
    public Optional<ServiciiMedicale> getServiciiMedicaleBynumeServiciu(ServiciiMedicale numeServiciu) {
        String id_app = "SELECT * FROM serviciiMedicale WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(id_app)) {
            preparedStatement.setString(1, numeServiciu.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return ServiciiMedicaleMapper.mapToServiciiMedicale(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public Optional<List<ServiciiMedicale>> getObjectBydescriere(ServiciiMedicale descriere) {
        String selectSql = "SELECT * FROM serviciiMedicale WHERE descriere =?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, descriere.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return Optional.ofNullable(ServiciiMedicaleMapper.mapToServiciiMedicaleList(resultSet));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();

    }

    @Override
    public Optional<ServiciiMedicale> getServiciiMedicaleBynumeServiciu() {
        Optional<ServiciiMedicale> serviciiMedicaleBynumeServiciu = getServiciiMedicaleBynumeServiciu(null);
        return serviciiMedicaleBynumeServiciu;
    }


    @Override
    public void deleteServiciiMedicaleBynumeServiciu(ServiciiMedicale numeServiciu) {
        String updateNameSql = "DELETE FROM serviciiMedicale WHERE numeServiciu =?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, numeServiciu.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateServiciiMedicaleBynumeServiciu(ServiciiMedicale numeServiciu, ServiciiMedicale newServiciiMedicale) {
        String updateNameSql = "UPDATE serviciiMedicale SET descriere =? WHERE numeServiciu =?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, numeServiciu.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<ServiciiMedicale> getAll() {
        String selectSql = "SELECT * FROM serviciiMedicale";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            return serviciiMedicaleMapper.mapToServiciiMedicaleList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List.of();
    }

    @Override
    public void addAllFromGivenList(List<ServiciiMedicale> ServiciiMedicaleList) {
        ServiciiMedicaleList.forEach(this::addServiciiMedicale);
    }

    private void addServiciiMedicale(ServiciiMedicale serviciiMedicale) {
    }

}