package ro.pao.mapper;

import ro.pao.model.Factura;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaMapper{

    private static final FacturaMapper INSTANCE = new FacturaMapper();

    private FacturaMapper(){
    }

    public static FacturaMapper getInstance(){
        return INSTANCE;
    }

    public static Optional<Factura> mapToFactura(ResultSet resultSet) throws SQLException {
        if(resultSet.next()){
            return Optional.of(
                    Factura.builder()
                            .numarFactura(resultSet.getInt(1))
                            // .dataEmiterii(resultSet.getDate(2))
                            // .pacient(resultSet.getString(3))
                           //  .serviciiMedicale(resultSet.getString(4))
                            .total(resultSet.getDouble(5))
                           // .status(resultSet.getString(6))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public List<Factura> mapToFacturaList(ResultSet resultSet) throws SQLException {
        List<Factura> FacturaList = new ArrayList<>();
        while (resultSet.next()) {
            FacturaList.add(
                    Factura.builder()
                            .numarFactura(resultSet.getInt(1))
                            // .dataEmiterii(resultSet.getDate(2))
                            // .pacient(resultSet.getString(3))
                           // .serviciiMedicale(resultSet.getString(4))
                            .total(resultSet.getDouble(5))
                            // .status(resultSet.getString(6))
                            .build()
            );
        }

        return FacturaList;
    }
}