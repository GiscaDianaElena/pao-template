package ro.pao.model;

import lombok.experimental.SuperBuilder;
import ro.pao.model.Programare;
import lombok.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.jetbrains.annotations.Contract;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@SuperBuilder

public sealed class Medici extends Persoana permits ORL_MEDIC, Cardiolog, Oftalmolog {
    private String data_angajare;
    private Integer experienta;
    private double salariu;
    private List<Programare> programareList = new ArrayList<>();

    public void addProgramare(Programare programare) {
        programareList.add(programare);
    }

    public Medici(Medici medici) {
        this.idPersoana = medici.idPersoana;
        this.nume = medici.nume;
        this.prenume = medici.prenume;
        this.experienta = medici.experienta;
        this.data_angajare = medici.data_angajare;
        this.salariu = medici.salariu;
        this.email = medici.email;
        this.CNP = medici.CNP;
        this.numarTelefon = medici.numarTelefon;
        this.programareList = new ArrayList<>(medici.programareList);
    }

    public void arataProgramare(){
        for(int i = 0; i < programareList.size(); i++){

            System.out.println(programareList.get(i).obtinePret());
        }
    }

    public void stergeProgramare(String data){
        programareList = programareList.stream()
                .filter(element -> !data.equals(element.getData()))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Medic " + getIdPersoana()+": "+ getPrenume() + " " + getNume() + ": " + " email: " + getEmail()
                + ", CNP: " + getCNP() + ", numar telefon: " + getNumarTelefon() + ", adresa: "+getAdresa()
                + ", data angajare: " + data_angajare + ", experienta: " + experienta
                + ", salariu: " + salariu + ", Programari: " + programareList;
    }

    public void removeProgramare(String data) {
    }

    public void showProgramare() {
    }
}