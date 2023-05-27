package ro.pao.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder

public class Medici {
    private String nume;
    private String prenume;
    private Specializare specializare;
    private String titlu;
    private double experienta;
    private Adresa adresa;
    private String numarTelefon;

    public Medici(String nume, String prenume, Specializare specializare, String titlu, double experienta,
                  Adresa adresa, String numarTelefon){
        this.nume = nume;
        this.prenume = prenume;
        this.specializare = specializare;
        this.titlu = titlu;
        this.experienta = experienta;
        this.adresa = adresa;
        this.numarTelefon = numarTelefon;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public Specializare getSpecializare() {
        return specializare;
    }

    public void setSpecializare(Specializare specializare) {
        this.specializare = specializare;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public static double getExperienta() {
        return experienta;
    }

    public void setExperienta(double experienta) {
        this.experienta = experienta;
    }

    public Adresa getAdresa() {
        return adresa;
    }

    public void setAdresa(Adresa adresa) {
        this.adresa = adresa;
    }

    public String getNumarTelefon() {
        return numarTelefon;
    }

    public void setNumarTelefon(String numarTelefon) {
        this.numarTelefon = numarTelefon;
    }

    public String toString(){
        return "Nume: " + nume + ", Prenume: " + prenume + ", Specializare: " + specializare +
                ", Titlu: " + titlu + ", Experienta: " + experienta + ", Adresa: " + adresa +
                ", Numar Telefon: " + numarTelefon;
    }

    public static <T> double getExperienta(T t) {
        return null
    }
}
