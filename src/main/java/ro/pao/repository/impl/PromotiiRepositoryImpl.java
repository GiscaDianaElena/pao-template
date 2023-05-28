package ro.pao.repository.impl;
import ro.pao.config.DatabaseConfiguration;
import ro.pao.mapper.PromotiiMapper;
import ro.pao.model.Promotii;
import ro.pao.repository.PromotiiRepository;
import java.sql.*;
import java.util.List;
import java.util.Optional;

public abstract class PromotiiRepositoryImpl implements PromotiiRepository {

    private static final PromotiiMapper promotiiMapper = PromotiiMapper.getInstance();
    private Promotii numePromotie;

    @Override
    public Optional<Promotii> getPromotiiBynumePromotie(Promotii numePromotie) {
        String id_app = "SELECT * FROM appointment WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(id_app)) {
            preparedStatement.setString(1, numePromotie.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return PromotiiMapper.mapToPromotii(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public Optional<List<Promotii>> getObjectBycodPromotional(Promotii codPromotional) {
        String selectSql = "SELECT * FROM promotii WHERE codPromotional =?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, codPromotional.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return Optional.ofNullable(PromotiiMapper.mapToPromotiiList(resultSet));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();

    }

    @Override
    public Optional<Promotii> getPromotiiBynumePromotie() {
        Optional<Promotii> promotiiBynumePromotie = getPromotiiBynumePromotie(null);
        return promotiiBynumePromotie;
    }


    @Override
    public void deletePromotiiBynumePromotie(Promotii numePromotie) {
        String updateNameSql = "DELETE FROM promotii WHERE numePromotie =?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, numePromotie.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePromotiiBynumePromotie(Promotii numePromotie, Promotii newPromotii) {
        String updateNameSql = "UPDATE promotii SET codPromotional =? WHERE numePromotie =?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, numePromotie.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Promotii> getAll() {
        String selectSql = "SELECT * FROM promotii";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            return promotiiMapper.mapToPromotiiList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List.of();
    }

    @Override
    public void addAllFromGivenList(List<Promotii> PromotiiList) {
        PromotiiList.forEach(this::addPromotii);
    }

    private void addPromotii(Promotii promotii) {
    }

}