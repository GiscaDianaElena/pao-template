package ro.pao.repository;

import ro.pao.model.ServiciiMedicale;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ServiciiMedicaleRepository {

    Optional<ServiciiMedicale> getServiciiMedicaleBynumeServiciu(ServiciiMedicale numeServiciu);

    Optional<List<ServiciiMedicale>> getObjectBydescriere(ServiciiMedicale descriere);

    void deleteServiciiMedicaleBynumeServiciu(ServiciiMedicale numeServiciu);

    void updateServiciiMedicaleBynumeServiciu(ServiciiMedicale numeServiciu, ServiciiMedicale newServiciiMedicale);

    void addNewServiciiMedicale(ServiciiMedicale ServiciiMedicale);

    Optional<ServiciiMedicale> getServiciiMedicaleBynumeServiciu();

    List<ServiciiMedicale> getAll();

    void addAllFromGivenList(List<ServiciiMedicale> ServiciiMedicaleList);
}