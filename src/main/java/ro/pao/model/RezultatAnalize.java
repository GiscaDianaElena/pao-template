package ro.pao.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder

public class RezultatAnalize {
    private Pacient pacient;
    private Medici medic;
    private LocalDate data;
    private String tipAnalize;
    private String rezultate;

    public RezultatAnalize(Pacient pacient, Medici medic, LocalDate data, String tipAnalize, String rezultate){
        this.pacient = pacient;
        this.medic = medic;
        this.data = data;
        this.tipAnalize = tipAnalize;
        this.rezultate = rezultate;
    }

    public Pacient getPacient() {
        return pacient;
    }

    public void setPacient(Pacient pacient) {
        this.pacient = pacient;
    }

    public Medici getMedic() {
        return medic;
    }

    public void setMedic(Medici medic) {
        this.medic = medic;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getTipAnalize() {
        return tipAnalize;
    }

    public void setTipAnalize(String tipAnalize) {
        this.tipAnalize = tipAnalize;
    }

    public String getRezultate() {
        return rezultate;
    }

    public void setRezultate(String rezultate) {
        this.rezultate = rezultate;
    }

    public String toString(){
        return "Pacient " + pacient + ", Medic: " + medic + ", Data: " + data +
                ", Tip Analize " + tipAnalize + ", Rezultate: " + rezultate;
    }
}
