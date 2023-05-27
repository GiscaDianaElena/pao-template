package ro.pao.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder

public class ServiciiMedicale {
    private String numeServiciu;
    private String descriere;
    private double cost;
    private int durata;
    private String personalMedical;
    private String echipament;
    private Date disponibilitate;

    public ServiciiMedicale(String numeServiciu, String descriere, double cost, int durata,
                            String personalMedical, String echipament, Date disponibilitate){
        this.numeServiciu = numeServiciu;
        this.descriere = descriere;
        this.cost = cost;
        this.durata = durata;
        this.personalMedical = personalMedical;
        this.echipament = echipament;
        this.disponibilitate = disponibilitate;
    }

    public String getNumeServiciu() {
        return numeServiciu;
    }

    public void setNumeServiciu(String numeServiciu) {
        this.numeServiciu = numeServiciu;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public String getPersonalMedical() {
        return personalMedical;
    }

    public void setPersonalMedical(String personalMedical) {
        this.personalMedical = personalMedical;
    }

    public String getEchipament() {
        return echipament;
    }

    public void setEchipament(String echipament) {
        this.echipament = echipament;
    }

    public Date getDisponibilitate() {
        return disponibilitate;
    }

    public void setDisponibilitate(Date disponibilitate) {
        this.disponibilitate = disponibilitate;
    }

    public String toString(){
        return "Nume Serviciu " + numeServiciu + ", Descriere " + descriere + ", Cost " + cost +
                ", Durata " + durata + ", Personal Medical " + personalMedical + ", Echipament " + echipament +
                ", Disponibilitate " + disponibilitate;
    }
}
