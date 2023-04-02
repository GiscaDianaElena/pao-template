package ro.pao.service.impl;

import ro.pao.model.ExampleClass;
import ro.pao.model.Factura;
import ro.pao.service.FacturaService;

import java.util.*;

import java.util.stream.Collectors;

public class FacturaServiceImpl implements FacturaService {
    private static List<Factura> facturaList = new ArrayList<>();

    public List<Factura> showAllFactura() {
        return facturaList;
    }

    @Override
    public Optional<Factura> getFacturabyId(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<Factura> getAllFromList() {
        return facturaList;
    }

    @Override
    public void addAllFromGivenList(List<Factura> facturaList) {
        facturaList.addAll(facturaList);
    }

    @Override
    public void addOnlyOne(Factura factura) {
        facturaList.add(null);
    }
}