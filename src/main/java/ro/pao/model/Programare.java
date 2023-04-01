package ro.pao.model;

import java.time.Duration;
import java.time.LocalDateTime;

public class Programare {
    private LocalDateTime dataOra;
    private Medici medic;
    private Pacient pacient;
    private ServiciiMedicale serviciiMedicale;
    private Duration durata;
    private String status;

    public Programare(LocalDateTime dataOra, Medici medic, Pacient pacient, ServiciiMedicale serviciiMedicale, Duration durata,
                      String status){
        this.dataOra = dataOra;
        this.medic = medic;
        this.pacient = pacient;
        this.serviciiMedicale = serviciiMedicale;
        this.durata = durata;
        this.status = status;
    }

    public LocalDateTime getDataOra() {
        return dataOra;
    }

    public void setDataOra(LocalDateTime dataOra) {
        this.dataOra = dataOra;
    }

    public Medici getMedic() {
        return medic;
    }

    public void setMedic(Medici medic) {
        this.medic = medic;
    }

    public Pacient getPacient() {
        return pacient;
    }

    public void setPacient(Pacient pacient) {
        this.pacient = pacient;
    }

    public ServiciiMedicale getServiciiMedicale() {
        return serviciiMedicale;
    }

    public void setServiciiMedicale(ServiciiMedicale serviciiMedicale) {
        this.serviciiMedicale = serviciiMedicale;
    }

    public Duration getDurata() {
        return durata;
    }

    public void setDurata(Duration durata) {
        this.durata = durata;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
