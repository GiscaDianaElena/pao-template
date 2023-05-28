package ro.pao.repository.impl;
import ro.pao.config.DatabaseConfiguration;
import ro.pao.mapper.FisaMedicalaMapper;
import ro.pao.model.FisaMedicala;
import ro.pao.repository.FisaMedicalaRepository;
import java.sql.*;
import java.util.List;
import java.util.Optional;

public abstract class FisaMedicalaRepositoryImpl implements FisaMedicalaRepository {

    private static final FisaMedicalaMapper fisaMedicalaMapper = FisaMedicalaMapper.getInstance();
    private FisaMedicala pacient;

    @Override
    public Optional<FisaMedicala> getFisaMedicalaBypacient(FisaMedicala pacient) {
        String id_app = "SELECT * FROM appointment WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(id_app)) {
            preparedStatement.setString(1, pacient.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return FisaMedicalaMapper.mapToFisaMedicala(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    /*
    @Override
    public Optional<List<FisaMedicala>> getObjectBypacient(FisaMedicala pacient) {
        String selectSql = "SELECT * FROM appointment WHERE pacient =?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, pacient.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return Optional.ofNullable(FisaMedicalaMapper.mapToFisaMedicalaList(resultSet));
        } catch (SQLException e) {
            e.printStackTrace();
        }
     */

       // return Optional.empty();

   //  }

    @Override
    public Optional<List<FisaMedicala>> getObjectBypacient(FisaMedicala pacient) {
        String selectSql = "SELECT * FROM appointment WHERE pacient =?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, pacient.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return Optional.ofNullable(FisaMedicalaMapper.mapToFisaMedicalaList(resultSet));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();

    }

    /*
    @Override
    public void deleteFisaMedicalaBypacient() {
        deleteFisaMedicalaBypacient(null);
    }
     */

    /*
    @Override
    public void deleteFisaMedicalaBypacient(FisaMedicala pacient) {
    }
     */

    /*
    @Override
    public void updateFisaMedicalaBypacient(FisaMedicala pacient, FisaMedicala newFisaMedicala) {

    }

    @Override
    public void addNewFisaMedicala(FisaMedicala FisaMedicala) {

    }
     */

    @Override
    public Optional<FisaMedicala> getFisaMedicalaBypacient() {
        Optional<FisaMedicala> fisaMedicalaBypacient = getFisaMedicalaBypacient(null);
        return fisaMedicalaBypacient;
    }

    /*
    @Override
    public Optional<Factura> getFacturaBynumarFactura(Factura numarFactura) {
        this.numarFactura = numarFactura;
        return Optional.empty();
    }
     */

    @Override
    public void deleteFisaMedicalaBypacient(FisaMedicala pacient) {
        String updateNameSql = "DELETE FROM appointment WHERE pacient =?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, pacient.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateFisaMedicalaBypacient(FisaMedicala pacient, FisaMedicala newFisaMedicala) {
        String updateNameSql = "UPDATE fisaMedicala SET total=? WHERE pacient=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, pacient.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
    @Override
    public void addNewFisaMedicala(FisaMedicala FisaMedicala) {
        String insertSql = "INSERT INTO fisaMedicala (pacient, medic, data, medicamente, alergii, boliCronice, " +
                "rezultatAnlize") wait (?, ?, ?, ?, ?, ?, ?)";


        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
             preparedStatement.setString(1, FisaMedicala.getPacient().toString());
             preparedStatement.setString(2, FisaMedicala.getMedic().toString());
             preparedStatement.setString(3, FisaMedicala.getData().toString());
             preparedStatement.setString(4, FisaMedicala.getMedicamente().toString());
             preparedStatement.setString(5, FisaMedicala.getAlergii().toString());
             preparedStatement.setString(6, FisaMedicala.getBoliCronice().toString());
             preparedStatement.setString(7, FisaMedicala.getRezultateAnalize().toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     */

    @Override
    public List<FisaMedicala> getAll() {
        String selectSql = "SELECT * FROM fisaMedicala";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            return fisaMedicalaMapper.mapToFisaMedicalaList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List.of();
    }

    @Override
    public void addAllFromGivenList(List<FisaMedicala> FisaMedicalaList) {
        FisaMedicalaList.forEach(this::addNewFisaMedicala);
    }
}