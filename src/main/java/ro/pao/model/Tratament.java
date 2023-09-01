package ro.pao.model;

import lombok.*;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder

public class Tratament {
    private UUID idTratament;
    private String nume;
    private Date dataPrescrierii;
    private List<Medicament> medicamentList;

    public Tratament(UUID idTratament, String nume, Date dataPrescrierii, List<Medicament> medicamentList){
        this.idTratament = idTratament;
        this.nume = nume;
        this.dataPrescrierii = dataPrescrierii;
        this.medicamentList = medicamentList;
    }

    @Override
    public String toString() {
        return "Tratament: " + idTratament + ", Nume: " + nume + ", Data prescrierii: " + dataPrescrierii +
                ", Lista Medicamente: " + medicamentList;
    }
}



    /*
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
     */