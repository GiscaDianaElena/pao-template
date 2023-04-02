package ro.pao.service;

import ro.pao.model.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FacturaService {
    static List<Factura> facturaList = new ArrayList<>();
    // o lista unde stocam toate facturile

    List<Factura> showAllFactura();

    Optional<Factura> getFacturabyId(UUID id);

    List<Factura> getAllFromList();

    void addAllFromGivenList(List<Factura> facturaList);

    void addOnlyOne(Factura factura);
}
