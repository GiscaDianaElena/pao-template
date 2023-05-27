package ro.pao.mapper;

import ro.pao.model.Promotii;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PromotiiMapper{

    private static final PromotiiMapper INSTANCE = new PromotiiMapper();

    private PromotiiMapper(){
    }

    public static PromotiiMapper getInstance(){
        return INSTANCE;
    }

    public Optional<Promotii> mapToPromotii(ResultSet resultSet) throws SQLException {
        if(resultSet.next()){
            return Optional.of(
                    Promotii.builder()
                            .numePromotie(resultSet.getString(1))
                            .descriere(resultSet.getString(2))
                            // .perioada(resultSet.getDate(3))
                            .codPromotional(resultSet.getString(4))
                            .restrictii(resultSet.getString(5))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public List<Promotii> mapToPromotiiList(ResultSet resultSet) throws SQLException {
        List<Promotii> PromotiiList = new ArrayList<>();
        while (resultSet.next()) {
            PromotiiList.add(
                    Promotii.builder()
                            .numePromotie(resultSet.getString(1))
                            .descriere(resultSet.getString(2))
                            // .perioada(resultSet.getDate(3))
                            .codPromotional(resultSet.getString(4))
                            .restrictii(resultSet.getString(5))
                            .build()
            );
        }

        return PromotiiList;
    }
}