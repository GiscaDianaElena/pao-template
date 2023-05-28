package ro.pao.repository.impl;
import ro.pao.config.DatabaseConfiguration;
import ro.pao.mapper.FacturaMapper;
import ro.pao.model.Factura;
import ro.pao.repository.FacturaRepository;
import java.sql.*;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public abstract class FacturaRepositoryImpl implements FacturaRepository {

    private static final FacturaMapper facturaMapper = FacturaMapper.getInstance();
    private Factura numarFactura;

    @Override
    public Optional<Factura> getFacturaBynumarFactura(Factura numarFactura) {
        String id_app = "SELECT * FROM appointment WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(id_app)) {
            preparedStatement.setString(1, numarFactura.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return FacturaMapper.mapToFactura(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }
    @Override
    public Optional<List<Factura>> getObjectBydataEmiterii(Date dataEmiterii) {
        String selectSql = "SELECT * FROM appointment WHERE dataEmiterii =?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, dataEmiterii.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return Optional.ofNullable(facturaMapper.mapToFacturaList(resultSet));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();

    }

    @Override
    public Optional<List<Factura>> getObjectBydataEmiterii(Factura dataEmiterii) {
        String selectSql = "SELECT * FROM appointment WHERE dataEmiterii =?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, dataEmiterii.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return Optional.ofNullable(facturaMapper.mapToFacturaList(resultSet));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();

    }

    /*
    @Override
    public void deleteFacturaBynumarFactura(Factura numarFactura) {
      }

    @Override
    public void updateFacturaBynumarFactura(Factura numarFactura, Factura newFactura) {

    }

    @Override
    public void addNewFactura(Factura Factura) {

    }
     */

    @Override
    public Optional<Factura> getFacturaBynumarFactura() {
        Optional<Factura> facturaBynumarFactura = getFacturaBynumarFactura(null);
        return facturaBynumarFactura;
    }

    /*
    @Override
    public Optional<Factura> getFacturaBynumarFactura(Factura numarFactura) {
        this.numarFactura = numarFactura;
        return Optional.empty();
    }
     */

    @Override
    public void deleteFacturaBynumarFactura(Factura numarFactura) {
        String updateNameSql = "DELETE FROM appointment WHERE numarFactura =?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, numarFactura.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateFacturaBydataEmiterii(Factura dataEmiterii, Factura newFactura) {
        String updateNameSql = "UPDATE appointment SET price=? WHERE dataEmiterii=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, dataEmiterii.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addNewFactura(Factura Factura) {
        String insertSql = "INSERT INTO factura (numarFactura, dataEmiterii, pacient, serviciiMedicale, total, " +
                "status) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            // preparedStatement.setInt(1, Factura.getNumarFactura().toString());
            preparedStatement.setString(2, Factura.getDataEmiterii().toString());
            // preparedStatement.setDouble(3, Factura.getPacient().toString());
            preparedStatement.setString(4,Factura.getServiciiMedicale().toString());
            // preparedStatement.setDouble(5,Factura.getTotal().toString());
            preparedStatement.setString(6,Factura.getStatus().toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Factura> getAll() {
        String selectSql = "SELECT * FROM factura";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            return facturaMapper.mapToFacturaList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List.of();
    }

    @Override
    public void addAllFromGivenList(List<Factura> FacturaList) {
        FacturaList.forEach(this::addNewFactura);
    }
}