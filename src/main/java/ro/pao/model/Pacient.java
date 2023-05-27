package ro.pao.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@EqualsAndHashCode
@ToString

public class Pacient {
    private String nume;
    private String prenume;
    private LocalDate dataNastere;
    private Gen gen;
    private Adresa adresa;
    private String numarTelefon;
    private boolean asigurareMedicala;
    private ArrayList<Programare> programari = new ArrayList<>();

    public Pacient(String nume, String prenume, LocalDate dataNastere, Gen gen, Adresa adresa, String numarTelefon,
                   boolean asigurareMedicala){
        this.nume = nume;
        this.prenume = prenume;
        this.dataNastere = dataNastere;
        this.gen = gen;
        this.adresa = adresa;
        this.numarTelefon = numarTelefon;
        this.asigurareMedicala = asigurareMedicala;
    }

    public static Object builder() {
        return 0;
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

    public LocalDate getDataNastere() {
        return dataNastere;
    }

    public void setDataNastere(LocalDate dataNastere) {
        this.dataNastere = dataNastere;
    }

    public Gen getGen() {
        return gen;
    }

    public void setGen(Gen gen) {
        this.gen = gen;
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

    public boolean isAsigurareMedicala() {
        return asigurareMedicala;
    }

    public void setAsigurareMedicala(boolean asigurareMedicala) {
        this.asigurareMedicala = asigurareMedicala;
    }

    public List<Programare> getProgramari() {
        return programari;
    }

    public void setProgramari(List<Programare> programari) {
        this.programari = (ArrayList<Programare>) programari;
    }

    // Metode de adaugare si stergere a programarilor
    public void adaugaProgramare(Programare programare){
        programari.add(programare);
    }

    public void stergeProgramare(Programare programare){
        programari.remove(programare);
    }

    public String toString(){
        return "Nume: " + nume + ", Prenume: " + prenume + ", Data Nastere " + dataNastere +
                ", Gen: " + gen + ", Adresa " + adresa + ", Numar Telefon: " + numarTelefon +
                ", Asigurare Medicala: " + asigurareMedicala;
    }
}
