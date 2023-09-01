package ro.pao.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ServiciiMedicaleService {
    static List<ServiciiMedicale> serviciiMedicaleList = new ArrayList<>();
    // o lista unde stocam toate serviciile medicale

    List<ServiciiMedicale> showAllServiciiMedicale();

    Optional<ServiciiMedicale> getServiciiMedicalebyId(UUID id);

    List<ServiciiMedicale> getAllFromList();

    void addAllFromGivenList(List<ServiciiMedicale> serviciiMedicaleList);

    void addOnlyOne(ServiciiMedicale serviciiMedicale);
}
