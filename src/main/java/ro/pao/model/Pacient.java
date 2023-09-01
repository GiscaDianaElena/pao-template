package ro.pao.model;
import  ro.pao.model.Programare;
import ro.pao.model.Tratament;
import lombok.experimental.SuperBuilder;
import lombok.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@SuperBuilder

public class Pacient extends Persoana {
    private String status;
    private String boala;
    private String GrupaSange;
    private String AsigurareMedicala;
    private Tratament tratament;

    private Programare programare;

    @Override
    public String toString() {
        return "Pacient " + getPrenume() + " " + getNume() + ": " + ", email: " + getEmail()
                + ", CNP: " + getCNP() + ", numar telefon: " + getNumarTelefon() + ", adresa: "
                + getAdresa() +", status: " + status + ", boala: " + boala
                + "GrupaSange: " + GrupaSange + ", asigurare medicala: " + AsigurareMedicala
                + "tratament: " + tratament;
    }

    public Pacient(String status, String boala, String GrupaSange, String AsigurareMedicala, Tratament tratament) {
        this.status = status;
        this.boala = boala;
        this.GrupaSange = GrupaSange;
        this.AsigurareMedicala = AsigurareMedicala;
        this.tratament = tratament;
    }
}