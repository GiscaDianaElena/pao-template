package ro.pao.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.Duration;
import java.time.LocalDateTime;


@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class Programare {
    private LocalDateTime dataOra;
    private Medici medic;
    private Pacient pacient;
    private ServiciiMedicale serviciiMedicale;
    private Duration durata;
    private StatutProgramare status;

    public Programare(LocalDateTime dataOra, Medici medic, Pacient pacient, ServiciiMedicale serviciiMedicale, Duration durata,
                      StatutProgramare status){
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

    public StatutProgramare getStatus() {
        return status;
    }

    public void setStatus(StatutProgramare status) {
        this.status = status;
    }

    public String toString(){
        return "Programare: " + dataOra + ", Status: " + status;
    }
}
