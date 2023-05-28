package ro.pao.repository;

import ro.pao.model.Factura;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FacturaRepository {

    Optional<Factura> getFacturaBynumarFactura();

    /*
    Optional<Factura> getFacturaBynumarFactura(Factura numarFactura);
     */

    Optional<List<Factura>> getObjectBydataEmiterii(Factura dataEmiterii);

    void deleteFacturaBynumarFactura(Factura numarFactura);

    void updateFacturaBynumarFactura(Factura numarFactura, Factura newFactura);

    void addNewFactura(Factura Factura);

    Optional<Factura> getFacturatBynumarFactura(Factura numarFactura);

    Optional<List<Factura>> getObjectBydataEmiterii(Date dataEmiterii);

    Optional<Factura> getFacturaBynumarFactura(Factura numarFactura);

    abstract void deleteFacturatBynumarFactura(Factura numarFactura);

    void updateFacturaBydataEmiterii(Factura dataEmiterii, Factura newFactura);

    void addNewAppointment(Factura Factura);

    List<Factura> getAll();

    void addAllFromGivenList(List<Factura> FacturaList);
}