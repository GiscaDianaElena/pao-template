package ro.pao.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.Duration;
import java.time.LocalDate;

@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder

public class Tratament {
    private Medici medic;
    private Pacient pacient;
    private LocalDate dataPrescrierii;
    private Medicament medicamente;
    private Duration durata;

    public Tratament(Medici medic, Pacient pacient, LocalDate dataPrescrierii, Medicament medicamente, Duration durata){
        this.medic = medic;
        this.pacient = pacient;
        this.dataPrescrierii = dataPrescrierii;
        this.medicamente = medicamente;
        this.durata = durata;
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

    public LocalDate getDataPrescrierii() {
        return dataPrescrierii;
    }

    public void setDataPrescrierii(LocalDate dataPrescrierii) {
        this.dataPrescrierii = dataPrescrierii;
    }

    public Medicament getMedicamente() {
        return medicamente;
    }

    public void setMedicamente(Medicament medicamente) {
        this.medicamente = medicamente;
    }

    public Duration getDurata() {
        return durata;
    }

    public void setDurata(Duration durata) {
        this.durata = durata;
    }

    public String toString(){
        return "Medic " + medic + ", Pacient " + pacient + ", Data Prescrierii: " + dataPrescrierii +
                ", Medicamente: " + medicamente + ", Durata: " + durata;
    }
}
