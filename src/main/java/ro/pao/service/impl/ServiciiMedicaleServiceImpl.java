package ro.pao.service.impl;

import ro.pao.service.ServiciiMedicaleService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ServiciiMedicaleServiceImpl implements ServiciiMedicaleService {
    private static List<ServiciiMedicale> serviciiMedicaleList = new ArrayList<>();

    public List<ServiciiMedicale> showAllServiciiMedicale() {
        return serviciiMedicaleList;
    }

    @Override
    public Optional<ServiciiMedicale> getServiciiMedicalebyId(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<ServiciiMedicale> getAllFromList() {
        return serviciiMedicaleList;
    }

    @Override
    public void addAllFromGivenList(List<ServiciiMedicale> serviciiMedicaleList) {
        serviciiMedicaleList.addAll(serviciiMedicaleList);
    }

    @Override
    public void addOnlyOne(ServiciiMedicale serviciiMedicale) {
        serviciiMedicaleList.add(null);
    }
}
